package com.core.pojo.account;

import java.util.Date;

public class OfficeAccountDO {
    private String id;

    private String account;

    private String password;

    private String empNo;

    private String corpNo;

    private String tempLevel;

    private String insUserId;

    private String insEmpNo;

    private String insCorpNo;

    private Date insDate;

    private String updUserId;

    private String updEmpNo;

    private String updCorpNo;

    private Date updDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public String getTempLevel() {
        return tempLevel;
    }

    public void setTempLevel(String tempLevel) {
        this.tempLevel = tempLevel == null ? null : tempLevel.trim();
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
}