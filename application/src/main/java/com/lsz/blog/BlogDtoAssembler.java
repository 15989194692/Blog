package com.lsz.blog;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName BlogDtoAssembler
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:55
 * @Version 1.0.0
 **/
@Mapper
public interface BlogDtoAssembler {

    BlogDtoAssembler INSTANCE = Mappers.getMapper(BlogDtoAssembler.class);

    CreateBlogDto toCreateBlogDto(Blog blog);


    CommentBlogDto toCommentBlogDto(Blog blog);

}
