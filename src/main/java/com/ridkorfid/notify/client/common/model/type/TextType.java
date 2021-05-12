package com.ridkorfid.notify.client.common.model.type;

import com.ridkorfid.notify.client.common.model.NotifyType;

/**
 * @author qiu
 * @date 2021/1/9
 */
public class TextType implements NotifyType {

    private static final long serialVersionUID = 1L;

    @Override
    public String getType() {
        return "Text";
    }
}
