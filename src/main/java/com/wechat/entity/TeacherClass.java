package com.wechat.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 教师班级对应表
 * </p>
 *
 * @author stylefeng
 * @since 2018-05-22
 */
@TableName("teacher_class")
public class TeacherClass extends Model<TeacherClass> {

    private static final long serialVersionUID = 1L;

	@TableField("tea_id")
	private Integer teaId;
	@TableField("cla_id")
	private Integer claId;
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;

	Teacher teacher ;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getTeaId() {
		return teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public Integer getClaId() {
		return claId;
	}

	public void setClaId(Integer claId) {
		this.claId = claId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
