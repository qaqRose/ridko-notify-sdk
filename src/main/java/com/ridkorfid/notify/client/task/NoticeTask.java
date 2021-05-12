package com.ridkorfid.notify.client.task;

import com.ridkorfid.notify.client.request.RequestMessage;

/**
 * @author qiu
 * @date 2021/1/6
 *
 * 通知任务
 */
public class NoticeTask extends AbstractTask {

    private RequestMessage requestMessage;

    public NoticeTask(RequestMessage requestMessage) {
        this.requestMessage = requestMessage;
    }

    @Override
    RequestMessage getRequestMessage() {
        return requestMessage;
    }
}
