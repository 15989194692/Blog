/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.user;

import com.lsz.framework.policy.EncodePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author lishuzeng
 * @version : PasswordServiceImpl.java, v 0.1 2023年03月03日 下午12:44 lishuzeng Exp $
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    private static final String SPLIT = "_";

    @Autowired
    @Qualifier("md5EncodePolicy")
    private EncodePolicy<String, String> encodePolicy;

    public String encryptPassword(String password, String salt) {
        return encodePolicy.encode(appendSalt(password, salt));
    }

    @Override
    public boolean checkPassword(String inputPassword, User user) {
        String encrypt = encryptPassword(inputPassword, user.getPassword().getSalt());
        return user.isSamePassword(encrypt);
    }

    private String appendSalt(String password, String salt) {
        return password + SPLIT + salt;
    }
}