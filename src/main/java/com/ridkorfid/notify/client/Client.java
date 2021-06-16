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
     * debug日志
     * @param message
     */
    void debug(String message, String packageName);

    /**
     * info日志
     * @param message
     */
    void info(String message, String packageName);

    /**
     * 错误日志
     * @param message
     */
    void error(String message, String packageName);

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
