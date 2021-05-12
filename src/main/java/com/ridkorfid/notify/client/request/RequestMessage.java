package com.ridkorfid.notify.client.request;


import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author qiu
 * @date 2021/1/9
 *
 * 请求消息
 */
public class RequestMessage extends HttpMessage {

    private HttpMethod httpMethod = HttpMethod.POST;

    private URI serverUri;

    private Map<String, String> parameters = new LinkedHashMap<String, String>();


    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public URI getServerUri() {
        return serverUri;
    }

    public void setServerUri(URI serverUri) {
        this.serverUri = serverUri;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters.clear();
        if (parameters != null && !parameters.isEmpty()) {
            this.parameters.putAll(parameters);
        }
    }

    public void addParameter(String key, String value) {
        this.parameters.put(key, value);
    }

    public void removeParameter(String key) {
        this.parameters.remove(key);
    }
}
