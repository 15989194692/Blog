/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.assembler;

import com.lsz.blog.domain.Comment;
import com.lsz.blog.dto.CommentBlogDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author lishuzeng
 * @version : CommentDtoAssembler.java, v 0.1 2023年03月06日 上午10:37 lishuzeng Exp $
 */
@Mapper
public interface CommentDtoAssembler {

    CommentDtoAssembler INSTANCE = Mappers.getMapper(CommentDtoAssembler.class);

    @Mapping(target = "userId", source = "comment.userId.id")
    CommentBlogDto toCommentBlogDto(Comment comment);

}