package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class TextMessageRes extends ResBaseMessage {
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}

	private String Content;
}
