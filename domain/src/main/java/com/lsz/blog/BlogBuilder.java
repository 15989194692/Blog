package com.lsz.blog;

import com.lsz.framework.valueobject.Day;
import com.lsz.framework.valueobject.UserId;

import java.util.Date;

/**
 * @ClassName BlogBuilder
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午8:43
 * @Version 1.0.0
 **/
public class BlogBuilder {


    private final String blogId;

    private String blogTitle;

    private String blogContent;

    private String status;

    private String userId;


    BlogBuilder(String blogId) {
        this.blogId = blogId;
    }

    public BlogBuilder blogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
        return this;
    }


    public BlogBuilder blogContent(String blogContent) {
        this.blogContent = blogContent;
        return this;
    }


    public BlogBuilder status(String status) {
        this.status = status;
        return this;
    }

    public BlogBuilder userId(String userId) {
        this.userId = userId;
        return this;
    }

    public Blog build() {
        Date now = new Date();
        Blog blog = new Blog(UserId.of(userId), Day.of(now), Day.of(now));
        blog.setBlogId(blogId);
        blog.setBlogTitle(blogTitle);
        blog.setBlogContent(blogContent);
        blog.setStatus(BlogStatusEnum.valueOf(status));
        return blog;
    }

}
