package com.ridkorfid.notify.client;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.lang.Singleton;
import com.ridkorfid.notify.client.auth.Credentials;
import com.ridkorfid.notify.client.auth.CredentialsProvider;
import com.ridkorfid.notify.client.common.log.LogLevel;
import com.ridkorfid.notify.client.common.model.NotifyType;
import com.ridkorfid.notify.client.common.model.type.ExceptionType;
import com.ridkorfid.notify.client.common.model.type.LogType;
import com.ridkorfid.notify.client.common.model.type.TextType;
import com.ridkorfid.notify.client.config.Configuration;
import com.ridkorfid.notify.client.partal.LogNotice;
import com.ridkorfid.notify.client.partal.Notice;
import com.ridkorfid.notify.client.partal.SimpleNotice;
import com.ridkorfid.notify.client.request.NotifyHeader;
import com.ridkorfid.notify.client.request.RequestMessage;
import com.ridkorfid.notify.client.task.NoticeTask;
import com.ridkorfid.notify.client.task.TaskQueue;
import com.ridkorfid.notify.client.utils.OsUtil;
import com.ridkorfid.notify.client.utils.Signer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * @author qiu
 * @date 2021/1/8
 */
public class NotifyClient implements Client {

    private static Logger logger = LoggerFactory.getLogger(NotifyClient.class);

    private Configuration config;
    private CredentialsProvider credentialsProvider;
    private TaskQueue taskQueue;

    public NotifyClient(CredentialsProvider credentialsProvider, Configuration config) {
        this.credentialsProvider = credentialsProvider;
        this.config = config;
        this.taskQueue = new TaskQueue(config.getMaxBlockingTaskNum());
    }

    private static TextType textType = Singleton.get(TextType.class);
    private static ExceptionType exceptionType = Singleton.get(ExceptionType.class);

    @Override
    public void push(String message) {
        push(message, textType);
    }

    @Override
    public void push(Throwable throwable) {
        push(ExceptionUtil.stacktraceToString(throwable, 6000), exceptionType);
    }

    /**
     * ??????
     * @param message
     * @param notifyType
     */
    private void push(String message, NotifyType notifyType) {
        SimpleNotice simpleNotice = new SimpleNotice(message);
        _push(notifyType, simpleNotice);
    }

    private void log(LogLevel logLevel, String message, String packageName) {
        LogNotice notice = new LogNotice(logLevel, message, packageName);
        _push(Singleton.get(LogType.class), notice);
    }

    /**
     * ??????
     * @param notifyType
     * @param notice
     */
    private void _push(NotifyType notifyType, Notice notice) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setServerUri(URI.create(config.getEndPoint()));
        requestMessage.setProxy(config.getProxy());
        requestMessage.setContent(notice);
        String s = Signer.buildSignature(credentialsProvider.getCredentials().getSecretKey(), notifyType.getType(), config.getVersion());
        requestMessage.addHeader(NotifyHeader.AUTHORIZATION, composeRequestAuthorization(s));
        requestMessage.addHeader(NotifyHeader.VERSION, config.getVersion());
        requestMessage.addHeader(NotifyHeader.USER_AGENT, config.getUserAgent());
        requestMessage.addHeader(NotifyHeader.NOTIFY_TYPE, notifyType.getType());

        requestMessage.addHeader(NotifyHeader.HOST_NAME, OsUtil.getHostName());

        // ??????
        if(notifyType instanceof ExceptionType) {
            requestMessage.addHeader(NotifyHeader.CPU_INFO, OsUtil.getSimpleCpuInfo());
            requestMessage.addHeader(NotifyHeader.MEMORY_INFO, OsUtil.getSimpleMemoryInfo());
        }

        if(notifyType instanceof LogType) {
            // ???????????????????????????
        }

        taskQueue.push(new NoticeTask(requestMessage));
    }

    @Override
    public void debug(String message, String packageName) {
        log(LogLevel.DEBUG, message, packageName);
    }

    @Override
    public void info(String message, String packageName) {
        log(LogLevel.INFO, message, packageName);
    }

    @Override
    public void error(String message, String packageName) {
        log(LogLevel.ERROR, message, packageName);
    }

    @Override
    public Configuration getConfiguration() {
        return config;
    }

    @Override
    public TaskQueue getTaskQueue() {
        return taskQueue;
    }

    /**
     * ????????????
     * notify:${accessId}:${signature}
     * @param signature
     * @return
     */
    private String composeRequestAuthorization(String signature) {
        Credentials credentials = credentialsProvider.getCredentials();
        String accessId = credentials.getAccessId();
        return "notify:" + accessId + ":" + signature;
    }
}
