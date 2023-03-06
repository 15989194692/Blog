/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.validator;

import com.lsz.blog.BlogRepository;
import com.lsz.blog.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lishuzeng
 * @version : BlogValidatorImpl.java, v 0.1 2023年03月06日 上午10:18 lishuzeng Exp $
 */
@Service
public class BlogValidatorImpl implements BlogValidator {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public boolean blogShouldBePublish(String blogId) {
        Blog blog = blogRepository.queryById(blogId);
        return blog.isPublish();
    }
}