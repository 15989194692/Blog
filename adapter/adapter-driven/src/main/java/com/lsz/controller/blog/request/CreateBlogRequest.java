package com.lsz.controller.blog.request;

import com.lsz.framework.dto.AbstractWriteRequest;

/**
 * @ClassName CreateBlogRequest
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:17
 * @Version 1.0.0
 **/
public class CreateBlogRequest extends AbstractWriteRequest {

    private String blogTitle;

    private String blogContent;

    private String userId;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
