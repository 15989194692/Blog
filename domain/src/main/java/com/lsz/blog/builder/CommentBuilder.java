/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.builder;

import com.lsz.blog.domain.Comment;
import com.lsz.blog.enums.CommentStatusEnum;
import com.lsz.blog.validator.BlogValidator;
import com.lsz.framework.sequence.SequenceService;
import com.lsz.framework.sequence.SequenceTypeEnum;
import com.lsz.framework.valueobject.Day;
import com.lsz.framework.valueobject.UserId;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Objects;

/**
 * @author lishuzeng
 * @version : CommentBuilder.java, v 0.1 2023年03月06日 上午10:23 lishuzeng Exp $
 */
public class CommentBuilder {

    private final SequenceService sequenceService;

    private final BlogValidator blogValidator;


    CommentBuilder(SequenceService sequenceService, BlogValidator blogValidator) {
        this.sequenceService = sequenceService;
        this.blogValidator = blogValidator;
    }


    private String commentContent;

    private String status;

    private String blogId;

    private String userId;

    private String parentCommentId;


    public CommentBuilder commentContent(String commentContent){
        this.commentContent = commentContent;
        return this;
    }

    public CommentBuilder status(String status){
        this.status = status;
        return this;
    }

    public CommentBuilder blogId(String blogId){
        this.blogId = blogId;
        return this;
    }

    public CommentBuilder userId(String userId){
        this.userId = userId;
        return this;
    }

    public CommentBuilder parentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
        return this;
    }

    public Comment build() {
        Assert.notNull(userId, "userId can not be null");
        Assert.notNull(blogId, "blogId can not be null");
        boolean blogPublish = blogValidator.blogShouldBePublish(blogId);
        Assert.isTrue(blogPublish,
                "can not comment blog, cause by blog's status is not publish, blogId: " + blogId);
        String commentId = sequenceService.generateUniqueId(SequenceTypeEnum.COMMENT_ID);
        Date now = new Date();
        Comment comment = new Comment(commentId, UserId.of(userId), blogId, Day.of(now), Day.of(now));
        comment.setCommentContent(commentContent);
        if (Objects.nonNull(status)) {
            comment.setStatus(CommentStatusEnum.valueOf(status));
        }
        comment.setParentCommentId(parentCommentId);
        return comment;
    }

}