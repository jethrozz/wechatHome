package com.wechat.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 学生表，记录学生的个人信息
 * </p>
 *
 * @author stylefeng
 * @since 2018-05-22
 */
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("cla_id")
	private Integer claId;
	private String password;
	private String name;
	private String sex;
	@TableField("identity_number")
	private String identityNumber;
	@TableField("student_number")
	private String studentNumber;
	@TableField("s_create_time")
	private Date sCreateTime;
	@TableField("update_time")
	private Date updateTime;
	@TableField("openId")
	private String openid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClaId() {
		return claId;
	}

	public void setClaId(Integer claId) {
		this.claId = claId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Date getsCreateTime() {
		return sCreateTime;
	}

	public void setsCreateTime(Date sCreateTime) {
		this.sCreateTime = sCreateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
