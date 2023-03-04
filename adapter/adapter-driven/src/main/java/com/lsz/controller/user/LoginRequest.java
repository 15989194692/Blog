/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.controller.user;

import com.lsz.framework.dto.AbstractWriteRequest;

/**
 * @author lishuzeng
 * @version : LoginRequest.java, v 0.1 2023年03月04日 下午4:30 lishuzeng Exp $
 */
public class LoginRequest extends AbstractWriteRequest {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}