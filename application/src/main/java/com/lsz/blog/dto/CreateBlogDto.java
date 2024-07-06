package com.lsz.blog.dto;

/**
 * @ClassName CreateBlogDto
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:42
 * @Version 1.0.0
 **/
public class CreateBlogDto {

    /**
     * 博客id
     */
    private String blogId;

    /**
     * 博客标题
     */
    private String blogTitle;

    /**
     * 博客内容
     */
    private String blogContent;

    /**
     * 博客状态
     */
    private String status;

    /**
     * 用户id
     */
    private String userId;

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
}
