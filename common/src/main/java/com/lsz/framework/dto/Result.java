/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.dto;

import java.io.Serializable;

/**
 * @author lishuzeng
 * @version : Result.java, v 0.1 2023年03月04日 下午7:14 lishuzeng Exp $
 */
public class Result<T> implements Serializable {

    private String code;

    private String message;

    private boolean isSuccess;

    private boolean isNeedRetry;

    private T t;

    public static <T> Result ofSuccess(T t) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setNeedRetry(false);
        result.setT(t);
        return result;
    }

    public static <T> Result ofFail(String code, String message, boolean isNeedRetry) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setNeedRetry(isNeedRetry);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public boolean isNeedRetry() {
        return isNeedRetry;
    }

    public void setNeedRetry(boolean needRetry) {
        isNeedRetry = needRetry;
    }
}