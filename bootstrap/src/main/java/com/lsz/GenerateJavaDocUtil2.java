package com.lsz;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class GenerateJavaDocUtil2 {

    private static Set<String> primitiveTypes = new HashSet<>();

    static {
        primitiveTypes.add("byte");
        primitiveTypes.add("short");
        primitiveTypes.add("int");
        primitiveTypes.add("long");
        primitiveTypes.add("float");
        primitiveTypes.add("double");
        primitiveTypes.add("char");
        primitiveTypes.add("boolean");
        primitiveTypes.add("void");
        primitiveTypes.add("String");  // Add common class types if needed
    }
    
    private static JavaParser javaParser = new JavaParser();

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        Path applicationBasePath = Paths.get(userDir, "application/src/main/java");
        Path bootstrapBasePath = Paths.get(userDir, "bootstrap/src/main/java");
        Path domainBasePath = Paths.get(userDir, "domain/src/main/java");
        Path commonBasePath = Paths.get(userDir, "common/src/main/java");

        // 初始化 TypeSolver
        TypeSolver typeSolver = new CombinedTypeSolver(
                new ReflectionTypeSolver(),
                new JavaParserTypeSolver(applicationBasePath.toFile()),
                new JavaParserTypeSolver(domainBasePath.toFile()),
                new JavaParserTypeSolver(commonBasePath.toFile()),
                new JavaParserTypeSolver(bootstrapBasePath.toFile())
        );
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
        javaParser.getParserConfiguration().setSymbolResolver(symbolSolver);

        // 输入源代码文件路径
        File sourceFile = new File("/Users/lsz/work/ideaproject/lsz/Blog/application/src/main/java/com/lsz/blog/BlogService.java");

        try {
            // 解析源代码文件
            CompilationUnit cu = javaParser.parse(sourceFile).getResult().get();

            StringBuilder sb = new StringBuilder();

            // 提取类注释
            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(cls -> {
                sb.append("# ").append(cls.getNameAsString()).append("\n");
                Optional<Comment> classComment = cls.getComment();
                classComment.ifPresent(comment -> sb.append(comment.getContent().trim()).append("\n\n"));

                // 提取字段注释
                cls.findAll(FieldDeclaration.class).forEach(field -> {
                    sb.append("## Field: ").append(field.getVariable(0).getNameAsString()).append("\n");
                    Optional<JavadocComment> fieldJavadoc = field.getJavadocComment();
                    fieldJavadoc.ifPresent(javadoc -> sb.append(javadoc.parse().getDescription()).append("\n\n"));
                });

                // 提取方法注释
                cls.findAll(MethodDeclaration.class).forEach(method -> {
                    sb.append("## Method: ").append(method.getNameAsString()).append("\n");
                    Optional<JavadocComment> methodJavadoc = method.getJavadocComment();
                    methodJavadoc.ifPresent(javadoc -> sb.append(javadoc.parse().getDescription()).append("\n\n"));

                    // 提取方法参数
                    sb.append("| Parameter | Type | Description |\n");
                    sb.append("|-----------|------|-------------|\n");
                    method.getParameters().forEach(param -> {
                        String paramName = param.getNameAsString();
                        String paramType = param.getType().asString();
                        String paramDescription = param.getComment().map(Comment::getContent).orElse("No description available.");
                        sb.append("| ").append(paramName).append(" | ").append(paramType).append(" | ").append(paramDescription).append(" |\n");

                        // 如果是POJO类型，进一步解析
                        if (!isPrimitive(paramType)) {
                            parseType(param.getType(), sb);
                        }
                    });
                    sb.append("\n");

                    // 检查返回类型
                    Type returnType = method.getType();
                    if (!isPrimitive(returnType.asString())) {
                        sb.append("### Return Type: ").append(returnType.asString()).append("\n");
                        parseType(returnType, sb);
                    }
                });
            });

            // 将提取的内容写入Markdown文档
            try (FileWriter writer = new FileWriter("SampleApi_API_Documentation2.md")) {
                writer.write(sb.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrimitive(String type) {
        return primitiveTypes.contains(type);
    }


    private static void parseType(Type type, StringBuilder sb) {
        if (type instanceof ClassOrInterfaceType) {
            ClassOrInterfaceType classType = (ClassOrInterfaceType) type;
            String typeName = classType.getNameAsString();

            // 处理List或Map类型
            if ("List".equals(typeName) && classType.getTypeArguments().isPresent()) {
                Type argumentType = classType.getTypeArguments().get().get(0);
                if (!isPrimitive(argumentType.asString())) {
                    sb.append("### List Element: ").append(argumentType.asString()).append("\n");
                    parsePojo(argumentType, sb);
                }
            } else if ("Map".equals(typeName) && classType.getTypeArguments().isPresent()) {
                Type keyType = classType.getTypeArguments().get().get(0);
                Type valueType = classType.getTypeArguments().get().get(1);
                if (!isPrimitive(keyType.asString())) {
                    sb.append("### Map Key: ").append(keyType.asString()).append("\n");
                    parsePojo(keyType, sb);
                }
                if (!isPrimitive(valueType.asString())) {
                    sb.append("### Map Value: ").append(valueType.asString()).append("\n");
                    parsePojo(classType, sb);
                }
            } else if (!isPrimitive(typeName)) {
                parsePojo(classType, sb);
            }
        }
    }

    private static void parsePojo(Type classType, StringBuilder sb) {
        try {

            ResolvedReferenceType resolvedType = classType.resolve().asReferenceType();
            String fullyQualifiedName = resolvedType.getQualifiedName();

            File pojoFile = getClassFile(Class.forName(fullyQualifiedName));
            Optional<CompilationUnit> result = javaParser.parse(pojoFile).getResult();
            if (!result.isPresent()) {
                throw new RuntimeException("Failed to parse POJO file: " + pojoFile);
            }
            CompilationUnit pojoCu = result.get();

            pojoCu.findAll(ClassOrInterfaceDeclaration.class).forEach(pojoCls -> {
                sb.append("## POJO: ").append(pojoCls.getNameAsString()).append("\n");
                Optional<Comment> classComment = pojoCls.getComment();
                classComment.ifPresent(comment -> sb.append(comment.getContent().trim()).append("\n\n"));

                // 提取POJO字段注释
                pojoCls.findAll(FieldDeclaration.class).forEach(field -> {
                    sb.append("### Field: ").append(field.getVariable(0).getNameAsString()).append("\n");
                    Optional<JavadocComment> fieldJavadoc = field.getJavadocComment();
                    fieldJavadoc.ifPresent(javadoc -> sb.append(javadoc.parse().getDescription()).append("\n\n"));
                });
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过类加载器获取类的文件路径
     *
     * @param clazz 要获取路径的类
     * @return 类文件的 File 对象
     * @throws IOException 如果发生 I/O 错误
     */
    public static File getClassFile(Class<?> clazz) throws IOException {
        String className = clazz.getName();
        String classFile = className.replace('.', '/') + ".class";
        ClassLoader classLoader = clazz.getClassLoader();
        if (classLoader == null) {
            throw new RuntimeException("Class " + className + " not found");
        }
        URL classUrl = Objects.requireNonNull(classLoader.getResource(classFile), "Class " + className + " not found");

        // 转换 URL 为文件路径
        String decodedUrl = URLDecoder.decode(replaceToJavaPath(classUrl));
        return Paths.get(decodedUrl).toFile();
    }


    private static String replaceToJavaPath(URL classUrl) {
        return classUrl.getFile().replaceFirst("target/classes", "src/main/java").replaceFirst(".class", ".java");
    }
}
