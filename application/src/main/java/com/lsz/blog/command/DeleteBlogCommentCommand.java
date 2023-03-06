/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.command;

/**
 * @author lishuzeng
 * @version : DeleteBlogCommentCommand.java, v 0.1 2023年03月06日 上午10:44 lishuzeng Exp $
 */
public class DeleteBlogCommentCommand {


    private String commentId;

    private String userId;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}