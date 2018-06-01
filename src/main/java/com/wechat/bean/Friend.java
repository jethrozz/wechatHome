package com.wechat.bean;

import java.util.List;

/**
 */
public class Friend {
	private String groupname; //好友分组名
	private int id; //分组ID
	private List<ChatUser> list; //该分组下的所有用户

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ChatUser> getList() {
		return list;
	}

	public void setList(List<ChatUser> list) {
		this.list = list;
	}


}
