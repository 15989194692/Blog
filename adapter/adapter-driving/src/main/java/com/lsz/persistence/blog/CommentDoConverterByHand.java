/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.persistence.blog;

import com.lsz.blog.domain.Comment;
import com.lsz.blog.enums.CommentStatusEnum;
import com.lsz.framework.valueobject.Day;
import com.lsz.framework.valueobject.UserId;
import com.lsz.persistence.blog.converter.CommentDoConverter;
import com.lsz.persistence.blog.dataobject.CommentDo;
import org.springframework.stereotype.Component;

/**
 * @author lishuzeng
 * @version : CommentDoConverterByHand.java, v 0.1 2023年03月04日 下午5:02 lishuzeng Exp $
 */
@Component
public class CommentDoConverterByHand implements CommentDoConverter {


    @Override
    public Comment toEntity(CommentDo commentDo) {
        Comment comment = new Comment(commentDo.getCommentId(), UserId.of(commentDo.getUserId()),
                commentDo.getBlogId(), Day.of(commentDo.getGmtCreate()), Day.of(commentDo.getGmtModified()));
        comment.setCommentContent(commentDo.getCommentContent());
        comment.setStatus(CommentStatusEnum.valueOf(commentDo.getStatus()));
        comment.setParentCommentId(commentDo.getParentCommentId());
        comment.setId(commentDo.getId());
        return comment;
    }

    @Override
    public CommentDo toDo(Comment comment) {
        CommentDo commentDo = new CommentDo();
        commentDo.setId(comment.getId());
        commentDo.setCommentId(comment.getCommentId());
        commentDo.setUserId(comment.getUserId().getId());
        commentDo.setBlogId(comment.getBlogId());
        commentDo.setParentCommentId(comment.getParentCommentId());
        commentDo.setStatus(comment.getStatus().getCode());
        commentDo.setCommentContent(comment.getCommentContent());
        commentDo.setGmtCreate(comment.getGmtCreate().getDate());
        commentDo.setGmtModified(comment.getGmtModified().getDate());
        return commentDo;
    }
}