package com.wechat.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 作业表
 * </p>
 *
 * @author stylefeng
 * @since 2018-05-22
 */
public class Homework extends Model<Homework> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String title;
	private String content;
	@TableField("finsh_time")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:sss")
	private Date finshTime;
	@TableField("tea_id")
	private Integer teaId;
	@TableField("cla_id")
	private Integer claId;
	@TableField("h_create_time")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:sss")
	private Date hCreateTime;
	@TableField("update_time")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:sss")
	private Date updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getFinshTime() {
		return finshTime;
	}

	public void setFinshTime(Date finshTime) {
		this.finshTime = finshTime;
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

	public Date gethCreateTime() {
		return hCreateTime;
	}

	public void sethCreateTime(Date hCreateTime) {
		this.hCreateTime = hCreateTime;
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
