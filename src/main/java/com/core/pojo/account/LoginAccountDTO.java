package com.core.pojo.account;

import java.io.Serializable;

/**
 * @author renyangze
 * @date 2018/3/20
 */
public class LoginAccountDTO implements Serializable {

    private static final long serialVersionUID = -8935609182450164251L;

    public static final Long _0 = new Long(0);

    public static final Long _1 = new Long(1);

    //序号
    private String id;
    //帐号
    private String account;
    //密码
    private String password;
    //公司员工号
    private String emp_no;
    //公司部门号
    private String corp_no;
    //级别代码
    private String temp_level;

    private String user_name;

    private boolean rememberMe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTemp_level() {
        return temp_level;
    }

    public void setTemp_level(String temp_level) {
        this.temp_level = temp_level;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "LoginAccountDTO{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", corp_no='" + corp_no + '\'' +
                ", temp_level='" + temp_level + '\'' +
                ", user_name='" + user_name + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}
