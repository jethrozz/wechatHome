package com.wechat.bean;

import com.wechat.entity.Classes;
import com.wechat.entity.Parent;
import com.wechat.entity.Student;

import java.util.List;

/**
 * Created by zxc on 2018/5/31.
 */
public class ParentLoginResult {
 	private Parent parent;
	private Student student;
	private Classes classes;

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}
}
