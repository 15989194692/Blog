package com.lsz.blog.enums;

public enum CommentStatusEnum {
    PUBLISH("PUBLISH"),

    DELETE("DELETE"),

    ;

    private final String code;


    CommentStatusEnum(String code) {
        this.code = code;
    }

    public boolean isDelete() {
        return this == DELETE;
    }

    public boolean isPublish() {
        return this == PUBLISH;
    }

    public String getCode() {
        return code;
    }
}
