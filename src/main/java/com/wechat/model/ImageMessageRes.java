package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class ImageMessageRes extends ResBaseMessage {
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	private Image image;

}
