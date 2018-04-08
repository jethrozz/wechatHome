package com.wechat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class LeaveRecord implements Serializable {
    private Integer l_id;

    private Integer l_student;

    private Integer l_teacher;

    private String l_reason;

    private Integer l_type;

    private Date l_start_time;

    private Date l_end_time;

    private Date l_create_time;

    private Date l_update_time;

    private Integer l_is_agree;

    private Float l_time;

    private static final long serialVersionUID = 1L;

    public Integer getL_id() {
        return l_id;
    }

    public LeaveRecord withL_id(Integer l_id) {
        this.setL_id(l_id);
        return this;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public Integer getL_student() {
        return l_student;
    }

    public LeaveRecord withL_student(Integer l_student) {
        this.setL_student(l_student);
        return this;
    }

    public void setL_student(Integer l_student) {
        this.l_student = l_student;
    }

    public Integer getL_teacher() {
        return l_teacher;
    }

    public LeaveRecord withL_teacher(Integer l_teacher) {
        this.setL_teacher(l_teacher);
        return this;
    }

    public void setL_teacher(Integer l_teacher) {
        this.l_teacher = l_teacher;
    }

    public String getL_reason() {
        return l_reason;
    }

    public LeaveRecord withL_reason(String l_reason) {
        this.setL_reason(l_reason);
        return this;
    }

    public void setL_reason(String l_reason) {
        this.l_reason = l_reason == null ? null : l_reason.trim();
    }

    public Integer getL_type() {
        return l_type;
    }

    public LeaveRecord withL_type(Integer l_type) {
        this.setL_type(l_type);
        return this;
    }

    public void setL_type(Integer l_type) {
        this.l_type = l_type;
    }

    public Date getL_start_time() {
        return l_start_time;
    }

    public LeaveRecord withL_start_time(Date l_start_time) {
        this.setL_start_time(l_start_time);
        return this;
    }

    public void setL_start_time(Date l_start_time) {
        this.l_start_time = l_start_time;
    }

    public Date getL_end_time() {
        return l_end_time;
    }

    public LeaveRecord withL_end_time(Date l_end_time) {
        this.setL_end_time(l_end_time);
        return this;
    }

    public void setL_end_time(Date l_end_time) {
        this.l_end_time = l_end_time;
    }

    public Date getL_create_time() {
        return l_create_time;
    }

    public LeaveRecord withL_create_time(Date l_create_time) {
        this.setL_create_time(l_create_time);
        return this;
    }

    public void setL_create_time(Date l_create_time) {
        this.l_create_time = l_create_time;
    }

    public Date getL_update_time() {
        return l_update_time;
    }

    public LeaveRecord withL_update_time(Date l_update_time) {
        this.setL_update_time(l_update_time);
        return this;
    }

    public void setL_update_time(Date l_update_time) {
        this.l_update_time = l_update_time;
    }

    public Integer getL_is_agree() {
        return l_is_agree;
    }

    public LeaveRecord withL_is_agree(Integer l_is_agree) {
        this.setL_is_agree(l_is_agree);
        return this;
    }

    public void setL_is_agree(Integer l_is_agree) {
        this.l_is_agree = l_is_agree;
    }

    public Float getL_time() {
        return l_time;
    }

    public LeaveRecord withL_time(Float l_time) {
        this.setL_time(l_time);
        return this;
    }

    public void setL_time(Float l_time) {
        this.l_time = l_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", l_id=").append(l_id);
        sb.append(", l_student=").append(l_student);
        sb.append(", l_teacher=").append(l_teacher);
        sb.append(", l_reason=").append(l_reason);
        sb.append(", l_type=").append(l_type);
        sb.append(", l_start_time=").append(l_start_time);
        sb.append(", l_end_time=").append(l_end_time);
        sb.append(", l_create_time=").append(l_create_time);
        sb.append(", l_update_time=").append(l_update_time);
        sb.append(", l_is_agree=").append(l_is_agree);
        sb.append(", l_time=").append(l_time);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LeaveRecord other = (LeaveRecord) that;
        return (this.getL_id() == null ? other.getL_id() == null : this.getL_id().equals(other.getL_id()))
            && (this.getL_student() == null ? other.getL_student() == null : this.getL_student().equals(other.getL_student()))
            && (this.getL_teacher() == null ? other.getL_teacher() == null : this.getL_teacher().equals(other.getL_teacher()))
            && (this.getL_reason() == null ? other.getL_reason() == null : this.getL_reason().equals(other.getL_reason()))
            && (this.getL_type() == null ? other.getL_type() == null : this.getL_type().equals(other.getL_type()))
            && (this.getL_start_time() == null ? other.getL_start_time() == null : this.getL_start_time().equals(other.getL_start_time()))
            && (this.getL_end_time() == null ? other.getL_end_time() == null : this.getL_end_time().equals(other.getL_end_time()))
            && (this.getL_create_time() == null ? other.getL_create_time() == null : this.getL_create_time().equals(other.getL_create_time()))
            && (this.getL_update_time() == null ? other.getL_update_time() == null : this.getL_update_time().equals(other.getL_update_time()))
            && (this.getL_is_agree() == null ? other.getL_is_agree() == null : this.getL_is_agree().equals(other.getL_is_agree()))
            && (this.getL_time() == null ? other.getL_time() == null : this.getL_time().equals(other.getL_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getL_id() == null) ? 0 : getL_id().hashCode());
        result = prime * result + ((getL_student() == null) ? 0 : getL_student().hashCode());
        result = prime * result + ((getL_teacher() == null) ? 0 : getL_teacher().hashCode());
        result = prime * result + ((getL_reason() == null) ? 0 : getL_reason().hashCode());
        result = prime * result + ((getL_type() == null) ? 0 : getL_type().hashCode());
        result = prime * result + ((getL_start_time() == null) ? 0 : getL_start_time().hashCode());
        result = prime * result + ((getL_end_time() == null) ? 0 : getL_end_time().hashCode());
        result = prime * result + ((getL_create_time() == null) ? 0 : getL_create_time().hashCode());
        result = prime * result + ((getL_update_time() == null) ? 0 : getL_update_time().hashCode());
        result = prime * result + ((getL_is_agree() == null) ? 0 : getL_is_agree().hashCode());
        result = prime * result + ((getL_time() == null) ? 0 : getL_time().hashCode());
        return result;
    }
}