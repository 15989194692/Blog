/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework;

import com.lsz.policy.EncodePolicy;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author lishuzeng
 * @version : Md5EncodePolicy.java, v 0.1 2023年03月03日 下午12:47 lishuzeng Exp $
 */
@Component
public class Md5EncodePolicy implements EncodePolicy<String, String> {

    @Override
    public String encode(String content) {
        return DigestUtils.md5DigestAsHex(content.getBytes());
    }
}