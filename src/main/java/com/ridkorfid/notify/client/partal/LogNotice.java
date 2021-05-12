package com.ridkorfid.notify.client.partal;

import com.ridkorfid.notify.client.common.log.LogLevel;

/**
 * @author qiu
 * @date 2021/5/12
 */
public class LogNotice extends AbstractNotice {

    private String content;

    private LogLevel logLevel;

    public LogNotice(LogLevel logLevel, String content) {
        super();
        this.logLevel = logLevel;
        this.content = content;
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
}
