/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.controller.blog.assembler;

import com.lsz.blog.query.BlogQuery;
import com.lsz.controller.blog.request.QueryBlogRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lishuzeng
 * @version : BlogQueryAssembler.java, v 0.1 2023年03月04日 下午5:28 lishuzeng Exp $
 */
@Mapper
public interface BlogQueryAssembler {

    BlogQueryAssembler INSTANCE = Mappers.getMapper(BlogQueryAssembler.class);

    BlogQuery toBlogQuery(QueryBlogRequest request);

}