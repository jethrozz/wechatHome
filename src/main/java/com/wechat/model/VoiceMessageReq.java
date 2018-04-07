package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class VoiceMessageReq extends ReqBaseMessage {
	private String mediaId;
	private String format;

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	private String recognition;
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
