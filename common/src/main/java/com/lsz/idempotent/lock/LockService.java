package com.lsz.idempotent.lock;

import com.lsz.idempotent.template.IdempotentContext;

/**
 * @ClassName LockService
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 11:07
 * @Version 1.0
 **/
public interface LockService {
    boolean lock(IdempotentContext idempotentContext);

    boolean unlock(IdempotentContext idempotentContext);
}
