package com.ridkorfid.notify.client.common.model;

/**
 * @author qiu
 * @date 2021/1/9
 */
public interface NotifyTypeServiceProvider {
    /**
     * 返回NotifyTypeFactory实例
     * @return
     */
    NotifyTypeFactory getNotifyFactory();
}
