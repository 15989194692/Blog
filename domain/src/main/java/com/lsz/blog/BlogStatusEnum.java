package com.lsz.blog;

public enum BlogStatusEnum {

    PUBLISH("PUBLISH"),

    DELETE("DELETE"),

    ;
    private final String code;

    BlogStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean isPublish() {
        return this == PUBLISH;
    }
}
