package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class MusicMessage extends ResBaseMessage {
	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		this.Music = music;
	}

	private Music Music;
}
