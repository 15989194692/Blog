/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.exceptions;

/**
 * @author lishuzeng
 * @version : BaseException.java, v 0.1 2023年03月04日 下午6:51 lishuzeng Exp $
 */
public abstract class AbstractException extends RuntimeException {

    protected static final String SPLITTER = ":";

    private String errorCode;

    private String errorMessage;

    public AbstractException(String errorCode, String errorMessage) {
        super(errorCode + SPLITTER + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public AbstractException(String errorCode, String errorMessage, Throwable cause) {
        super(errorCode + SPLITTER + errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public AbstractException(ExceptionMessage exceptionMessage) {
        this(exceptionMessage.getErrorCode(), exceptionMessage.getErrorMessage());
    }

    public AbstractException(ExceptionMessage exceptionMessage, Throwable cause) {
        this(exceptionMessage.getErrorCode(), exceptionMessage.getErrorMessage(), cause);
    }


}