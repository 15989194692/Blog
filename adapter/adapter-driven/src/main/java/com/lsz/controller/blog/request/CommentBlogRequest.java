/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.controller.blog.request;

import com.lsz.framework.dto.AbstractWriteRequest;

/**
 * @author lishuzeng
 * @version : CommentBlogRequest.java, v 0.1 2023年03月06日 上午10:40 lishuzeng Exp $
 */
public class CommentBlogRequest extends AbstractWriteRequest {

    private String blogId;

    private String userId;

    private String commentContent;

    private String parentCommentId;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }
}