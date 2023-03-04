/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.repository;

import com.lsz.framework.domain.AuditableEntity;

/**
 * @author lishuzeng
 * @version : AbstractRepository.java, v 0.1 2023年03月04日 下午6:29 lishuzeng Exp $
 */
public interface AbstractRepository<Entity extends AuditableEntity, Do> {
    Entity toEntity(Do dataObject);

    Do toDo(Entity entity);
}