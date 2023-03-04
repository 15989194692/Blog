/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.controller.blog.request;

import com.lsz.framework.dto.AbstractWriteRequest;

/**
 * @author lishuzeng
 * @version : DeleteBlogRequest.java, v 0.1 2023年03月04日 下午5:23 lishuzeng Exp $
 */
public class DeleteBlogRequest extends AbstractWriteRequest {

    private String userId;

    private String blogId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}