/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.domain;

/**
 * @author lishuzeng
 * @version : ChangingStatusEnum.java, v 0.1 2023年03月03日 下午3:45 lishuzeng Exp $
 */
public enum ChangingStatusEnum {

    NEW("NEW"),

    UPDATE("UPDATE"),

    UN_CHANGE("UN_CHANGE"),

    DELETE("DELETE"),

    ;


    private final String code;

    ChangingStatusEnum(String code) {
        this.code = code;
    }

    public boolean isNew() {
        return this == NEW;
    }

    public boolean isUpdate() {
        return this == UPDATE;
    }

    public boolean isUnChange() {
        return this == UN_CHANGE;
    }

    public boolean isDelete() {
        return this == DELETE;
    }

    public String getCode() {
        return code;
    }
}