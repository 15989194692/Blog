package com.lsz.idempotent.lock;

import com.lsz.idempotent.template.IdempotentContext;

/**
 * @ClassName LockServiceImpl
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 19:34
 * @Version 1.0
 **/
public class LockServiceImpl implements LockService {


    @Override
    public boolean lock(IdempotentContext idempotentContext) {
        return true;
    }

    @Override
    public boolean unlock(IdempotentContext idempotentContext) {
        return true;
    }
}
