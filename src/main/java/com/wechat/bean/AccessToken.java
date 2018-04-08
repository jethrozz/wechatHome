package com.wechat.bean;

/**
 * @作者: jethro
 * @时间: 2018/4/8
 * @描述：微信接口通用凭证
 */
public class AccessToken {
    // 获取到的凭证
    private String accessToken;
    // 凭证有效时间，单位：秒
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
