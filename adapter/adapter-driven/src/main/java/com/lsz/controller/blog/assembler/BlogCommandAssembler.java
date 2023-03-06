/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.controller.blog.assembler;

import com.lsz.blog.command.CommentBlogCommand;
import com.lsz.blog.command.CreateBlogCommand;
import com.lsz.blog.command.DeleteBlogCommand;
import com.lsz.blog.command.DeleteBlogCommentCommand;
import com.lsz.controller.blog.request.CommentBlogRequest;
import com.lsz.controller.blog.request.CreateBlogRequest;
import com.lsz.controller.blog.request.DeleteBlogCommentRequest;
import com.lsz.controller.blog.request.DeleteBlogRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lishuzeng
 * @version : BlogCommandAssembler.java, v 0.1 2023年03月04日 下午5:15 lishuzeng Exp $
 */
@Mapper
public interface BlogCommandAssembler {

    BlogCommandAssembler INSTANCE = Mappers.getMapper(BlogCommandAssembler.class);


    CreateBlogCommand toCreateBlogCommand(CreateBlogRequest request);


    DeleteBlogCommand toDeleteBlogCommand(DeleteBlogRequest request);

    CommentBlogCommand toCommentBlogCommand(CommentBlogRequest request);

    DeleteBlogCommentCommand toDeleteBlogCommentCommand(DeleteBlogCommentRequest request);
}