package com.ridkorfid.notify.client.auth;

import com.ridkorfid.notify.client.utils.StringUtil;

/**
 * @author qiu
 * @date 2021/1/9
 *
 * 环境变量凭证提供者
 */
public class EnvironmentVariableCredentialsProvider implements CredentialsProvider {

    @Override
    public void setCredentials(Credentials creds) {

    }

    @Override
    public Credentials getCredentials() {

        String accessId = StringUtil.trim(System.getenv(AuthUtils.ACCESS_ID_ENV_VAR));
        String secretKey = StringUtil.trim(System.getenv(AuthUtils.SECRET_KEY_ENV_VAR));

        if(StringUtil.isBlank(accessId)) {
            throw new InvalidCredentialsException("accessId 不能为空");
        }

        if(StringUtil.isBlank(secretKey)) {
            throw new InvalidCredentialsException("secretKey 不能为空");
        }

        return new DefaultCredentials(accessId, secretKey);
    }
}
