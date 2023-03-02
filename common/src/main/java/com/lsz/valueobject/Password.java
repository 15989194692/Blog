package com.lsz.valueobject;

import com.lsz.policy.EncodePolicy;

import java.util.Objects;

/**
 * @ClassName Password
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:28
 * @Version 1.0.0
 **/
public class Password {

    private final String password;

    private Password(String password) {
        this.password = password;
    }

    public static Password of(String password) {
        return new Password(password);
    }

    public boolean checkPassword(String anotherPassword) {
        return Objects.equals(password, anotherPassword);
    }

    public String getPassword() {
        return password;
    }
}
