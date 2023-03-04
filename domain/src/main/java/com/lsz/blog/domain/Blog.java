package com.lsz.blog.domain;

import com.lsz.blog.enums.BlogStatusEnum;
import com.lsz.framework.domain.AggregateRoot;
import com.lsz.framework.valueobject.Day;
import com.lsz.framework.valueobject.UserId;
import org.springframework.util.Assert;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:00
 * @Version 1.0.0
 **/
public class Blog extends AggregateRoot {

    private Long id;

    private String blogId;

    private UserId userId;

    private String blogTitle;

    private String blogContent;

    private BlogStatusEnum status;

    public Blog(UserId userId, Day gmtCreate, Day gmtModified) {
        super(gmtCreate, gmtModified);
        this.userId = userId;

    }

    public void delete(String userId) {
        Assert.isTrue(this.userId.isSameId(userId),
                "only can delete your own blog which operator'userId : " + userId
                        + ", blog belong to: " + this.userId);
        Assert.isTrue(!isDelete(), "can not delete again");
        this.status = BlogStatusEnum.DELETE;
        this.toUpdate();
    }

    public boolean isDelete() {
        return status.isDelete();
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

    public String getBlogId() {
        return blogId;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public BlogStatusEnum getStatus() {
        return status;
    }


}
