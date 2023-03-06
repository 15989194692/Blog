package com.lsz.framework.sequence;

public enum SequenceTypeEnum {

    USER_ID("USER_ID"),

    BLOG_ID("BLOG_ID"),

    COMMENT_ID("COMMENT_ID"),

    ;

    private final String code;

    SequenceTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
