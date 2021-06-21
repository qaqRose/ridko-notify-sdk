package com.ridkorfid.notify.client;

import com.ridkorfid.notify.client.auth.*;
import com.ridkorfid.notify.client.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qiu
 * @date 2021/1/8
 *
 * 客户端构建者
 */
public class ClientBuilder {

    private static Logger logger = LoggerFactory.getLogger(ClientBuilder.class);
    /**
     * 无参构建
     * 智能查找配置凭证： 循序 环境变量 -> 启动参数 -> 配置文件
     * 找不到会抛出异常
     * @throws CredentialsConfigNotFoundException
     * @return
     */
    public static Client build() {
        return new NotifyClient(getCredentialsProvider() , new Configuration());
    }

    public static Client build(Configuration configuration) {
        return new NotifyClient(getCredentialsProvider() , configuration);
    }

    public static Client build(String accessId, String secretKey) {
        return new NotifyClient(getCredentialsProvider(accessId, secretKey), new Configuration());
    }

    public static Client build(String accessId, String secretKey, Configuration configuration) {
        return new NotifyClient(getCredentialsProvider(accessId, secretKey), configuration);
    }

    public static Client build(CredentialsProvider credentialsProvider, Configuration configuration) {
        return new NotifyClient(credentialsProvider, configuration);
    }

    private static CredentialsProvider getCredentialsProvider(String accessId, String secretKey) {
         return new DefaultCredentialProvider(accessId, secretKey);
    }

    /**
     * 智能查找配置凭证
     * 循序 环境变量 -> 启动参数 -> 配置文件
     * @return
     */
    private static CredentialsProvider getCredentialsProvider() {
        // 循序 环境变量 -> 启动参数 -> 配置文件
        CredentialsProvider credentialsProvider = null;
        //
        credentialsProvider = new EnvironmentVariableCredentialsProvider();
        if(testCredentialsProvider(credentialsProvider)) {
            logger.debug("通过环境变量配置秘钥");
            return credentialsProvider;
        }

        credentialsProvider = new SystemPropertiesCredentialsProvider();
        if(testCredentialsProvider(credentialsProvider)) {
            logger.debug("通过系统属性配置秘钥");
            return credentialsProvider;
        }

        credentialsProvider = new ProfileCredentialsProvider();
        if(testCredentialsProvider(credentialsProvider)) {
            logger.debug("通过配置文件配置秘钥");
            return credentialsProvider;
        }

        throw new CredentialsConfigNotFoundException("请配置notify的凭证配置信息");

    }

    /**
     * 测试凭证提供者
     * @param credentialsProvider
     * @return
     */
    private static boolean testCredentialsProvider(CredentialsProvider credentialsProvider) {
        try {
            Credentials credentials = credentialsProvider.getCredentials();
            if(credentials != null) {
                return true;
            }
        } catch (Exception e) {}
        return false;
    }
}
