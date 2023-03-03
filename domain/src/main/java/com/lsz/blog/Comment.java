package com.lsz.blog;

import com.lsz.framework.valueobject.Day;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午12:11
 * @Version 1.0.0
 **/
public class Comment {

    private String commentId;

    private String userId;

    private String blogId;

    private String commentContent;

    private CommentStatusEnum status = CommentStatusEnum.PUBLISH;

    private Day gmtCreate;

    private Day gmtModified;

    public Comment(String userId, String blogId, Day gmtCreate, Day gmtModified) {
        this.userId = userId;
        this.blogId = blogId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void publish() {
        this.status = CommentStatusEnum.PUBLISH;
    }
}
