package com.wechat.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2018-05-22
 */
@TableName("student_parent")
public class StudentParent extends Model<StudentParent> {

    private static final long serialVersionUID = 1L;

	@TableField("stu_id")
	private Integer stuId;
	@TableField("par_id")
	private Integer parId;
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;


	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Integer getParId() {
		return parId;
	}

	public void setParId(Integer parId) {
		this.parId = parId;
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
