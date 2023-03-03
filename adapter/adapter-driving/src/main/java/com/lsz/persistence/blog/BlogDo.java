/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.persistence.blog;

import com.lsz.persistence.AuditableDo;

/**
 * @author lishuzeng
 * @version : BlogDo.java, v 0.1 2023年03月03日 下午3:41 lishuzeng Exp $
 */
public class BlogDo extends AuditableDo {

    private String blogId;

    private String blogTitle;

    private String blogContent;

    private String userId;

    private String status;


    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}