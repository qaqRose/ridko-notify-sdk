package com.ridkorfid.notify.client;


import com.ridkorfid.notify.client.common.log.LogLevel;
import com.ridkorfid.notify.client.config.Configuration;
import com.ridkorfid.notify.client.task.TaskQueue;

/**
 * @author qiu
 * @date 2021/1/8
 *
 * 客户端接口
 */
public interface Client {

    /**
     * 通知普通字符串消息
     * @param message
     */
    void push(String message);

    /**
     * 通知异常消息
     * @param throwable
     * @return
     */
    void push(Throwable throwable);

    /**
     * 发送日志日志
     */
    void log(LogLevel logLevel, String message);

    /**
     * debug日志
     * @param message
     */
    void debug(String message);

    /**
     * info日志
     * @param message
     */
    void info(String message);

    /**
     * 错误日志
     * @param message
     */
    void error(String message);

    /**
     * 获取配置
     * @return
     */
    Configuration getConfiguration();

    /**
     * 获取任务队列
     * @return
     */
    TaskQueue getTaskQueue();
}
