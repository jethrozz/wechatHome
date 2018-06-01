package com.wechat.bean;

import java.util.List;

/**
 * Created by zxc on 2018/6/1.
 */
public class ChatUserGroup {
	ChatUser mine;
	List<Friend> friend;

	public ChatUser getMine() {
		return mine;
	}

	public void setMine(ChatUser mine) {
		this.mine = mine;
	}

	public List<Friend> getFriend() {
		return friend;
	}

	public void setFriend(List<Friend> friend) {
		this.friend = friend;
	}
}
