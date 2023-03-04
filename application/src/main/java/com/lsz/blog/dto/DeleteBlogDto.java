/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.blog.dto;

/**
 * @author lishuzeng
 * @version : DeleteBlogDto.java, v 0.1 2023年03月04日 下午5:22 lishuzeng Exp $
 */
public class DeleteBlogDto {

    private boolean success;

    public DeleteBlogDto(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}