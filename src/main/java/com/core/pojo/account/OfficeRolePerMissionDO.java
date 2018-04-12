package com.core.pojo.account;

import java.util.Date;

public class OfficeRolePerMissionDO extends OfficeRolePerMissionDOKey {
    private String permissionsRead;

    private String permissionsAdd;

    private String permissionsUpd;

    private String permissionsDel;

    private String insUserId;

    private String insEmpNo;

    private String insCorpNo;

    private Date insDate;

    private String updUserId;

    private String updEmpNo;

    private String updCorpNo;

    private Date updDate;

    private String empNo;

    private String corpNo;

    public String getPermissionsRead() {
        return permissionsRead;
    }

    public void setPermissionsRead(String permissionsRead) {
        this.permissionsRead = permissionsRead == null ? null : permissionsRead.trim();
    }

    public String getPermissionsAdd() {
        return permissionsAdd;
    }

    public void setPermissionsAdd(String permissionsAdd) {
        this.permissionsAdd = permissionsAdd == null ? null : permissionsAdd.trim();
    }

    public String getPermissionsUpd() {
        return permissionsUpd;
    }

    public void setPermissionsUpd(String permissionsUpd) {
        this.permissionsUpd = permissionsUpd == null ? null : permissionsUpd.trim();
    }

    public String getPermissionsDel() {
        return permissionsDel;
    }

    public void setPermissionsDel(String permissionsDel) {
        this.permissionsDel = permissionsDel == null ? null : permissionsDel.trim();
    }

    public String getInsUserId() {
        return insUserId;
    }

    public void setInsUserId(String insUserId) {
        this.insUserId = insUserId == null ? null : insUserId.trim();
    }

    public String getInsEmpNo() {
        return insEmpNo;
    }

    public void setInsEmpNo(String insEmpNo) {
        this.insEmpNo = insEmpNo == null ? null : insEmpNo.trim();
    }

    public String getInsCorpNo() {
        return insCorpNo;
    }

    public void setInsCorpNo(String insCorpNo) {
        this.insCorpNo = insCorpNo == null ? null : insCorpNo.trim();
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    public String getUpdEmpNo() {
        return updEmpNo;
    }

    public void setUpdEmpNo(String updEmpNo) {
        this.updEmpNo = updEmpNo == null ? null : updEmpNo.trim();
    }

    public String getUpdCorpNo() {
        return updCorpNo;
    }

    public void setUpdCorpNo(String updCorpNo) {
        this.updCorpNo = updCorpNo == null ? null : updCorpNo.trim();
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getCorpNo() {
        return corpNo;
    }

    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo == null ? null : corpNo.trim();
    }
}