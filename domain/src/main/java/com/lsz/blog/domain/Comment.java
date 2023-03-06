package com.lsz.blog.domain;

import com.lsz.blog.enums.CommentStatusEnum;
import com.lsz.framework.domain.AggregateRoot;
import com.lsz.framework.valueobject.Day;
import com.lsz.framework.valueobject.UserId;
import org.springframework.util.Assert;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午12:11
 * @Version 1.0.0
 **/
public class Comment extends AggregateRoot {

    private Long id;

    private String commentId;

    private UserId userId;

    private String blogId;

    private String parentCommentId;

    private String commentContent;

    private CommentStatusEnum status = CommentStatusEnum.PUBLISH;

    public Comment(String commentId, UserId userId, String blogId, Day gmtCreate, Day gmtModified) {
        super(gmtCreate, gmtModified);
        this.commentId = commentId;
        this.userId = userId;
        this.blogId = blogId;
    }

    public boolean isDelete() {
        return status.isDelete();
    }

    public boolean isPublish() {
        return status.isPublish();
    }

    public void deleteComment(String userId) {
        Assert.isTrue(this.userId.isSameId(userId),
                "only can delete your own comment, operate delete userId: " + userId
                        + ", comment belong to userId: " + this.userId.getId());
        Assert.isTrue(!isDelete(), "can not delete again, comment: " + this);
        this.status = CommentStatusEnum.DELETE;
        this.toUpdate();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(CommentStatusEnum status) {
        this.status = status;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void publish() {
        this.status = CommentStatusEnum.PUBLISH;
    }

    public Long getId() {
        return id;
    }

    public String getCommentId() {
        return commentId;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getBlogId() {
        return blogId;
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public CommentStatusEnum getStatus() {
        return status;
    }

}
