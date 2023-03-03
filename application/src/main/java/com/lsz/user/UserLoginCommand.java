/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.user;

/**
 * @author lishuzeng
 * @version : UserLoginCommand.java, v 0.1 2023年03月03日 下午12:55 lishuzeng Exp $
 */
public class UserLoginCommand {


    private String username;

    private String userId;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}