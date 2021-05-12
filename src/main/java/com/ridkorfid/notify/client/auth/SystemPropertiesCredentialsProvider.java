package com.ridkorfid.notify.client.auth;

import com.ridkorfid.notify.client.utils.StringUtil;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 系统属性
 *
 * 通过配置
 *   -Dnotify.accessId
 *  和
 *   -Dnotify.secretKey
 */
public class SystemPropertiesCredentialsProvider implements CredentialsProvider {

    @Override
    public void setCredentials(Credentials creds) {

    }

    @Override
    public Credentials getCredentials() {
        String accessId = StringUtil.trim(System.getProperty(AuthUtils.ACCESS_ID_SYSTEM_PROPERTY));
        String secretKey = StringUtil.trim(System.getProperty(AuthUtils.SECRET_KEY_SYSTEM_PROPERTY));

        if(StringUtil.isBlank(accessId)) {
            throw new InvalidCredentialsException("accessId 不能为空");
        }

        if(StringUtil.isBlank(secretKey)) {
            throw new InvalidCredentialsException("secretKey 不能为空");
        }

        return new DefaultCredentials(accessId, secretKey);
    }
}
