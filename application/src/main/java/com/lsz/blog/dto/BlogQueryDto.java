/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.dto;

import java.util.List;

/**
 * @author lishuzeng
 * @version : BlogQueryDto.java, v 0.1 2023年03月04日 下午5:30 lishuzeng Exp $
 */
public class BlogQueryDto {
    private List<BlogDto> blogDtoList;

    public List<BlogDto> getBlogDtoList() {
        return blogDtoList;
    }

    public void setBlogDtoList(List<BlogDto> blogDtoList) {
        this.blogDtoList = blogDtoList;
    }
}