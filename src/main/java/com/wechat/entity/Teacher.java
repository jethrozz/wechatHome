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
public class Teacher implements Serializable {
    private Integer t_id;

    private String t_name;

    private Integer t_subject;

    private String t_phone_number;

    private Integer t_is_headmaster;

    private Date t_create_time;

    private Date t_update_time;

    private static final long serialVersionUID = 1L;

    public Integer getT_id() {
        return t_id;
    }

    public Teacher withT_id(Integer t_id) {
        this.setT_id(t_id);
        return this;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public Teacher withT_name(String t_name) {
        this.setT_name(t_name);
        return this;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name == null ? null : t_name.trim();
    }

    public Integer getT_subject() {
        return t_subject;
    }

    public Teacher withT_subject(Integer t_subject) {
        this.setT_subject(t_subject);
        return this;
    }

    public void setT_subject(Integer t_subject) {
        this.t_subject = t_subject;
    }

    public String getT_phone_number() {
        return t_phone_number;
    }

    public Teacher withT_phone_number(String t_phone_number) {
        this.setT_phone_number(t_phone_number);
        return this;
    }

    public void setT_phone_number(String t_phone_number) {
        this.t_phone_number = t_phone_number == null ? null : t_phone_number.trim();
    }

    public Integer getT_is_headmaster() {
        return t_is_headmaster;
    }

    public Teacher withT_is_headmaster(Integer t_is_headmaster) {
        this.setT_is_headmaster(t_is_headmaster);
        return this;
    }

    public void setT_is_headmaster(Integer t_is_headmaster) {
        this.t_is_headmaster = t_is_headmaster;
    }

    public Date getT_create_time() {
        return t_create_time;
    }

    public Teacher withT_create_time(Date t_create_time) {
        this.setT_create_time(t_create_time);
        return this;
    }

    public void setT_create_time(Date t_create_time) {
        this.t_create_time = t_create_time;
    }

    public Date getT_update_time() {
        return t_update_time;
    }

    public Teacher withT_update_time(Date t_update_time) {
        this.setT_update_time(t_update_time);
        return this;
    }

    public void setT_update_time(Date t_update_time) {
        this.t_update_time = t_update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", t_id=").append(t_id);
        sb.append(", t_name=").append(t_name);
        sb.append(", t_subject=").append(t_subject);
        sb.append(", t_phone_number=").append(t_phone_number);
        sb.append(", t_is_headmaster=").append(t_is_headmaster);
        sb.append(", t_create_time=").append(t_create_time);
        sb.append(", t_update_time=").append(t_update_time);
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
        Teacher other = (Teacher) that;
        return (this.getT_id() == null ? other.getT_id() == null : this.getT_id().equals(other.getT_id()))
            && (this.getT_name() == null ? other.getT_name() == null : this.getT_name().equals(other.getT_name()))
            && (this.getT_subject() == null ? other.getT_subject() == null : this.getT_subject().equals(other.getT_subject()))
            && (this.getT_phone_number() == null ? other.getT_phone_number() == null : this.getT_phone_number().equals(other.getT_phone_number()))
            && (this.getT_is_headmaster() == null ? other.getT_is_headmaster() == null : this.getT_is_headmaster().equals(other.getT_is_headmaster()))
            && (this.getT_create_time() == null ? other.getT_create_time() == null : this.getT_create_time().equals(other.getT_create_time()))
            && (this.getT_update_time() == null ? other.getT_update_time() == null : this.getT_update_time().equals(other.getT_update_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getT_id() == null) ? 0 : getT_id().hashCode());
        result = prime * result + ((getT_name() == null) ? 0 : getT_name().hashCode());
        result = prime * result + ((getT_subject() == null) ? 0 : getT_subject().hashCode());
        result = prime * result + ((getT_phone_number() == null) ? 0 : getT_phone_number().hashCode());
        result = prime * result + ((getT_is_headmaster() == null) ? 0 : getT_is_headmaster().hashCode());
        result = prime * result + ((getT_create_time() == null) ? 0 : getT_create_time().hashCode());
        result = prime * result + ((getT_update_time() == null) ? 0 : getT_update_time().hashCode());
        return result;
    }
}