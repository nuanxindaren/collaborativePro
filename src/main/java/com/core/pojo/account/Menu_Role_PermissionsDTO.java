package com.core.pojo.account;

import java.util.Date;
import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/30
 */
public class Menu_Role_PermissionsDTO {
    //主键索引
    private String user_role_id;
    //对应菜单表ID
    private String permissions_menu_id;
    //------------------------------------------------
    private String emp_no;

    private String corp_no;
    //------------------------------------------------
    //读权限
    private String permissions_read;
    //增加权限
    private String permissions_add;
    //修改权限
    private String permissions_upd;
    //删除权限
    private String permissions_del;

    private List<Menu_PermissionsDO> listMenu_Permissions;

    private String ins_user_id;
    private Date ins_date;
    private String upd_user_id;
    private Date upd_date;

    public String getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(String user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getPermissions_menu_id() {
        return permissions_menu_id;
    }

    public void setPermissions_menu_id(String permissions_menu_id) {
        this.permissions_menu_id = permissions_menu_id;
    }

    public String getPermissions_read() {
        return permissions_read;
    }

    public void setPermissions_read(String permissions_read) {
        this.permissions_read = permissions_read;
    }

    public String getPermissions_add() {
        return permissions_add;
    }

    public void setPermissions_add(String permissions_add) {
        this.permissions_add = permissions_add;
    }

    public String getPermissions_upd() {
        return permissions_upd;
    }

    public void setPermissions_upd(String permissions_upd) {
        this.permissions_upd = permissions_upd;
    }

    public String getPermissions_del() {
        return permissions_del;
    }

    public void setPermissions_del(String permissions_del) {
        this.permissions_del = permissions_del;
    }

    public List<Menu_PermissionsDO> getListMenu_Permissions() {
        return listMenu_Permissions;
    }

    public void setListMenu_Permissions(List<Menu_PermissionsDO> listMenu_Permissions) {
        this.listMenu_Permissions = listMenu_Permissions;
    }


    public Date getIns_date() {
        return ins_date;
    }

    public void setIns_date(Date ins_date) {
        this.ins_date = ins_date;
    }


    public Date getUpd_date() {
        return upd_date;
    }

    public void setUpd_date(Date upd_date) {
        this.upd_date = upd_date;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getCorp_no() {
        return corp_no;
    }

    public void setCorp_no(String corp_no) {
        this.corp_no = corp_no;
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

    @Override
    public String toString() {
        return "Menu_Role_PermissionsDTO{" +
                "user_role_id='" + user_role_id + '\'' +
                ", permissions_menu_id='" + permissions_menu_id + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", corp_no='" + corp_no + '\'' +
                ", permissions_read='" + permissions_read + '\'' +
                ", permissions_add='" + permissions_add + '\'' +
                ", permissions_upd='" + permissions_upd + '\'' +
                ", permissions_del='" + permissions_del + '\'' +
                ", listMenu_Permissions=" + listMenu_Permissions +
                ", ins_user_id='" + ins_user_id + '\'' +
                ", ins_date=" + ins_date +
                ", upd_user_id='" + upd_user_id + '\'' +
                ", upd_date=" + upd_date +
                '}';
    }
}
