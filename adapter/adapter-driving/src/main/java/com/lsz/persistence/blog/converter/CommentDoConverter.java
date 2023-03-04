/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.persistence.blog.converter;

import com.lsz.blog.domain.Comment;
import com.lsz.persistence.blog.dataobject.CommentDo;

/**
 * @author lishuzeng
 * @version : CommentDoConverter.java, v 0.1 2023年03月04日 下午5:02 lishuzeng Exp $
 */
public interface CommentDoConverter {


    Comment toEntity(CommentDo commentDo);

    CommentDo toDo(Comment comment);

}