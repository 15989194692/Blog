package com.lsz.controller.user;

import com.lsz.dto.AbstractWriteRequest;

/**
 * @ClassName RegisterUserRequest
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/3/2 下午11:03
 * @Version 1.0.0
 **/
public class RegisterUserRequest extends AbstractWriteRequest {

    private String userName;

    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
