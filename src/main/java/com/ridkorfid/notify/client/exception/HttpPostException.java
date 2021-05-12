package com.ridkorfid.notify.client.exception;

/**
 * @author qiu
 * @date 2021/1/6
 */
public class HttpPostException extends BaseException {
    public HttpPostException() {
        super();
    }

    public HttpPostException(String message) {
        super(message);
    }

    public HttpPostException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpPostException(Throwable cause) {
        super(cause);
    }

    protected HttpPostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
