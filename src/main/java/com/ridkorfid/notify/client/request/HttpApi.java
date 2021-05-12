package com.ridkorfid.notify.client.request;

import cn.hutool.http.HttpUtil;

/**
 * @author qiu
 * @date 2021/1/6
 */
public class HttpApi {

    /**
     * 超时，单位毫秒
     */
    final static int timeout = 30 * 1000;

    /**
     * http/https post请求
     * @param url
     * @param body
     */
    public static String post(String url, String body) {
       return post(url, body, timeout);
    }

    /**
     * http/https post请求
     * @param url
     * @param body
     * @param timeout
     * @return
     */
    public static String post(String url, String body, int timeout) {
        return HttpUtil.post(url, body, timeout);
    }
}
