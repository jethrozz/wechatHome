package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class LinkMessageReq extends ReqBaseMessage {
	private String title;
	private String description;
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
