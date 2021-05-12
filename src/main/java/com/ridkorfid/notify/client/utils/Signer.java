package com.ridkorfid.notify.client.utils;

/**
 * @author qiu
 * @date 2021/1/9
 */
public class Signer {

    public static String buildSignature(String secretKey, String notifyType, String version) {
        String data = secretKey + ":" + notifyType + ":" + version;
        return Sha1Util.sha256(data);
    }
}
