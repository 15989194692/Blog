/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.dto;

import java.util.List;

/**
 * @author lishuzeng
 * @version : BlogDto.java, v 0.1 2023年03月04日 下午5:30 lishuzeng Exp $
 */
public class BlogDto {

    private String blogId;

    private String blogTitle;

    private String blogContent;

    private String status;

    private String userId;

    private List<CommentDto> commentDtoList;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CommentDto> getCommentDtoList() {
        return commentDtoList;
    }

    public void setCommentDtoList(List<CommentDto> commentDtoList) {
        this.commentDtoList = commentDtoList;
    }
}