package com.lsz.framework.valueobject;

import java.util.Objects;

/**
 * @ClassName UserId
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:27
 * @Version 1.0.0
 **/
public class UserId {

    private String id;

    private UserId(String id) {
        this.id = id;
    }

    public static UserId of(String id) {
        Objects.requireNonNull(id);
        return new UserId(id);
    }

    public boolean isSameId(String userId) {
        return Objects.equals(id, userId);
    }

    public String getId() {
        return id;
    }
}
