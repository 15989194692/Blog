/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.controller.blog.request;

import com.lsz.framework.dto.AbstractQueryRequest;

import java.util.List;

/**
 * @author lishuzeng
 * @version : QueryBlogRequest.java, v 0.1 2023年03月04日 下午5:25 lishuzeng Exp $
 */
public class QueryBlogRequest extends AbstractQueryRequest {

    private List<String> blogTile;

    private List<String> userId;

    private List<String> blogId;

    public List<String> getBlogTile() {
        return blogTile;
    }

    public void setBlogTile(List<String> blogTile) {
        this.blogTile = blogTile;
    }

    public List<String> getUserId() {
        return userId;
    }

    public void setUserId(List<String> userId) {
        this.userId = userId;
    }

    public List<String> getBlogId() {
        return blogId;
    }

    public void setBlogId(List<String> blogId) {
        this.blogId = blogId;
    }
}