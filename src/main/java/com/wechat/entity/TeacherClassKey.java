package com.wechat.entity;

import java.io.Serializable;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class TeacherClassKey implements Serializable {
    private Integer t_id;

    private Integer c_id;

    private static final long serialVersionUID = 1L;

    public Integer getT_id() {
        return t_id;
    }

    public TeacherClassKey withT_id(Integer t_id) {
        this.setT_id(t_id);
        return this;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public TeacherClassKey withC_id(Integer c_id) {
        this.setC_id(c_id);
        return this;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", t_id=").append(t_id);
        sb.append(", c_id=").append(c_id);
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
        TeacherClassKey other = (TeacherClassKey) that;
        return (this.getT_id() == null ? other.getT_id() == null : this.getT_id().equals(other.getT_id()))
            && (this.getC_id() == null ? other.getC_id() == null : this.getC_id().equals(other.getC_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getT_id() == null) ? 0 : getT_id().hashCode());
        result = prime * result + ((getC_id() == null) ? 0 : getC_id().hashCode());
        return result;
    }
}