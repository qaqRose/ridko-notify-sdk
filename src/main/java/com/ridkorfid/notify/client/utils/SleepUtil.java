package com.ridkorfid.notify.client.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author qiu
 * @date 2021/1/6
 */
public class SleepUtil {

    /**
     * 休眠, 单位：秒
     * @param second
     */
    public static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 线程休眠
     * @param timeout 休眠时间
     * @param timeUnit 时间单位
     */
    public static void sleep(int timeout, TimeUnit timeUnit) {
        try {
            long millis = timeUnit.toMillis(timeout);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
