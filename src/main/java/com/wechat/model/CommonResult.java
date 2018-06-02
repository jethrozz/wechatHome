package com.wechat.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by zxc on 2018/5/3.
 */
public class CommonResult<T> {
	@JsonProperty("status")
	private int stauts;  //0--操作成功 1--操作失败
	@JsonProperty("data")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;
	@JsonProperty("msg")
	private String msg;

	public CommonResult() {
	}

	public CommonResult(int stauts, String msg) {
		this.stauts = stauts;
		this.msg = msg;
	}

	public CommonResult(int stauts, T data) {
		this.stauts = stauts;
		this.data = data;
		this.msg = "操作成功";
	}

	public int getStauts() {
		return stauts;
	}

	public void setStauts(int stauts) {
		this.stauts = stauts;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
