package com.wechat.bean;

import com.wechat.entity.Classes;
import com.wechat.entity.Homework;

/**
 * Created by zxc on 2018/5/31.
 */
public class TeacherHomeworkResult {
	private Homework homework;
	private Classes classes;

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}
}
