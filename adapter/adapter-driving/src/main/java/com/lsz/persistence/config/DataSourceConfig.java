/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.persistence.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author lishuzeng
 * @version : DataSourceConfig.java, v 0.1 2023年03月04日 上午11:34 lishuzeng Exp $
 */
@Configuration
public class DataSourceConfig {

    private final String PROPAGATION_REQUIRES_NEW = "PROPAGATION_REQUIRES_NEW";

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    @Bean("transactionTemplate")
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager arrangementTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(arrangementTransactionManager);
        return transactionTemplate;
    }


    @Bean("transactionNewTemplate")
    public TransactionTemplate transactionNewTemplate(DataSourceTransactionManager transactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        transactionTemplate.setPropagationBehaviorName(PROPAGATION_REQUIRES_NEW);
        return transactionTemplate;
    }

}