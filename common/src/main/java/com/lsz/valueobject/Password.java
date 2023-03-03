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

    private final String salt;

    private Password(String password, String salt) {
        this.password = password;
        this.salt = salt;
    }

    public static Password of(String password, String salt) {
        return new Password(password, salt);
    }


    public boolean isSamePassword(String anotherPassword) {
        return Objects.equals(password, anotherPassword);
    }

    public boolean checkPassword(String anotherPassword) {
        return Objects.equals(password, anotherPassword);
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }
}
