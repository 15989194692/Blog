package com.lsz.blog.command;

/**
 * @ClassName CommentBlogCommand
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/3 上午9:14
 * @Version 1.0.0
 **/
public class CommentBlogCommand {
    private String blogId;

    private String userId;

    private String commentContent;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
