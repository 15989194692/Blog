/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.builder;

import com.lsz.blog.validator.BlogValidator;
import com.lsz.framework.sequence.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lishuzeng
 * @version : CommentBuilderFactoryImpl.java, v 0.1 2023年03月06日 上午10:23 lishuzeng Exp $
 */
@Service
public class CommentBuilderFactoryImpl implements CommentBuilderFactory {

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private BlogValidator blogValidator;

    @Override
    public CommentBuilder builder() {
        return new CommentBuilder(sequenceService, blogValidator);
    }
}