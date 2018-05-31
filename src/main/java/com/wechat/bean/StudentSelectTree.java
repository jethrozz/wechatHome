package com.wechat.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by zxc on 2018/5/31.
 */
public class StudentSelectTree {
	int id ;
	String name;
	boolean open = false;

	boolean disableCheckbox;
	@JsonProperty(value = "isParent")
	boolean isParent;

	List<StudentSelectTree> children;

	public List<StudentSelectTree> getChildren() {
		return children;
	}

	public void setChildren(List<StudentSelectTree> children) {
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean parent) {
		isParent = parent;
	}
}
