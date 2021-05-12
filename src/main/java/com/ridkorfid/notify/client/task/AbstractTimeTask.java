package com.ridkorfid.notify.client.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qiu
 * @date 2021/5/7
 */
public abstract class AbstractTimeTask implements Task {

    protected Logger logger = LoggerFactory.getLogger(AbstractTimeTask.class);

    /**
     * 任务运行前钩子
     * 异常需要自己捕获
     */
    public void runningBefore() {

    }

    /**
     * 任务运行后钩子
     * 异常需要自己捕获
     */
    public void runningAfter() {

    }

    public abstract void running();

    @Override
    public void run() {
        runningBefore();
        long start = System.currentTimeMillis();
        running();
        logger.info("任务耗时: {} ms", (System.currentTimeMillis() - start));
        runningAfter();
    }

}
