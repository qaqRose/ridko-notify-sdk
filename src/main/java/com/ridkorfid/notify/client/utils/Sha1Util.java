package com.ridkorfid.notify.client.utils;

import cn.hutool.crypto.SecureUtil;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 哈希加密
 */
public class Sha1Util {


    public static String sha256(String data) {
        return SecureUtil.sha256(data);
    }
}
