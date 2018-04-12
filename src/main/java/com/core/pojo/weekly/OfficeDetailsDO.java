package com.core.pojo.weekly;

import java.util.Date;

public class OfficeDetailsDO {
    private String detailsId;

    private String reportId;

    private String detailsContext;

    private String detailsComplete;

    private String detailsPriority;

    private String detailsNumber;

    private String empNo;

    private String corpNo;

    private String detailsUserId;

    private String insEmpNo;

    private String insCorpNo;

    private String insUserId;

    private String updEmpNo;

    private String updCorpNo;

    private String updUserId;

    private Date insDate;

    private Date updDate;

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId == null ? null : detailsId.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getDetailsContext() {
        return detailsContext;
    }

    public void setDetailsContext(String detailsContext) {
        this.detailsContext = detailsContext == null ? null : detailsContext.trim();
    }

    public String getDetailsComplete() {
        return detailsComplete;
    }

    public void setDetailsComplete(String detailsComplete) {
        this.detailsComplete = detailsComplete == null ? null : detailsComplete.trim();
    }

    public String getDetailsPriority() {
        return detailsPriority;
    }

    public void setDetailsPriority(String detailsPriority) {
        this.detailsPriority = detailsPriority == null ? null : detailsPriority.trim();
    }

    public String getDetailsNumber() {
        return detailsNumber;
    }

    public void setDetailsNumber(String detailsNumber) {
        this.detailsNumber = detailsNumber == null ? null : detailsNumber.trim();
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

    public String getDetailsUserId() {
        return detailsUserId;
    }

    public void setDetailsUserId(String detailsUserId) {
        this.detailsUserId = detailsUserId == null ? null : detailsUserId.trim();
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

    public String getInsUserId() {
        return insUserId;
    }

    public void setInsUserId(String insUserId) {
        this.insUserId = insUserId == null ? null : insUserId.trim();
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

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    @Override
    public String toString() {
        return "OfficeDetailsDO{" +
                "detailsId='" + detailsId + '\'' +
                ", reportId='" + reportId + '\'' +
                ", detailsContext='" + detailsContext + '\'' +
                ", detailsComplete='" + detailsComplete + '\'' +
                ", detailsPriority='" + detailsPriority + '\'' +
                ", detailsNumber='" + detailsNumber + '\'' +
                ", empNo='" + empNo + '\'' +
                ", corpNo='" + corpNo + '\'' +
                ", detailsUserId='" + detailsUserId + '\'' +
                ", insEmpNo='" + insEmpNo + '\'' +
                ", insCorpNo='" + insCorpNo + '\'' +
                ", insUserId='" + insUserId + '\'' +
                ", updEmpNo='" + updEmpNo + '\'' +
                ", updCorpNo='" + updCorpNo + '\'' +
                ", updUserId='" + updUserId + '\'' +
                ", insDate=" + insDate +
                ", updDate=" + updDate +
                '}';
    }
}