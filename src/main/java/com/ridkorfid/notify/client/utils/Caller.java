package com.ridkorfid.notify.client.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qiu
 * @date 2021/1/9
 */
public class Caller {

    private static Logger logger = LoggerFactory.getLogger(Caller.class);

    /**
     * 获取调用方法
     * depth
     *  0: getStackTrace
     *  1. 当期方法, 即getMethodName
     *  2. 上一级调用方法
     * 所以一般需要大于2
     * @param depth
     * @param isFullName
     * @return
     */
    public static String getMethodName(int depth, boolean isFullName) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        if(stackTrace.length < depth) {
            logger.warn("深度大于调用方法栈深度, 调用深度:{}, 参数:{}", stackTrace.length, depth);
            return "";
        }
        final StackTraceElement stackTraceElement = stackTrace[depth];
        final String methodName = stackTraceElement.getMethodName();

        if(isFullName) {
            return stackTraceElement.getClassName() + "." + methodName;
        }

        return methodName;
    }
}
