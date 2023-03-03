/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.domain;

import com.lsz.framework.valueobject.Day;

/**
 * @author lishuzeng
 * @version : AggregateRoot.java, v 0.1 2023年03月03日 下午3:33 lishuzeng Exp $
 */
public class AggregateRoot extends AuditableEntity {

    /**
     * 数据版本，用于乐观锁
     */
    private Long version;

    public AggregateRoot(Day gmtCreate, Day gmtModified) {
        super(gmtCreate, gmtModified);
    }

}