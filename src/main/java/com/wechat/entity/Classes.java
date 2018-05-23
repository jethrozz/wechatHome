package com.wechat.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author stylefeng
 * @since 2018-05-22
 */
public class Classes extends Model<Classes> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer teacher;
	@TableField("grade_name")
	private Integer gradeName;
	@TableField("class_name")
	private Integer className;
	@TableField("create_time")
	private Date createTime;
	@TableField("update_time")
	private Date updateTime;

	Set<Teacher> listteacher = new HashSet<Teacher>();
	Set<Student> liststu = new HashSet<Student>();

	public Set<Teacher> getListteacher() {
		return listteacher;
	}

	public void setListteacher(Set<Teacher> listteacher) {
		this.listteacher = listteacher;
	}

	public Set<Student> getListstu() {
		return liststu;
	}

	public void setListstu(Set<Student> liststu) {
		this.liststu = liststu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeacher() {
		return teacher;
	}

	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}

	public Integer getGradeName() {
		return gradeName;
	}

	public void setGradeName(Integer gradeName) {
		this.gradeName = gradeName;
	}

	public Integer getClassName() {
		return className;
	}

	public void setClassName(Integer className) {
		this.className = className;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
