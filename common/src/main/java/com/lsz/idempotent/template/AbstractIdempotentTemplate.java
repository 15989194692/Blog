package com.lsz.idempotent.template;

import com.lsz.idempotent.lock.LockService;
import com.lsz.idempotent.check.IdempotentCheckService;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName AbstractIdempotentTemplate
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 11:36
 * @Version 1.0
 **/
public abstract class AbstractIdempotentTemplate implements IdempotentTemplate {

    protected abstract LockService getLockService();

    protected abstract IdempotentCheckService getIdempotentCheckService();

    @Resource(name = "transactionTemplate")
    private TransactionTemplate transactionTemplate;

    @Override
    public <Request, Result> Result execute(Request request, IdempotentExecuteCallback<Request, Result> idempotentExecuteCallback) {
        idempotentExecuteCallback.bizValidate(request);
        idempotentExecuteCallback.prepareBeforeTransaction(request);

        IdempotentContext idempotentContext = idempotentExecuteCallback.generateIdempotentContext(request);
        if (!idempotentContext.isUseIdempotentCheck()) {
            return idempotentExecuteCallback.execute(request);
        }

        // 加锁前判断
        IdempotentInstruction idempotentInstructionBeforeLock = getIdempotentCheckService().check(idempotentContext);
        if (Objects.nonNull(idempotentInstructionBeforeLock)) {
            return idempotentExecuteCallback.repeatExecute(request, idempotentInstructionBeforeLock);
        }

        boolean lock = false;
        try {
            // 加锁
            lock = getLockService().lock(idempotentContext);
            if (!lock) {
                // TBD logger
                onLockFail(request, idempotentExecuteCallback, idempotentContext);
                return null;
            }

            // 加锁后判断
            IdempotentInstruction idempotentInstructionAfterLock = getIdempotentCheckService().check(idempotentContext);
            if (Objects.nonNull(idempotentInstructionAfterLock)) {
                return idempotentExecuteCallback.repeatExecute(request, idempotentInstructionAfterLock);
            }

            // 事务内执行业务操作和幂等
            return transactionTemplate.execute(action -> {
                idempotentExecuteCallback.prepareInTransaction(request);
                Result result = idempotentExecuteCallback.execute(request);
                boolean store = getIdempotentCheckService().store(idempotentContext, request, result);
                if (!store) {
                    // TBD logger
                }
                return result;
            });
        } catch (Throwable throwable) {
            System.out.println("throwable = " + throwable);
            return null;
        } finally {
            if (lock) {
                getLockService().unlock(idempotentContext);
            }
        }
    }

    protected <Request, Result>  void onLockFail(Request request, IdempotentExecuteCallback<Request, Result> idempotentExecuteCallback,
                              IdempotentContext idempotentContext) {
        // TBD logger
    }

}
