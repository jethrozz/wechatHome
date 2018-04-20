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
public class Class implements Serializable {
    private Integer c_id;

    private Integer c_gread;

    private Integer c_class;

    private Date c_create_time;

    private Date c_update_time;

    private Integer c_teacher;

    private Teacher headMaster;
    private static final long serialVersionUID = 1L;

    public Integer getC_id() {
        return c_id;
    }

    public Teacher getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(Teacher headMaster) {
        this.headMaster = headMaster;
    }

    public Class withC_id(Integer c_id) {
        this.setC_id(c_id);
        return this;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getC_gread() {
        return c_gread;
    }

    public Class withC_gread(Integer c_gread) {
        this.setC_gread(c_gread);
        return this;
    }

    public void setC_gread(Integer c_gread) {
        this.c_gread = c_gread;
    }

    public Integer getC_class() {
        return c_class;
    }

    public Class withC_class(Integer c_class) {
        this.setC_class(c_class);
        return this;
    }

    public void setC_class(Integer c_class) {
        this.c_class = c_class;
    }

    public Date getC_create_time() {
        return c_create_time;
    }

    public Class withC_create_time(Date c_create_time) {
        this.setC_create_time(c_create_time);
        return this;
    }

    public void setC_create_time(Date c_create_time) {
        this.c_create_time = c_create_time;
    }

    public Date getC_update_time() {
        return c_update_time;
    }

    public Class withC_update_time(Date c_update_time) {
        this.setC_update_time(c_update_time);
        return this;
    }

    public void setC_update_time(Date c_update_time) {
        this.c_update_time = c_update_time;
    }

    public Integer getC_teacher() {
        return c_teacher;
    }

    public Class withC_teacher(Integer c_teacher) {
        this.setC_teacher(c_teacher);
        return this;
    }

    public void setC_teacher(Integer c_teacher) {
        this.c_teacher = c_teacher;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", c_id=").append(c_id);
        sb.append(", c_gread=").append(c_gread);
        sb.append(", c_class=").append(c_class);
        sb.append(", c_create_time=").append(c_create_time);
        sb.append(", c_update_time=").append(c_update_time);
        sb.append(", c_teacher=").append(c_teacher);
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
        Class other = (Class) that;
        return (this.getC_id() == null ? other.getC_id() == null : this.getC_id().equals(other.getC_id()))
            && (this.getC_gread() == null ? other.getC_gread() == null : this.getC_gread().equals(other.getC_gread()))
            && (this.getC_class() == null ? other.getC_class() == null : this.getC_class().equals(other.getC_class()))
            && (this.getC_create_time() == null ? other.getC_create_time() == null : this.getC_create_time().equals(other.getC_create_time()))
            && (this.getC_update_time() == null ? other.getC_update_time() == null : this.getC_update_time().equals(other.getC_update_time()))
            && (this.getC_teacher() == null ? other.getC_teacher() == null : this.getC_teacher().equals(other.getC_teacher()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getC_id() == null) ? 0 : getC_id().hashCode());
        result = prime * result + ((getC_gread() == null) ? 0 : getC_gread().hashCode());
        result = prime * result + ((getC_class() == null) ? 0 : getC_class().hashCode());
        result = prime * result + ((getC_create_time() == null) ? 0 : getC_create_time().hashCode());
        result = prime * result + ((getC_update_time() == null) ? 0 : getC_update_time().hashCode());
        result = prime * result + ((getC_teacher() == null) ? 0 : getC_teacher().hashCode());
        return result;
    }
}