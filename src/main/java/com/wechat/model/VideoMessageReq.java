package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class VideoMessageReq extends ReqBaseMessage {
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	private String thumbMediaId;
}
