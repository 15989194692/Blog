package com.lsz.blog;

public enum BlogTypeEnum {

    PUBLISH("PUBLISH"),

    DELETE("DELETE"),

    ;
    private final String code;

    BlogTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
