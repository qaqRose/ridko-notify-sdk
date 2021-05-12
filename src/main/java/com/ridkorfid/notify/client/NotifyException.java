package com.ridkorfid.notify.client;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 基础异常
 * 所有异常都继承此类
 */
public class NotifyException extends RuntimeException {
    public NotifyException() {
        super();
    }

    public NotifyException(String message) {
        super(message);
    }

    public NotifyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotifyException(Throwable cause) {
        super(cause);
    }

    protected NotifyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
