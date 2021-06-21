package com.ridkorfid.notify.client.auth;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author qiu
 * @date 2021/1/9
 * 配置文件凭证提供者
 */
public class ProfileCredentialsProvider implements CredentialsProvider {

    private Logger logger = LoggerFactory.getLogger(ProfileCredentialsProvider.class);

    private final String profileName;

    private Credentials credentials;

    @Override
    public void setCredentials(Credentials credentials) {
    }

    @Override
    public Credentials getCredentials() {
        if(credentials == null) {
            synchronized (this) {
                if(credentials == null) {
                    checkProfile();
                    getCredentialsFromProfile();
                }
            }
        }
        return credentials;
    }

    public ProfileCredentialsProvider() {
        this(null);
    }

    public ProfileCredentialsProvider(String profileName) {
        String profileName1 = null;
        if (profileName == null) {
            for (String s : AuthUtils.DEFAULT_PROFILE_PATH) {
                String absolutePath = FileUtil.getAbsolutePath(s);
                if (FileUtil.isFile(absolutePath) && FileUtil.exist(absolutePath)) {
                    profileName1 = s;
                    break;
                }
            }
            if(profileName1 == null) {
                profileName1 = AuthUtils.DEFAULT_PROFILE_PATH[0];
            }
        } else {
            profileName1 = profileName;
        }
        this.profileName = profileName1;
    }

    private void checkProfile() {
        boolean file = FileUtil.isFile(profileName);
        if(!file) {
            throw new InvalidCredentialsException("配置文件不存在: 不存在" + profileName);
        }
    }

    /**
     * 从配置文件获取凭证
     */
    private void getCredentialsFromProfile() {
        Properties properties = new Properties();
        BufferedInputStream inputStream = FileUtil.getInputStream(profileName);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("读取配置文件失败:" + profileName);
            return;
        } finally {
            IoUtil.close(inputStream);
        }

        String accessId = StrUtil.trim(properties.getProperty(AuthUtils.NOTIFY_ACCESS_ID));
        String secretKey = StrUtil.trim(properties.getProperty(AuthUtils.NOTIFY_SECRET_KEY));

        credentials = new DefaultCredentials(accessId, secretKey);
    }

}
