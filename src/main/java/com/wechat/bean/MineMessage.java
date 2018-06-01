package com.wechat.bean;

/**
 */
public class MineMessage {
	//   avatar: "avatar.jpg" //我的头像
//   ,content: "你好吗" //消息内容
//   ,id: "100000" //我的id
//   ,mine: true //是否我发送的消息
//   ,username: "纸飞机" //我的昵称
	private String avatar;
	private String content;
	private String id;
	private boolean mine;
	private String username;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
