package com.ridkorfid.notify.client.auth;

import java.io.File;

/**
 * @author qiu
 * @date 2021/1/9
 */
public class AuthUtils {

    /**
     * 环境变量名: access id
     */
    public static final String ACCESS_ID_ENV_VAR = "NOTIFY_ACCESS_ID";

    /**
     * 环境变量名: secret key
     */
    public static final String SECRET_KEY_ENV_VAR = "NOTIFY_KEY_SECRET";

    /**
     *  配置属性: access id
     */
    public static final String NOTIFY_ACCESS_ID = "notify_access_id";

    /**
     * 配置属性: secret key
     */
    public static final String NOTIFY_SECRET_KEY = "notify_secret_key";

    /**
     * 系统参数
     * -Dnotify.accessId=xxx
     */
    public static final String ACCESS_ID_SYSTEM_PROPERTY = "notify.accessId";

    /**
     * -Dnotify.secretKey
     */
    public static final String SECRET_KEY_SYSTEM_PROPERTY = "notify.secretKey";

    /**
     * 默认配置文件位置
     */
    public static final String[] DEFAULT_PROFILE_PATH = defaultProfilePaths();

    /**
     * 计算配置文件位置
     * 位于${user.home}/.notify/credentials目录下
     * classpath: notify.properties
     * classpath: notify.yml
     * @return Default profile path
     */
    public static String[] defaultProfilePaths() {
        String[] paths = new String[]{
                System.getProperty("user.home") + File.separator + ".notify" + File.separator + "credentials",
                "notify.properties",
                "notify.yml",
        };
        return paths;
    }
}
