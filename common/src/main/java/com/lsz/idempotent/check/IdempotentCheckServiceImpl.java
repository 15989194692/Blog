package com.lsz.idempotent.check;

import com.lsz.idempotent.template.IdempotentContext;
import com.lsz.idempotent.template.IdempotentInstruction;

/**
 * @ClassName IdempotentCheckServiceImpl
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 19:38
 * @Version 1.0
 **/
public class IdempotentCheckServiceImpl implements IdempotentCheckService {

    @Override
    public IdempotentInstruction check(IdempotentContext idempotentContext) {
        return null;
    }

    @Override
    public boolean store(IdempotentContext idempotentContext, Object request, Object result) {
        return true;
    }
}
