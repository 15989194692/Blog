package com.lsz.blog.assembler;

import com.lsz.blog.domain.Blog;
import com.lsz.blog.dto.*;
import com.lsz.blog.enums.BlogStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BlogDtoAssembler
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:55
 * @Version 1.0.0
 **/
@Mapper(imports = {BlogStatusEnum.class, Collectors.class})
public interface BlogDtoAssembler {

    BlogDtoAssembler INSTANCE = Mappers.getMapper(BlogDtoAssembler.class);

    @Mapping(target = "userId", source = "blog.userId.id")
    CreateBlogDto toCreateBlogDto(Blog blog);


    @Mapping(target = "userId", source = "blog.userId.id")
    CommentBlogDto toCommentBlogDto(Blog blog);


    DeleteBlogDto toDeleteBlogDto(Blog blog);

    @Mapping(target = "userId", source = "blog.userId.id")
    BlogDto toBlogDto(Blog blog);

}
