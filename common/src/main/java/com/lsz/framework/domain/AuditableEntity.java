/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.domain;

import com.lsz.framework.valueobject.Day;

/**
 * @author lishuzeng
 * @version : AuditableEntity.java, v 0.1 2023年03月03日 下午3:34 lishuzeng Exp $
 */
public class AuditableEntity {
    /**
     * 创建时间
     */
    private Day gmtCreate;

    /**
     * 修改时间
     */
    private Day gmtModified;

    private ChangingStatusEnum changingStatus = ChangingStatusEnum.NEW;

    public AuditableEntity() {

    }

    public AuditableEntity(Day gmtCreate, Day gmtModified) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }


    public boolean isNew() {
        return changingStatus.isNew();
    }

    public boolean isUpdate() {
        return changingStatus.isUpdate();
    }

    public boolean isUnChange() {
        return changingStatus.isUnChange();
    }

    public boolean isDelete() {
        return changingStatus.isDelete();
    }


    public void toUpdate() {
        this.changingStatus = ChangingStatusEnum.UPDATE;
    }


    public void toUnChange() {
        this.changingStatus = ChangingStatusEnum.UN_CHANGE;
    }

    public void toDelete() {
        this.changingStatus = ChangingStatusEnum.DELETE;
    }

    public void setChangingStatus(ChangingStatusEnum changingStatus) {
        this.changingStatus = changingStatus;
    }

    public Day getGmtCreate() {
        return gmtCreate;
    }

    public Day getGmtModified() {
        return gmtModified;
    }

    public void setGmtCreate(Day gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(Day gmtModified) {
        this.gmtModified = gmtModified;
    }

    public ChangingStatusEnum getChangingStatus() {
        return changingStatus;
    }
}