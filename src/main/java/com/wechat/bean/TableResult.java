package com.wechat.bean;

import java.util.List;

/**
 * Created by zxc on 2018/6/1.
 */
public class TableResult<T> {
	private int code;
	private String msg;
	private int count;
	private T date;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}
}
