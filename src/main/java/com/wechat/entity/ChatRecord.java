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
public class ChatRecord implements Serializable {
    private Integer cr_id;

    private Integer cr_from_user;

    private Integer cr_to_user;

    private Date cr_create_time;

    private String cr_content;

    private static final long serialVersionUID = 1L;

    public Integer getCr_id() {
        return cr_id;
    }

    public ChatRecord withCr_id(Integer cr_id) {
        this.setCr_id(cr_id);
        return this;
    }

    public void setCr_id(Integer cr_id) {
        this.cr_id = cr_id;
    }

    public Integer getCr_from_user() {
        return cr_from_user;
    }

    public ChatRecord withCr_from_user(Integer cr_from_user) {
        this.setCr_from_user(cr_from_user);
        return this;
    }

    public void setCr_from_user(Integer cr_from_user) {
        this.cr_from_user = cr_from_user;
    }

    public Integer getCr_to_user() {
        return cr_to_user;
    }

    public ChatRecord withCr_to_user(Integer cr_to_user) {
        this.setCr_to_user(cr_to_user);
        return this;
    }

    public void setCr_to_user(Integer cr_to_user) {
        this.cr_to_user = cr_to_user;
    }

    public Date getCr_create_time() {
        return cr_create_time;
    }

    public ChatRecord withCr_create_time(Date cr_create_time) {
        this.setCr_create_time(cr_create_time);
        return this;
    }

    public void setCr_create_time(Date cr_create_time) {
        this.cr_create_time = cr_create_time;
    }

    public String getCr_content() {
        return cr_content;
    }

    public ChatRecord withCr_content(String cr_content) {
        this.setCr_content(cr_content);
        return this;
    }

    public void setCr_content(String cr_content) {
        this.cr_content = cr_content == null ? null : cr_content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cr_id=").append(cr_id);
        sb.append(", cr_from_user=").append(cr_from_user);
        sb.append(", cr_to_user=").append(cr_to_user);
        sb.append(", cr_create_time=").append(cr_create_time);
        sb.append(", cr_content=").append(cr_content);
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
        ChatRecord other = (ChatRecord) that;
        return (this.getCr_id() == null ? other.getCr_id() == null : this.getCr_id().equals(other.getCr_id()))
            && (this.getCr_from_user() == null ? other.getCr_from_user() == null : this.getCr_from_user().equals(other.getCr_from_user()))
            && (this.getCr_to_user() == null ? other.getCr_to_user() == null : this.getCr_to_user().equals(other.getCr_to_user()))
            && (this.getCr_create_time() == null ? other.getCr_create_time() == null : this.getCr_create_time().equals(other.getCr_create_time()))
            && (this.getCr_content() == null ? other.getCr_content() == null : this.getCr_content().equals(other.getCr_content()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCr_id() == null) ? 0 : getCr_id().hashCode());
        result = prime * result + ((getCr_from_user() == null) ? 0 : getCr_from_user().hashCode());
        result = prime * result + ((getCr_to_user() == null) ? 0 : getCr_to_user().hashCode());
        result = prime * result + ((getCr_create_time() == null) ? 0 : getCr_create_time().hashCode());
        result = prime * result + ((getCr_content() == null) ? 0 : getCr_content().hashCode());
        return result;
    }
}