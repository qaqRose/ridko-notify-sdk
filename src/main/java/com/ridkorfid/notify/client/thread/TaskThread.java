package com.ridkorfid.notify.client.thread;

import com.ridkorfid.notify.client.config.Configuration;
import com.ridkorfid.notify.client.task.Task;
import com.ridkorfid.notify.client.task.TaskQueue;
import com.ridkorfid.notify.client.utils.SleepUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qiu
 * @date 2021/1/6
 */
public class TaskThread {

    private static TaskThread INSTANCE = new TaskThread();
    private static Configuration configuration = null;
    private volatile boolean runTask = false;
    private TaskQueue taskQueue = null;

    private ExecutorService fixedThreadPool = null;

    private TaskThread() {}

    public static TaskThread getInstance() {
        return INSTANCE;
    }

    /**
     * 线程启动方法
     */
    public void start(TaskQueue taskQueue, Configuration configuration) {
        synchronized (this) {
            if(!runTask) {
                runTask = true;
                this.taskQueue = taskQueue;
                this.configuration = configuration;

                fixedThreadPool = new ThreadPoolExecutor(poolSize, maxSize,
                        keepAliveTime, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>(configuration.getMaxBlockingTaskNum()));

                // 守护线程
                Thread runThread = new Thread(new RunningTask());
                runThread.setDaemon(true);
                runThread.start();
                logger.info("客户端notify线程开启啦");
            }
        }
    }

    private Logger logger = LoggerFactory.getLogger(TaskThread.class);

    private int poolSize = 1;
    private int maxSize = 2;
    private long keepAliveTime = 30 * 1000;


    private class RunningTask implements Runnable {

        @Override
        public void run() {
            while(runTask) {
                SleepUtil.sleep(100, TimeUnit.MILLISECONDS);

                Task task = taskQueue.pop();

                if (task != null) {
                    logger.debug("任务提交");
                    fixedThreadPool.submit(task);
                }
            }
        }
    }

    public boolean isRunning() {
        return runTask;
    }
}
