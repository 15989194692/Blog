package com.lsz.blog;

public enum CommentStatusEnum {
    PUBLISH("PUBLISH"),



    ;

    private final String code;


    CommentStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
