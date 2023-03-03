package com.lsz.blog;

import com.lsz.valueobject.Day;
import com.lsz.valueobject.UserId;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public void addComment(String commentContent, String userId) {
        // 发布状态的帖子才可以评论
        Assert.assertTrue(isPublish());
        Date now = new Date();
        Comment comment = new Comment(userId, this.blogId, Day.of(now), Day.of(now));
        comment.publish();
        if (Objects.isNull(commentList)) {
            commentList = new ArrayList<>();
        }
        this.commentList.add(comment);
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
