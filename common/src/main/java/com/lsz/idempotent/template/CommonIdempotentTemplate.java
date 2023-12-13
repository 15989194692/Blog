package com.lsz.idempotent.template;

import com.lsz.idempotent.check.IdempotentCheckService;
import com.lsz.idempotent.check.IdempotentCheckServiceImpl;
import com.lsz.idempotent.lock.LockService;
import com.lsz.idempotent.lock.LockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName CommonIdempotentTemplate
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 19:36
 * @Version 1.0
 **/
public class CommonIdempotentTemplate<Request, Result> extends AbstractIdempotentTemplate {


    @Autowired
    private LockService lockService = new LockServiceImpl();

    @Autowired
    private IdempotentCheckService idempotentCheckService = new IdempotentCheckServiceImpl();


    @Override
    protected LockService getLockService() {
        return lockService;
    }

    @Override
    protected IdempotentCheckService getIdempotentCheckService() {
        return idempotentCheckService;
    }
}
