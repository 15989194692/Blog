/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog;

import com.lsz.blog.domain.Comment;

/**
 * @author lishuzeng
 * @version : CommentRepository.java, v 0.1 2023年03月06日 上午10:36 lishuzeng Exp $
 */
public interface CommentRepository {
    boolean save(Comment comment);


    Comment queryById(String commentId);

}