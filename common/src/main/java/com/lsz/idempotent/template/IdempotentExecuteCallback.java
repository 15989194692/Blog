/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.lsz.idempotent.template;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/**
 * 模板回调
 *
 * @author lishuzeng.lsz
 * @version $Id: ProcessCallback.java, v 0.1 2023年12月13日 5:19 PM lishuzeng.lsz Exp $
 */
public interface IdempotentExecuteCallback<Request, Result> {

    /**
     * 检查入参
     */
    default void bizValidate(Request request) {};

    /**
     * 事务前做一些准备工作，把一些不需要放到事务内的工作提前做了，避免大事务
     *
     * @param request 请求
     */
    default void prepareBeforeTransaction(Request request) {}

    /**
     * 事务内做一些准备工作，把一些需要在事务内的准备工作囊括进来
     *
     * @param request 请求
     */
    default void prepareInTransaction(Request request) {}


    /**
     * 锁相关，若不需要启用幂等则无需实现
     *
     * @param request 请求
     * @return 锁上下文
     */
    default IdempotentContext generateIdempotentContext(Request request) {
        return new IdempotentContext.Builder().useIdempotentCheck(false).build();
    }

    /**
     * 执行处理
     *
     * @return
     */
    Result execute(Request request);


    /**
     * 幂等处理
     *
     * @param request 请求
     * @param idempotentInstruction 幂等记录
     * @return 结果
     */
    default Result repeatExecute(Request request, IdempotentInstruction idempotentInstruction) {
        return null;
    }

    default Class<Request> getRequestType() {
        return getActualRequestType();
    }

    default Class<Result> getResultType() {
        return getActualResultType();
    }

    /**
     * 获取 ProcessCallback<Result>的Result
     * @return 实际出参类型
     */
    default Class<Result> getActualResultType() {
        // 获取子类的所有接口类
        Type[] genericInterfaces = this.getClass().getGenericInterfaces();
        return Arrays.stream(genericInterfaces)
                // 需要进行强转，需要先判断是否是ParameterizedType子类
                .filter(genericInterface -> genericInterface instanceof ParameterizedType)
                // 类型转换
                .map(genericInterface -> (ParameterizedType) genericInterface)
                // 过滤出 ProcessCallback 类型，由于只有一个范型Result，所以需要判断真实范型数组长度为1
                .filter(parameterizedType ->
                        Objects.equals(parameterizedType.getRawType().getTypeName(),
                                IdempotentExecuteCallback.class.getName())
                                && parameterizedType.getActualTypeArguments().length == 2)
                // 获取 ProcessCallBack 的范型类型，即 ProcessCallBack<Result> 的 Result
                .map(processCallBack -> processCallBack.getActualTypeArguments()[1])
                // 过滤出 Result 是 Class 类型的
                .filter(actualResultType -> actualResultType instanceof Class)
                // 转换为 Class<Result>
                .map(actualResultType -> (Class<Result>) actualResultType)
                .findFirst()
                // 找不到抛出异常
                .orElseThrow(() -> new IllegalArgumentException(
                        "can not fetch actual result type by class: " + this.getClass()));
    }

    /**
     * 获取 ProcessCallback<Result>的Result
     * @return 实际出参类型
     */
    default Class<Request> getActualRequestType() {
        // 获取子类的所有接口类
        Type[] genericInterfaces = this.getClass().getGenericInterfaces();
        return Arrays.stream(genericInterfaces)
                // 需要进行强转，需要先判断是否是ParameterizedType子类
                .filter(genericInterface -> genericInterface instanceof ParameterizedType)
                // 类型转换
                .map(genericInterface -> (ParameterizedType) genericInterface)
                // 过滤出 ProcessCallback 类型，由于只有一个范型Result，所以需要判断真实范型数组长度为1
                .filter(parameterizedType ->
                        Objects.equals(parameterizedType.getRawType().getTypeName(),
                                IdempotentExecuteCallback.class.getName())
                                && parameterizedType.getActualTypeArguments().length == 2)
                // 获取 ProcessCallBack 的范型类型，即 ProcessCallBack<Result> 的 Result
                .map(processCallBack -> processCallBack.getActualTypeArguments()[0])
                // 过滤出 Result 是 Class 类型的
                .filter(actualResultType -> actualResultType instanceof Class)
                // 转换为 Class<Result>
                .map(actualResultType -> (Class<Request>) actualResultType)
                .findFirst()
                // 找不到抛出异常
                .orElseThrow(() -> new IllegalArgumentException(
                        "can not fetch actual result type by class: " + this.getClass()));
    }

}