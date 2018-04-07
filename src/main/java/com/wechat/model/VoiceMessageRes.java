package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class VoiceMessageRes extends  ResBaseMessage {
	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		this.Voice = voice;
	}

	private Voice Voice;
}
