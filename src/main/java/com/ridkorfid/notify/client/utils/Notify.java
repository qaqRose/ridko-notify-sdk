package com.ridkorfid.notify.client.utils;

import cn.hutool.core.lang.caller.Caller;
import cn.hutool.core.lang.caller.CallerUtil;
import cn.hutool.core.lang.caller.SecurityManagerCaller;
import com.ridkorfid.notify.client.Client;
import com.ridkorfid.notify.client.ClientBuilder;
import com.ridkorfid.notify.client.thread.TaskThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qiu
 * @date 2021/1/5
 */
public class Notify {
    private Logger logger = LoggerFactory.getLogger(Notify.class);
    private static Client client;

    private Notify() {}
    private static Notify INSTANCE = new Notify();

    /**
     * 发送消息
     * @param message
     */
    public static void push(String message) {
        if(!INSTANCE.secureCheck()) {
            return ;
        }
        client.push(message);
    }

    /**
     * 推送异常消息
     * @param throwable
     */
    public static void push(Throwable throwable) {
        if(!INSTANCE.secureCheck()) {
            return ;
        }
        client.push(throwable);
    }

    /**
     * debug日志
     * @param message
     */
    public static void logDebug(String message) {
        if(!INSTANCE.secureCheck()) {
            return ;
        }
        Class<?> caller = CallerUtil.getCaller(2);
        client.debug(message, caller.getPackage().getName());
    }

    /**
     * info日志
     * @param message
     */
    public static void logInfo(String message) {
        if(!INSTANCE.secureCheck()) {
            return ;
        }
        Class<?> caller = CallerUtil.getCaller(2);
        client.info(message, caller.getPackage().getName());
    }

    /**
     * 错误日志
     * @param message
     */
    public static void logError(String message) {
        if(!INSTANCE.secureCheck()) {
            return ;
        }
        Class<?> caller = CallerUtil.getCaller(2);
        client.error(message, caller.getPackage().getName());
    }



    /**
     * 安全检查
     *  1. 检查客户端
     *  2. 检查线程
     * @return
     */
    private boolean secureCheck() {
        // 检查客户端
        checkClient();
        // 检查线程
        checkThread();
        return true;
    }

    /**
     * 客户端检查
     */
    private void checkClient() {
        if(client == null) {
            synchronized (this) {
                if(client == null) {
                    client = ClientBuilder.build();
                }
            }
        }
    }

    /**
     * 线程检查
     */
    private static void checkThread() {
        if(!TaskThread.getInstance().isRunning()) {
            TaskThread.getInstance().start(client.getTaskQueue(), client.getConfiguration());
        }
    }

    public static Client getClient() {
        return client;
    }

    public static void setClient(Client customClient) {
        client = customClient;
    }

}
