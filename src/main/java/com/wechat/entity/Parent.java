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
public class Parent implements Serializable {
    private Integer p_id;

    private String p_name;

    private String p_phone_number;

    private Date p_create_time;

    private Date p_update_time;

    private static final long serialVersionUID = 1L;

    public Integer getP_id() {
        return p_id;
    }

    public Parent withP_id(Integer p_id) {
        this.setP_id(p_id);
        return this;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public Parent withP_name(String p_name) {
        this.setP_name(p_name);
        return this;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name == null ? null : p_name.trim();
    }

    public String getP_phone_number() {
        return p_phone_number;
    }

    public Parent withP_phone_number(String p_phone_number) {
        this.setP_phone_number(p_phone_number);
        return this;
    }

    public void setP_phone_number(String p_phone_number) {
        this.p_phone_number = p_phone_number == null ? null : p_phone_number.trim();
    }

    public Date getP_create_time() {
        return p_create_time;
    }

    public Parent withP_create_time(Date p_create_time) {
        this.setP_create_time(p_create_time);
        return this;
    }

    public void setP_create_time(Date p_create_time) {
        this.p_create_time = p_create_time;
    }

    public Date getP_update_time() {
        return p_update_time;
    }

    public Parent withP_update_time(Date p_update_time) {
        this.setP_update_time(p_update_time);
        return this;
    }

    public void setP_update_time(Date p_update_time) {
        this.p_update_time = p_update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", p_id=").append(p_id);
        sb.append(", p_name=").append(p_name);
        sb.append(", p_phone_number=").append(p_phone_number);
        sb.append(", p_create_time=").append(p_create_time);
        sb.append(", p_update_time=").append(p_update_time);
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
        Parent other = (Parent) that;
        return (this.getP_id() == null ? other.getP_id() == null : this.getP_id().equals(other.getP_id()))
            && (this.getP_name() == null ? other.getP_name() == null : this.getP_name().equals(other.getP_name()))
            && (this.getP_phone_number() == null ? other.getP_phone_number() == null : this.getP_phone_number().equals(other.getP_phone_number()))
            && (this.getP_create_time() == null ? other.getP_create_time() == null : this.getP_create_time().equals(other.getP_create_time()))
            && (this.getP_update_time() == null ? other.getP_update_time() == null : this.getP_update_time().equals(other.getP_update_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getP_id() == null) ? 0 : getP_id().hashCode());
        result = prime * result + ((getP_name() == null) ? 0 : getP_name().hashCode());
        result = prime * result + ((getP_phone_number() == null) ? 0 : getP_phone_number().hashCode());
        result = prime * result + ((getP_create_time() == null) ? 0 : getP_create_time().hashCode());
        result = prime * result + ((getP_update_time() == null) ? 0 : getP_update_time().hashCode());
        return result;
    }
}