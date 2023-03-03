/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.user;

/**
 * @author lishuzeng
 * @version : PasswordService.java, v 0.1 2023年03月03日 下午12:43 lishuzeng Exp $
 */
public interface PasswordService {


    String encryptPassword(String password, String salt);

    boolean checkPassword(String inputPassword, User user);

}