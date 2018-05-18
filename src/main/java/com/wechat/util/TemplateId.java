package com.wechat.util;

/**
 * Created by zxc on 2018/5/10.
 */
public enum TemplateId {
	NOTICE("您有一个新的通知","b3WVrW5sQsq7Yx9DWABoo9PRVjBwCOh3LEd_I4k4lkM"),
	MSG("您有一条新的私聊消息","pzdPXgwbh7TOSDyYBNJ5g45kCctzPCn_wA2JaJwHddU"),
	LEAVE("您有一条请假申请需要审核","8rYBEY8W7kw7cOC0AEP9Dfwu-lYRG-PM0g-qgneaxMw");

	private final String value;
	private final String url;

	TemplateId(String i, String s) {
		this.value = i;
		this.url = s;
	}

	public String getValue() {
		return value;
	}

	public String getUrl() {
		return url;
	}
}
