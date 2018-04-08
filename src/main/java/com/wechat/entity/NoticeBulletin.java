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
public class NoticeBulletin implements Serializable {
    private Integer nb_id;

    private Integer t_id;

    private Integer nb_type;

    private String nb_title;

    private Date nb_create_time;

    private Date nb_update_time;

    private String nb_content;

    private static final long serialVersionUID = 1L;

    public Integer getNb_id() {
        return nb_id;
    }

    public NoticeBulletin withNb_id(Integer nb_id) {
        this.setNb_id(nb_id);
        return this;
    }

    public void setNb_id(Integer nb_id) {
        this.nb_id = nb_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public NoticeBulletin withT_id(Integer t_id) {
        this.setT_id(t_id);
        return this;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getNb_type() {
        return nb_type;
    }

    public NoticeBulletin withNb_type(Integer nb_type) {
        this.setNb_type(nb_type);
        return this;
    }

    public void setNb_type(Integer nb_type) {
        this.nb_type = nb_type;
    }

    public String getNb_title() {
        return nb_title;
    }

    public NoticeBulletin withNb_title(String nb_title) {
        this.setNb_title(nb_title);
        return this;
    }

    public void setNb_title(String nb_title) {
        this.nb_title = nb_title == null ? null : nb_title.trim();
    }

    public Date getNb_create_time() {
        return nb_create_time;
    }

    public NoticeBulletin withNb_create_time(Date nb_create_time) {
        this.setNb_create_time(nb_create_time);
        return this;
    }

    public void setNb_create_time(Date nb_create_time) {
        this.nb_create_time = nb_create_time;
    }

    public Date getNb_update_time() {
        return nb_update_time;
    }

    public NoticeBulletin withNb_update_time(Date nb_update_time) {
        this.setNb_update_time(nb_update_time);
        return this;
    }

    public void setNb_update_time(Date nb_update_time) {
        this.nb_update_time = nb_update_time;
    }

    public String getNb_content() {
        return nb_content;
    }

    public NoticeBulletin withNb_content(String nb_content) {
        this.setNb_content(nb_content);
        return this;
    }

    public void setNb_content(String nb_content) {
        this.nb_content = nb_content == null ? null : nb_content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nb_id=").append(nb_id);
        sb.append(", t_id=").append(t_id);
        sb.append(", nb_type=").append(nb_type);
        sb.append(", nb_title=").append(nb_title);
        sb.append(", nb_create_time=").append(nb_create_time);
        sb.append(", nb_update_time=").append(nb_update_time);
        sb.append(", nb_content=").append(nb_content);
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
        NoticeBulletin other = (NoticeBulletin) that;
        return (this.getNb_id() == null ? other.getNb_id() == null : this.getNb_id().equals(other.getNb_id()))
            && (this.getT_id() == null ? other.getT_id() == null : this.getT_id().equals(other.getT_id()))
            && (this.getNb_type() == null ? other.getNb_type() == null : this.getNb_type().equals(other.getNb_type()))
            && (this.getNb_title() == null ? other.getNb_title() == null : this.getNb_title().equals(other.getNb_title()))
            && (this.getNb_create_time() == null ? other.getNb_create_time() == null : this.getNb_create_time().equals(other.getNb_create_time()))
            && (this.getNb_update_time() == null ? other.getNb_update_time() == null : this.getNb_update_time().equals(other.getNb_update_time()))
            && (this.getNb_content() == null ? other.getNb_content() == null : this.getNb_content().equals(other.getNb_content()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNb_id() == null) ? 0 : getNb_id().hashCode());
        result = prime * result + ((getT_id() == null) ? 0 : getT_id().hashCode());
        result = prime * result + ((getNb_type() == null) ? 0 : getNb_type().hashCode());
        result = prime * result + ((getNb_title() == null) ? 0 : getNb_title().hashCode());
        result = prime * result + ((getNb_create_time() == null) ? 0 : getNb_create_time().hashCode());
        result = prime * result + ((getNb_update_time() == null) ? 0 : getNb_update_time().hashCode());
        result = prime * result + ((getNb_content() == null) ? 0 : getNb_content().hashCode());
        return result;
    }
}