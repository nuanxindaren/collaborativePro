package com.core.pojo.account;

import java.util.Date;

/**
 * @author renyangze
 * @date 2018/3/30
 */
public class Menu_PermissionsDO {
    //主键
    private String per_id;
    //对应权限表
    private String role_id;
    //父级主键
    private String parent_id;
    //菜单名称
    private String per_name;
    //图标路径
    private String icon_url;
    //菜单路径
    private String per_url;
    //菜单权重
    private Integer per_level;
    //Oracle---level
    private String level;

    private String ins_user_id;
    private Date ins_date;
    private String upd_user_id;
    private Date upd_date;

    public String getPer_id() {
        return per_id;
    }

    public void setPer_id(String per_id) {
        this.per_id = per_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getPer_name() {
        return per_name;
    }

    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getPer_url() {
        return per_url;
    }

    public void setPer_url(String per_url) {
        this.per_url = per_url;
    }

    public Integer getPer_level() {
        return per_level;
    }

    public void setPer_level(Integer per_level) {
        this.per_level = per_level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



    public Date getIns_date() {
        return ins_date;
    }

    public void setIns_date(Date ins_date) {
        this.ins_date = ins_date;
    }

    public String getIns_user_id() {
        return ins_user_id;
    }

    public void setIns_user_id(String ins_user_id) {
        this.ins_user_id = ins_user_id;
    }

    public String getUpd_user_id() {
        return upd_user_id;
    }

    public void setUpd_user_id(String upd_user_id) {
        this.upd_user_id = upd_user_id;
    }

    public Date getUpd_date() {
        return upd_date;
    }

    public void setUpd_date(Date upd_date) {
        this.upd_date = upd_date;
    }

    @Override
    public String toString() {
        return "Menu_PermissionsDO{" +
                "per_id='" + per_id + '\'' +
                ", role_id='" + role_id + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", per_name='" + per_name + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", per_url='" + per_url + '\'' +
                ", per_level=" + per_level +
                ", level='" + level + '\'' +
                ", ins_user_id='" + ins_user_id + '\'' +
                ", ins_date=" + ins_date +
                ", upd_user_id='" + upd_user_id + '\'' +
                ", upd_date=" + upd_date +
                '}';
    }
}
