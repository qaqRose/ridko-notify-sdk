package com.ridkorfid.notify.client.common.model;

/**
 * @author qiu
 * @date 2021/1/8
 */
public class GenericResult {

    private static final int HTTP_SUCCESS_CODE = 200;

    private int code;
    private String errMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
