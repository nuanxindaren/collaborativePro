package com.core.pojo.weekly;

import java.util.Date;

public class OfficeReportDO {
    private String reportId;

    private String empNo;

    private String corpNo;

    private String reportTitle;

    private String reportUserId;

    private Date reportSdtTime;

    private Date reportEndTime;

    private String reportRemark;

    private String insEmpNo;

    private String insCorpNo;

    private String insUserId;

    private Date insDate;

    private String updUserId;

    private String updEmpNo;

    private String updCorpNo;

    private Date updDate;

    private String reportAuthor;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
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

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle == null ? null : reportTitle.trim();
    }

    public String getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(String reportUserId) {
        this.reportUserId = reportUserId == null ? null : reportUserId.trim();
    }

    public Date getReportSdtTime() {
        return reportSdtTime;
    }

    public void setReportSdtTime(Date reportSdtTime) {
        this.reportSdtTime = reportSdtTime;
    }

    public Date getReportEndTime() {
        return reportEndTime;
    }

    public void setReportEndTime(Date reportEndTime) {
        this.reportEndTime = reportEndTime;
    }

    public String getReportRemark() {
        return reportRemark;
    }

    public void setReportRemark(String reportRemark) {
        this.reportRemark = reportRemark == null ? null : reportRemark.trim();
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

    public String getReportAuthor() {
        return reportAuthor;
    }

    public void setReportAuthor(String reportAuthor) {
        this.reportAuthor = reportAuthor;
    }

    @Override
    public String toString() {
        return "OfficeReportDO{" +
                "reportId='" + reportId + '\'' +
                ", empNo='" + empNo + '\'' +
                ", corpNo='" + corpNo + '\'' +
                ", reportTitle='" + reportTitle + '\'' +
                ", reportUserId='" + reportUserId + '\'' +
                ", reportSdtTime=" + reportSdtTime +
                ", reportEndTime=" + reportEndTime +
                ", reportRemark='" + reportRemark + '\'' +
                ", insEmpNo='" + insEmpNo + '\'' +
                ", insCorpNo='" + insCorpNo + '\'' +
                ", insUserId='" + insUserId + '\'' +
                ", insDate=" + insDate +
                ", updUserId='" + updUserId + '\'' +
                ", updEmpNo='" + updEmpNo + '\'' +
                ", updCorpNo='" + updCorpNo + '\'' +
                ", updDate=" + updDate +
                '}';
    }
}