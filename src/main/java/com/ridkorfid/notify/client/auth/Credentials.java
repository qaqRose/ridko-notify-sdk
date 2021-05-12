package com.ridkorfid.notify.client.auth;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 凭证
 */
public interface Credentials {

    /**
     * 获取accessId
     * 用于标识不同的客户端
     * @return
     */
    String getAccessId();

    /**
     * 获取秘钥
     * 用于身份认证
     * @return
     */
    String getSecretKey();
}
