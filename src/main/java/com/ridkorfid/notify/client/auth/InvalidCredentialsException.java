package com.ridkorfid.notify.client.auth;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 无效凭证
 */
public class InvalidCredentialsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCredentialsException() {
        super();
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException(Throwable cause) {
        super(cause);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
