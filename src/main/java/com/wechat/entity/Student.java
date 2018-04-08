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
public class Student implements Serializable {
    private Integer s_id;

    private Integer c_id;

    private Integer p_id;

    private String s_name;

    private Integer s_sex;

    private String s_identity_number;

    private String s_student_number;

    private Date s_create_time;

    private Date s_update_time;

    private static final long serialVersionUID = 1L;

    public Integer getS_id() {
        return s_id;
    }

    public Student withS_id(Integer s_id) {
        this.setS_id(s_id);
        return this;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public Student withC_id(Integer c_id) {
        this.setC_id(c_id);
        return this;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public Student withP_id(Integer p_id) {
        this.setP_id(p_id);
        return this;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getS_name() {
        return s_name;
    }

    public Student withS_name(String s_name) {
        this.setS_name(s_name);
        return this;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name == null ? null : s_name.trim();
    }

    public Integer getS_sex() {
        return s_sex;
    }

    public Student withS_sex(Integer s_sex) {
        this.setS_sex(s_sex);
        return this;
    }

    public void setS_sex(Integer s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_identity_number() {
        return s_identity_number;
    }

    public Student withS_identity_number(String s_identity_number) {
        this.setS_identity_number(s_identity_number);
        return this;
    }

    public void setS_identity_number(String s_identity_number) {
        this.s_identity_number = s_identity_number == null ? null : s_identity_number.trim();
    }

    public String getS_student_number() {
        return s_student_number;
    }

    public Student withS_student_number(String s_student_number) {
        this.setS_student_number(s_student_number);
        return this;
    }

    public void setS_student_number(String s_student_number) {
        this.s_student_number = s_student_number == null ? null : s_student_number.trim();
    }

    public Date getS_create_time() {
        return s_create_time;
    }

    public Student withS_create_time(Date s_create_time) {
        this.setS_create_time(s_create_time);
        return this;
    }

    public void setS_create_time(Date s_create_time) {
        this.s_create_time = s_create_time;
    }

    public Date getS_update_time() {
        return s_update_time;
    }

    public Student withS_update_time(Date s_update_time) {
        this.setS_update_time(s_update_time);
        return this;
    }

    public void setS_update_time(Date s_update_time) {
        this.s_update_time = s_update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", s_id=").append(s_id);
        sb.append(", c_id=").append(c_id);
        sb.append(", p_id=").append(p_id);
        sb.append(", s_name=").append(s_name);
        sb.append(", s_sex=").append(s_sex);
        sb.append(", s_identity_number=").append(s_identity_number);
        sb.append(", s_student_number=").append(s_student_number);
        sb.append(", s_create_time=").append(s_create_time);
        sb.append(", s_update_time=").append(s_update_time);
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
        Student other = (Student) that;
        return (this.getS_id() == null ? other.getS_id() == null : this.getS_id().equals(other.getS_id()))
            && (this.getC_id() == null ? other.getC_id() == null : this.getC_id().equals(other.getC_id()))
            && (this.getP_id() == null ? other.getP_id() == null : this.getP_id().equals(other.getP_id()))
            && (this.getS_name() == null ? other.getS_name() == null : this.getS_name().equals(other.getS_name()))
            && (this.getS_sex() == null ? other.getS_sex() == null : this.getS_sex().equals(other.getS_sex()))
            && (this.getS_identity_number() == null ? other.getS_identity_number() == null : this.getS_identity_number().equals(other.getS_identity_number()))
            && (this.getS_student_number() == null ? other.getS_student_number() == null : this.getS_student_number().equals(other.getS_student_number()))
            && (this.getS_create_time() == null ? other.getS_create_time() == null : this.getS_create_time().equals(other.getS_create_time()))
            && (this.getS_update_time() == null ? other.getS_update_time() == null : this.getS_update_time().equals(other.getS_update_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getS_id() == null) ? 0 : getS_id().hashCode());
        result = prime * result + ((getC_id() == null) ? 0 : getC_id().hashCode());
        result = prime * result + ((getP_id() == null) ? 0 : getP_id().hashCode());
        result = prime * result + ((getS_name() == null) ? 0 : getS_name().hashCode());
        result = prime * result + ((getS_sex() == null) ? 0 : getS_sex().hashCode());
        result = prime * result + ((getS_identity_number() == null) ? 0 : getS_identity_number().hashCode());
        result = prime * result + ((getS_student_number() == null) ? 0 : getS_student_number().hashCode());
        result = prime * result + ((getS_create_time() == null) ? 0 : getS_create_time().hashCode());
        result = prime * result + ((getS_update_time() == null) ? 0 : getS_update_time().hashCode());
        return result;
    }
}