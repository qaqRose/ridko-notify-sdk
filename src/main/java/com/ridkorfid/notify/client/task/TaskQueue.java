package com.ridkorfid.notify.client.task;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author qiu
 * @date 2021/1/5
 */
public class TaskQueue {
    private BlockingDeque<Task> queue = null;

    public TaskQueue(int maxBlockingTaskNum) {
        queue = new LinkedBlockingDeque<>(maxBlockingTaskNum);
    }

//    private static TaskQueue INSTANCE = new TaskQueue();

//    public static TaskQueue getQueue() {
//        return INSTANCE;
//    }
    /**
     * 队尾插入增加任务
     * @param task
     */
    public synchronized void push(Task task) {
        queue.add(task);
    }

    /**
     * 从对头获取任务
     * @return
     */
    public synchronized Task pop() {
        if(!queue.isEmpty()) {
            return queue.poll();
        }
        return null;
    }

    public synchronized int size() {
        return queue.size();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

}
