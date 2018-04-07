package com.wechat.model;

/**
 * Created by zxc on 2018/2/19.
 */
public class ReqBaseMessage {
	// 接收方OpenId
	private String toUserName;
	// 发送方OpenId
	private String fromUserName;
	// 时间
	private long createTime;
	// 消息类型
	private String msgType;
	// msgId
	private long msgId;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
}
