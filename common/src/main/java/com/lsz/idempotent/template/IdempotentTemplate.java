package com.lsz.idempotent.template;

/**
 * @ClassName IdempotentTemplate
 * @Description TODO
 * @Author tingkai
 * @Date 2023/12/13 11:21
 * @Version 1.0
 **/
public interface IdempotentTemplate {
    <Request, Result> Result execute(Request request, IdempotentExecuteCallback<Request, Result> idempotentExecuteCallback);
}
