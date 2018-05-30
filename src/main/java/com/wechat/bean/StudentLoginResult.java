package com.wechat.bean;

import com.wechat.entity.Classes;
import com.wechat.entity.Student;

/**
 * Created by zxc on 2018/5/31.
 */
public class StudentLoginResult {
	private Student student;
	private Classes classes;

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
