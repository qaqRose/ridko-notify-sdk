package com.ridkorfid.notify.client.auth;


import com.ridkorfid.notify.client.utils.StringUtil;

import java.util.Objects;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 默认凭证提供者
 * 使用 id+key的方式
 */
public class DefaultCredentialProvider implements CredentialsProvider {

    private volatile Credentials credentials;

    public DefaultCredentialProvider(Credentials credentials) {
        setCredentials(credentials);
    }

    public DefaultCredentialProvider(String accessId, String secretKey) {
        setCredentials(accessId, secretKey);
    }

    public void setCredentials(String accessId, String secretKey) {
        setCredentials(new DefaultCredentials(accessId, secretKey));
    }

    @Override
    public void setCredentials(Credentials credentials) {
        if(Objects.isNull(credentials)) {
            throw new InvalidCredentialsException("credentials凭证不能为空");
        }
        if(StringUtil.isBlank(credentials.getAccessId())) {
            throw new InvalidCredentialsException("access id 不能为空");
        }
        if(StringUtil.isBlank(credentials.getSecretKey())) {
            throw new InvalidCredentialsException("secret key 不能为空");
        }
        this.credentials = credentials;
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }
}
