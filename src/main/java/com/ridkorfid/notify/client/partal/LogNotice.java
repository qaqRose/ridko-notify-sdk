package com.ridkorfid.notify.client.partal;

import cn.hutool.core.date.DateUtil;
import com.ridkorfid.notify.client.common.log.LogLevel;

/**
 * @author qiu
 * @date 2021/5/12
 */
public class LogNotice extends AbstractNotice {

    private String content;

    private LogLevel logLevel;

    private String packageName;

    public LogNotice(LogLevel logLevel, String content, String packageName) {
        super();
        this.logLevel = logLevel;
        this.content = content;
        this.packageName = packageName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
