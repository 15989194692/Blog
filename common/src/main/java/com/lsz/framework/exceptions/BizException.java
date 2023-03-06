/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.exceptions;

/**
 * @author lishuzeng
 * @version : BizException.java, v 0.1 2023年03月04日 下午6:48 lishuzeng Exp $
 */
public class BizException extends AbstractException {


    public BizException(String errorCode, String errorMessage, Throwable cause, String bizScene) {
        super(errorCode, errorMessage, cause);
    }

    public BizException(BizExceptionMessage bizExceptionMessage) {
        super(bizExceptionMessage);
    }
}