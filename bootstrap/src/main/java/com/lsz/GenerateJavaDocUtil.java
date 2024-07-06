package com.lsz;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class GenerateJavaDocUtil {

    public static void main(String[] args) {
        // 输入源代码文件路径
        File sourceFile = new File("/Users/lsz/work/ideaproject/lsz/Blog/application/src/main/java/com/lsz/blog/BlogService.java");

        try {
            // 解析源代码文件
            CompilationUnit cu = new JavaParser().parse(sourceFile).getResult().get();

            StringBuilder sb = new StringBuilder();

            // 提取类注释
            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(cls -> {
                sb.append("# ").append(cls.getNameAsString()).append("\n");
                Optional<JavadocComment> classJavadoc = cls.getJavadocComment();
                classJavadoc.ifPresent(javadoc -> sb.append(javadoc.parse().getDescription()).append("\n\n"));

                // 提取方法注释
                cls.findAll(MethodDeclaration.class).forEach(method -> {
                    sb.append("## ").append(method.getNameAsString()).append("\n");
                    Optional<JavadocComment> methodJavadoc = method.getJavadocComment();
                    methodJavadoc.ifPresent(javadoc -> sb.append(javadoc.parse().getDescription()).append("\n\n"));

                    // 提取方法参数
                    sb.append("| Parameter | Type | Description |\n");
                    sb.append("|-----------|------|-------------|\n");
                    method.getParameters().forEach(param -> {
                        String paramName = param.getNameAsString();
                        String paramType = param.getType().asString();
                        Optional<Comment> paramJavadoc = param.getComment();
                        sb.append("| ").append(paramName).append(" | ").append(paramType).append(" | ");
                        if (paramJavadoc.isPresent()) {
                            sb.append(paramJavadoc.get().getContent());
                        } else {
                            sb.append("No description available.");
                        }
                        sb.append(" |\n");
                    });
                    sb.append("\n");
                });
            });

            // 将提取的内容写入Markdown文档
            try (FileWriter writer = new FileWriter("SampleApi_API_Documentation.md")) {
                writer.write(sb.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
