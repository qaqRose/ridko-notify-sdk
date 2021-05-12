package com.ridkorfid.notify.client.auth;

import com.ridkorfid.notify.client.NotifyException;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 找不到凭证配置信息异常
 */
public class CredentialsConfigNotFoundException extends NotifyException {

    public CredentialsConfigNotFoundException() {
    }

    public CredentialsConfigNotFoundException(String message) {
        super(message);
    }

    public CredentialsConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CredentialsConfigNotFoundException(Throwable cause) {
        super(cause);
    }

    public CredentialsConfigNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
