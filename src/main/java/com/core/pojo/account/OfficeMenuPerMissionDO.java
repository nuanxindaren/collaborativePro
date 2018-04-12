package com.core.pojo.account;

import java.util.Date;

public class OfficeMenuPerMissionDO {
    private String perId;

    private String roleId;

    private String parentId;

    private String perName;

    private String perUrl;

    private String perLevel;

    private String insUserId;

    private String insEmpNo;

    private String insCorpNo;

    private Date insDate;

    private String updUserId;

    private String updEmpNo;

    private String updCorpNo;

    private Date updDate;

    public String getPerId() {
        return perId;
    }

    public void setPerId(String perId) {
        this.perId = perId == null ? null : perId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    public String getPerUrl() {
        return perUrl;
    }

    public void setPerUrl(String perUrl) {
        this.perUrl = perUrl == null ? null : perUrl.trim();
    }

    public String getPerLevel() {
        return perLevel;
    }

    public void setPerLevel(String perLevel) {
        this.perLevel = perLevel == null ? null : perLevel.trim();
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