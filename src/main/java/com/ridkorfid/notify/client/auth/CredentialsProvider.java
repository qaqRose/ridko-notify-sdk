package com.ridkorfid.notify.client.auth;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 凭证提供者
 */
public interface CredentialsProvider {

    /**
     * 设置凭证
     * @param creds
     */
    void setCredentials(Credentials creds);

    /**
     * 获取凭证
     * @return
     */
    Credentials getCredentials();
}
