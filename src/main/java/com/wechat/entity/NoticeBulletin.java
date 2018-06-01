package com.wechat.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 通知公告，包含
id
标题
内容
类型
发布时间
                                    -&#&
 * </p>
 *
 * @author stylefeng
 * @since 2018-05-22
 */
@TableName("notice_bulletin")
public class NoticeBulletin extends Model<NoticeBulletin> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("tea_id")
	private Integer teaId;
	private Integer type;
	private String title;
	private String content;
	@TableField("nb_create_time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date nbCreateTime;
	@TableField("update_time")
	private Date updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeaId() {
		return teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Date getNbCreateTime() {
		return nbCreateTime;
	}

	public void setNbCreateTime(Date nbCreateTime) {
		this.nbCreateTime = nbCreateTime;
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
