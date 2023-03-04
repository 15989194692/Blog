/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.persistence.blog.converter;

import com.lsz.blog.domain.Blog;
import com.lsz.blog.enums.BlogStatusEnum;
import com.lsz.framework.valueobject.UserId;
import com.lsz.persistence.blog.dataobject.BlogDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author lishuzeng
 * @version : BlogDoConverter.java, v 0.1 2023年03月03日 下午3:42 lishuzeng Exp $
 */
@Mapper(imports = {UserId.class, BlogStatusEnum.class})
public interface BlogDoConverter {

    BlogDoConverter INSTANCE = Mappers.getMapper(BlogDoConverter.class);

    @Mapping(target = "userId", expression = "java(UserId.of(blogDo.getUserId()))")
    @Mapping(target = "gmtCreate", expression = "java(Day.of(blogDo.getGmtCreate()))")
    @Mapping(target = "gmtModified", expression = "java(Day.of(blogDo.getGmtModified()))")
    Blog toEntity(BlogDo blogDo);

    @Mapping(target = "userId", source = "blog.userId.id")
    @Mapping(target = "gmtCreate", source = "blog.gmtCreate.date")
    @Mapping(target = "gmtModified", source = "blog.gmtModified.date")
    BlogDo toDo(Blog blog);



}