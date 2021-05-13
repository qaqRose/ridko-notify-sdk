package com.ridkorfid.notify.client.config;

import com.ridkorfid.notify.client.utils.VersionInfoUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author qiu
 * @date 2021/1/6
 */
public class Configuration {

    public static final String DEFAULT_USER_AGENT = VersionInfoUtils.getDefaultUserAgent();
    public static final int DEFAULT_MAX_RETRIES = 3;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 50 * 1000;

    /**
     * 用户agent
     */
    protected String userAgent = DEFAULT_USER_AGENT;
    /**
     * 默认重试次数
     */
    protected int maxErrorRetry = DEFAULT_MAX_RETRIES;
    /**
     * 连接超时
     */
    protected int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    /**
     * 请求头部
     */
    protected Map<String, String> defaultHeaders = new LinkedHashMap<String, String>();

    private final String version = VersionInfoUtils.getVersion();

    /**
     * 请求地址
     */
    private String endPoint = "https://message.ridkorfid.com/notice/post";

    /**
     * 最大阻塞任务队列长度
     */
    private int maxBlockingTaskNum = 10000;

    public int getMaxBlockingTaskNum() {
        return maxBlockingTaskNum;
    }

    public void setMaxBlockingTaskNum(int maxBlockingTaskNum) {
        this.maxBlockingTaskNum = maxBlockingTaskNum;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getVersion() {
        return version;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public int getMaxErrorRetry() {
        return maxErrorRetry;
    }

    public void setMaxErrorRetry(int maxErrorRetry) {
        this.maxErrorRetry = maxErrorRetry;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Map<String, String> getDefaultHeaders() {
        return defaultHeaders;
    }

    public void setDefaultHeaders(Map<String, String> defaultHeaders) {
        this.defaultHeaders = defaultHeaders;
    }

    /**
     * 测试使用
     * @param endPoint
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
