package com.lsz.blog.command;

/**
 * @ClassName CreateBlogCommand
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:41
 * @Version 1.0.0
 **/
public class CreateBlogCommand {


    private String blogTitle;

    private String blogContent;

    private String status;

    private String userId;

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
