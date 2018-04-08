package com.wechat.model;

/**
 * @作者: jethro
 * @时间: 2018/4/8
 * @描述：普通按钮
 */
public class CommonButton extends Button {
    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
