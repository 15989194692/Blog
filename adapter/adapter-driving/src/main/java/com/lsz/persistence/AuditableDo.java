/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.persistence;

import java.util.Date;

/**
 * @author lishuzeng
 * @version : AuditableDo.java, v 0.1 2023年03月03日 下午3:40 lishuzeng Exp $
 */
public class AuditableDo {

    private Date gmtCreate;

    private Date gmtModified;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}