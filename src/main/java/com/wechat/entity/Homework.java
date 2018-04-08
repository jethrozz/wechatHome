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
public class Homework implements Serializable {
    private Integer h_id;

    private String h_title;

    private Date h_finsh_time;

    private Integer h_teacher;

    private Integer h_class;

    private Date h_create_time;

    private Date h_update_time;

    private String h_content;

    private static final long serialVersionUID = 1L;

    public Integer getH_id() {
        return h_id;
    }

    public Homework withH_id(Integer h_id) {
        this.setH_id(h_id);
        return this;
    }

    public void setH_id(Integer h_id) {
        this.h_id = h_id;
    }

    public String getH_title() {
        return h_title;
    }

    public Homework withH_title(String h_title) {
        this.setH_title(h_title);
        return this;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title == null ? null : h_title.trim();
    }

    public Date getH_finsh_time() {
        return h_finsh_time;
    }

    public Homework withH_finsh_time(Date h_finsh_time) {
        this.setH_finsh_time(h_finsh_time);
        return this;
    }

    public void setH_finsh_time(Date h_finsh_time) {
        this.h_finsh_time = h_finsh_time;
    }

    public Integer getH_teacher() {
        return h_teacher;
    }

    public Homework withH_teacher(Integer h_teacher) {
        this.setH_teacher(h_teacher);
        return this;
    }

    public void setH_teacher(Integer h_teacher) {
        this.h_teacher = h_teacher;
    }

    public Integer getH_class() {
        return h_class;
    }

    public Homework withH_class(Integer h_class) {
        this.setH_class(h_class);
        return this;
    }

    public void setH_class(Integer h_class) {
        this.h_class = h_class;
    }

    public Date getH_create_time() {
        return h_create_time;
    }

    public Homework withH_create_time(Date h_create_time) {
        this.setH_create_time(h_create_time);
        return this;
    }

    public void setH_create_time(Date h_create_time) {
        this.h_create_time = h_create_time;
    }

    public Date getH_update_time() {
        return h_update_time;
    }

    public Homework withH_update_time(Date h_update_time) {
        this.setH_update_time(h_update_time);
        return this;
    }

    public void setH_update_time(Date h_update_time) {
        this.h_update_time = h_update_time;
    }

    public String getH_content() {
        return h_content;
    }

    public Homework withH_content(String h_content) {
        this.setH_content(h_content);
        return this;
    }

    public void setH_content(String h_content) {
        this.h_content = h_content == null ? null : h_content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", h_id=").append(h_id);
        sb.append(", h_title=").append(h_title);
        sb.append(", h_finsh_time=").append(h_finsh_time);
        sb.append(", h_teacher=").append(h_teacher);
        sb.append(", h_class=").append(h_class);
        sb.append(", h_create_time=").append(h_create_time);
        sb.append(", h_update_time=").append(h_update_time);
        sb.append(", h_content=").append(h_content);
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
        Homework other = (Homework) that;
        return (this.getH_id() == null ? other.getH_id() == null : this.getH_id().equals(other.getH_id()))
            && (this.getH_title() == null ? other.getH_title() == null : this.getH_title().equals(other.getH_title()))
            && (this.getH_finsh_time() == null ? other.getH_finsh_time() == null : this.getH_finsh_time().equals(other.getH_finsh_time()))
            && (this.getH_teacher() == null ? other.getH_teacher() == null : this.getH_teacher().equals(other.getH_teacher()))
            && (this.getH_class() == null ? other.getH_class() == null : this.getH_class().equals(other.getH_class()))
            && (this.getH_create_time() == null ? other.getH_create_time() == null : this.getH_create_time().equals(other.getH_create_time()))
            && (this.getH_update_time() == null ? other.getH_update_time() == null : this.getH_update_time().equals(other.getH_update_time()))
            && (this.getH_content() == null ? other.getH_content() == null : this.getH_content().equals(other.getH_content()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getH_id() == null) ? 0 : getH_id().hashCode());
        result = prime * result + ((getH_title() == null) ? 0 : getH_title().hashCode());
        result = prime * result + ((getH_finsh_time() == null) ? 0 : getH_finsh_time().hashCode());
        result = prime * result + ((getH_teacher() == null) ? 0 : getH_teacher().hashCode());
        result = prime * result + ((getH_class() == null) ? 0 : getH_class().hashCode());
        result = prime * result + ((getH_create_time() == null) ? 0 : getH_create_time().hashCode());
        result = prime * result + ((getH_update_time() == null) ? 0 : getH_update_time().hashCode());
        result = prime * result + ((getH_content() == null) ? 0 : getH_content().hashCode());
        return result;
    }
}