package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class Video {
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	private String mediaId;
	private String ThumbMediaId;
}
