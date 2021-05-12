package com.ridkorfid.notify.client.auth;


import com.ridkorfid.notify.client.utils.StringUtil;

/**
 * @author qiu
 * @date 2021/1/9
 */
public class DefaultCredentials implements Credentials {

    private String accessId;

    private String secretKey;

    public DefaultCredentials(String accessId, String secretKey) {
        if(StringUtil.isBlank(accessId)) {
            throw new InvalidCredentialsException("access id 不能为空");
        }
        if(StringUtil.isBlank(secretKey)) {
            throw new InvalidCredentialsException("secret key 不能为空");
        }
        this.accessId = accessId;
        this.secretKey = secretKey;
    }

    @Override
    public String getAccessId() {
        return accessId;
    }

    @Override
    public String getSecretKey() {
        return secretKey;
    }
}
