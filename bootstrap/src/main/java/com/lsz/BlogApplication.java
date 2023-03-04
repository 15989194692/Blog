/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lishuzeng
 * @version : BlogApplication.java, v 0.1 2023年03月03日 下午4:02 lishuzeng Exp $
 */
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = "com.lsz.persistence")
public class BlogApplication {


    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}