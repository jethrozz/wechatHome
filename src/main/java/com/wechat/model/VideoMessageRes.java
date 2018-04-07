package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class VideoMessageRes extends  ResBaseMessage{
	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		this.Video = video;
	}

	private Video Video;
}
