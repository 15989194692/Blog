/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.exceptions;

/**
 * @author lishuzeng
 * @version : RpcException.java, v 0.1 2023年03月04日 下午6:49 lishuzeng Exp $
 */
public class RpcException extends AbstractException {

    private boolean isNeedRetry;

    private String providerInfo;

    public RpcException(String errorCode, String errorMessage, Throwable cause,
                        boolean isNeedRetry, String providerInfo) {
        super(errorCode, errorMessage, cause);
        this.isNeedRetry = isNeedRetry;
        this.providerInfo = providerInfo;
    }

    public RpcException(RpcExceptionMessage rpcExceptionMessage, Throwable cause) {
        super(rpcExceptionMessage, cause);
        this.isNeedRetry = rpcExceptionMessage.isNeedRetry();
        this.providerInfo = rpcExceptionMessage.getProviderInfo();
    }

}