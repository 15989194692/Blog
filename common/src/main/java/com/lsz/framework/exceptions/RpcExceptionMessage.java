/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.lsz.framework.exceptions;

/**
 * @author lishuzeng
 * @version : RpcErrorMessage.java, v 0.1 2023年03月04日 下午6:53 lishuzeng Exp $
 */
public interface RpcExceptionMessage extends ExceptionMessage {

    boolean isNeedRetry();

    String getProviderInfo();

}