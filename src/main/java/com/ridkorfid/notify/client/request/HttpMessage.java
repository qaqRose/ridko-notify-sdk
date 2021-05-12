package com.ridkorfid.notify.client.request;

import com.ridkorfid.notify.client.partal.Notice;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author qiu
 * @date 2021/1/9
 */
public class HttpMessage {

    private Map<String, String> headers = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

    private Notice content;

    private long contentLength;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public Notice getContent() {
        return content;
    }

    public void setContent(Notice content) {
        this.content = content;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }
}
