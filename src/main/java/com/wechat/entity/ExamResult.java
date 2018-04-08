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
public class ExamResult implements Serializable {
    private Integer er_id;

    private Integer er_student;

    private Integer er_subject;

    private Float er_score;

    private Date er_create_time;

    private Date er_update_time;

    private static final long serialVersionUID = 1L;

    public Integer getEr_id() {
        return er_id;
    }

    public ExamResult withEr_id(Integer er_id) {
        this.setEr_id(er_id);
        return this;
    }

    public void setEr_id(Integer er_id) {
        this.er_id = er_id;
    }

    public Integer getEr_student() {
        return er_student;
    }

    public ExamResult withEr_student(Integer er_student) {
        this.setEr_student(er_student);
        return this;
    }

    public void setEr_student(Integer er_student) {
        this.er_student = er_student;
    }

    public Integer getEr_subject() {
        return er_subject;
    }

    public ExamResult withEr_subject(Integer er_subject) {
        this.setEr_subject(er_subject);
        return this;
    }

    public void setEr_subject(Integer er_subject) {
        this.er_subject = er_subject;
    }

    public Float getEr_score() {
        return er_score;
    }

    public ExamResult withEr_score(Float er_score) {
        this.setEr_score(er_score);
        return this;
    }

    public void setEr_score(Float er_score) {
        this.er_score = er_score;
    }

    public Date getEr_create_time() {
        return er_create_time;
    }

    public ExamResult withEr_create_time(Date er_create_time) {
        this.setEr_create_time(er_create_time);
        return this;
    }

    public void setEr_create_time(Date er_create_time) {
        this.er_create_time = er_create_time;
    }

    public Date getEr_update_time() {
        return er_update_time;
    }

    public ExamResult withEr_update_time(Date er_update_time) {
        this.setEr_update_time(er_update_time);
        return this;
    }

    public void setEr_update_time(Date er_update_time) {
        this.er_update_time = er_update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", er_id=").append(er_id);
        sb.append(", er_student=").append(er_student);
        sb.append(", er_subject=").append(er_subject);
        sb.append(", er_score=").append(er_score);
        sb.append(", er_create_time=").append(er_create_time);
        sb.append(", er_update_time=").append(er_update_time);
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
        ExamResult other = (ExamResult) that;
        return (this.getEr_id() == null ? other.getEr_id() == null : this.getEr_id().equals(other.getEr_id()))
            && (this.getEr_student() == null ? other.getEr_student() == null : this.getEr_student().equals(other.getEr_student()))
            && (this.getEr_subject() == null ? other.getEr_subject() == null : this.getEr_subject().equals(other.getEr_subject()))
            && (this.getEr_score() == null ? other.getEr_score() == null : this.getEr_score().equals(other.getEr_score()))
            && (this.getEr_create_time() == null ? other.getEr_create_time() == null : this.getEr_create_time().equals(other.getEr_create_time()))
            && (this.getEr_update_time() == null ? other.getEr_update_time() == null : this.getEr_update_time().equals(other.getEr_update_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEr_id() == null) ? 0 : getEr_id().hashCode());
        result = prime * result + ((getEr_student() == null) ? 0 : getEr_student().hashCode());
        result = prime * result + ((getEr_subject() == null) ? 0 : getEr_subject().hashCode());
        result = prime * result + ((getEr_score() == null) ? 0 : getEr_score().hashCode());
        result = prime * result + ((getEr_create_time() == null) ? 0 : getEr_create_time().hashCode());
        result = prime * result + ((getEr_update_time() == null) ? 0 : getEr_update_time().hashCode());
        return result;
    }
}