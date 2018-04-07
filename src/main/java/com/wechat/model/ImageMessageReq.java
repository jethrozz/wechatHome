package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class ImageMessageReq extends ReqBaseMessage {
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
