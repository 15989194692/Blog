/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.persistence.blog;

import com.lsz.blog.CommentRepository;
import com.lsz.blog.domain.Comment;
import com.lsz.persistence.blog.converter.CommentDoConverter;
import com.lsz.persistence.blog.dataobject.CommentDo;
import com.lsz.persistence.blog.mappers.CommentDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lishuzeng
 * @version : CommentRepositoryJdbc.java, v 0.1 2023年03月06日 上午10:46 lishuzeng Exp $
 */
@Repository
public class CommentRepositoryJdbc implements CommentRepository {

    private CommentDoMapper commentDoMapper;

    @Autowired
    private CommentDoConverter commentDoConverter;

    @Override
    public boolean save(Comment comment) {
        CommentDo commentDo = toDo(comment);
        return commentDoMapper.insert(commentDo) == 1;
    }

    @Override
    public Comment queryById(String commentId) {
        CommentDo commentDo = commentDoMapper.selectByCommentId(commentId);
        return toEntity(commentDo);
    }


    private Comment toEntity(CommentDo commentDo){
        return commentDoConverter.toEntity(commentDo);
    }

    private CommentDo toDo(Comment comment) {
        return commentDoConverter.toDo(comment);
    }
}