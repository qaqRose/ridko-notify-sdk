package com.ridkorfid.notify.client.partal;

/**
 * @author qiu
 * @date 2021/1/9
 */
public abstract class AbstractNotice implements Notice {

    private static final long serialVersionUID = 1L;

    /**
     * 时间戳
     */
    protected Long timestamp;

    /**
     * 线程名称
     */
    protected String threadName;

    protected AbstractNotice() {
        timestamp = System.currentTimeMillis();
        threadName = Thread.currentThread().getName();
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

}
