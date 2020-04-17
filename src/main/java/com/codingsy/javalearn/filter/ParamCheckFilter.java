/*
 * Copyright (C) 2018 112798381@qq.com All rights reserved.
 *
 * Created by 112798381@qq.com 2018/7/31.
 */

package com.codingsy.javalearn.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.codingsy.javalearn.enums.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 参数校验filter.
 *
 * @author 1129798381@qq.com
 */
//@Activate(group = Constants.PROVIDER)
public class ParamCheckFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParamCheckFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) {
        // 获取远程地址
        String remoteHost = RpcContext.getContext().getRemoteHost();
        // 获取接口名
        String interfaceName = invoker.getInterface().toString();
        // 获取方法名
        String methodName = invocation.getMethodName();
        // 获取请求参数
        long start = System.currentTimeMillis();
        Result result = new RpcResult();
        try {
            result = invoker.invoke(invocation);
        } catch (RpcException e) {
            LOGGER.error("system error!", e);
            com.codingsy.javalearn.domain.Result asResult = com.codingsy.javalearn.domain.Result.wrapError(ResultCodeEnum.ERR_SYSTEM.getErrCode(),
                    ResultCodeEnum.ERR_SYSTEM.getMsg());
            result = new RpcResult(asResult);
        } finally {
            LOGGER.info("remoteHost={}, interface={},methodName={},req:{},result={},time:{}ms",
                    remoteHost, interfaceName, methodName, invocation.getArguments(), result.getValue(), System.currentTimeMillis() - start);
        }
        return result;
    }

}
