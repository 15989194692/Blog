package com.lsz.blog.command;


import com.lsz.blog.dto.BlogDto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName CreateBlogCommand
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:41
 * @Version 1.0.0
 **/
public class CreateBlogCommand {


    /**
     * 博客标题
     */
    @NotNull
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
    @NotNull
    private String userId;

    private List<BlogDto> test;

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

    public List<BlogDto> getTest() {
        return test;
    }

    public void setTest(List<BlogDto> test) {
        this.test = test;
    }
}
