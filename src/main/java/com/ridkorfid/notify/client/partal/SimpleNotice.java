package com.ridkorfid.notify.client.partal;

/**
 * @author qiu
 * @date 2021/1/6
 */
public class SimpleNotice extends AbstractNotice {

    private static final long serialVersionUID = 1L;

    private String content;

    public SimpleNotice(String content) {
        super();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
