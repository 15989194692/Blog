package com.lsz.idempotent.check;

import com.lsz.idempotent.template.IdempotentContext;
import com.lsz.idempotent.template.IdempotentInstruction;

/**
 * @ClassName IdempotentCheckService
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 11:37
 * @Version 1.0
 **/
public interface IdempotentCheckService {

    IdempotentInstruction check(IdempotentContext idempotentContext);

    boolean store(IdempotentContext idempotentContext, Object request, Object result);

}
