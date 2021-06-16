package com.ridkorfid.notify.client.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ridkorfid.notify.client.exception.HttpPostException;
import com.ridkorfid.notify.client.request.RequestMessage;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;

/**
 * @author qiu
 * @date 2021/1/5
 */
public abstract class AbstractTask extends AbstractTimeTask {

    /**
     * 获取notice
     *
     * @return
     */
    abstract RequestMessage getRequestMessage();

    @Override
    public void running() {
        RequestMessage requestMessage = getRequestMessage();
        if (requestMessage == null) {
            logger.warn("requestMessage实体为空，任务结束");
            return;
        }
        logger.debug("任务开始: {}", DateUtil.now());
        try {
            _run(requestMessage);
        } catch (Exception e) {
            logger.error("发送notify失败", e);
        }
    }

    /**
     * @param requestMessage
     * @throws HttpPostException 结果不正常
     */
    private void _run(RequestMessage requestMessage) {
        Map<String, String> headers = requestMessage.getHeaders();

        // test 本地代理
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));

        String result = HttpRequest.post(requestMessage.getServerUri().toString())
                .headerMap(headers, false)
                .body(JSON.toJSONString(requestMessage.getContent()))
//                .setProxy(proxy)
                .timeout(30 * 1000)
                .execute()
                .body();

        try {
            JSONObject jsonObject = JSONObject.parseObject(result);
            int code = jsonObject.getIntValue("code");
            if (code != 200) {
                String msg = jsonObject.getString("message");
                if(StrUtil.isBlank(msg)) {
                    msg = jsonObject.getString("msg");
                }
                throw new HttpPostException("errorCode:" + code + ",msg:" + msg);
            }
        } catch (JSONException je) {
            throw new HttpPostException("返回结果数据json编码出错:" + result);
        }
    }
}
