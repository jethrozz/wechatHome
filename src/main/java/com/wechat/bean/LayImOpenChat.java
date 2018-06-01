package com.wechat.bean;

/**
 * Created by zxc on 2018/6/2.
 */
public class LayImOpenChat {
//	name: '我的群' //名称
//			,type: 'group' //聊天类型
//			,avatar: 'http://tp1.sinaimg.cn/5619439268/180/40030060651/1' //头像
//			,id: 222 //定义唯一的id方便你处理信息

	private String name;
	private String type;
	private String avatar;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
