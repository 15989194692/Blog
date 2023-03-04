/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.command;

/**
 * @author lishuzeng
 * @version : DeleteBlogCommand.java, v 0.1 2023年03月04日 下午6:01 lishuzeng Exp $
 */
public class DeleteBlogCommand {

    private String blogId;

    private String userId;

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
}