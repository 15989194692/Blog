/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.exceptions;

/**
 * @author lishuzeng
 * @version : BizErrorCodeEnum.java, v 0.1 2023年03月04日 下午7:09 lishuzeng Exp $
 */
public enum BizErrorCodeEnum implements BizExceptionMessage {

    /**
     * 不能删除别人的博客
     */
    CAN_NOT_DELETE_OTHER_USER_BLOG("CAN_NOT_DELETE_OTHER_USER_BLOG", "0001", "can not delete outher user's blog", "can not delete outher user's blog"),

    ;


    private final String code;

    private final String errorCode;

    private final String errorMessage;

    private final String desc;

    BizErrorCodeEnum(String code, String errorCode, String errorMessage, String desc) {
        this.code = code;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.desc = desc;
    }


    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}