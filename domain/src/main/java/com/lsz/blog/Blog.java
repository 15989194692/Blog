package com.lsz.blog;

import com.lsz.valueobject.Day;
import com.lsz.valueobject.UserId;

import java.util.List;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:00
 * @Version 1.0.0
 **/
public class Blog {

    private String blogId;

    private UserId userId;

    private String blogTitle;

    private String blogContent;

    private BlogStatusEnum status;

    private List<Comment> commentList;

    private Day gmtCreate;

    private Day gmtModified;

    public Blog(UserId userId, Day gmtCreate, Day gmtModified) {
        this.userId = userId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public boolean isPublish() {
        return status.isPublish();
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public void setStatus(BlogStatusEnum status) {
        this.status = status;
    }




}
