package com.core.pojo.weekly;

import java.util.Date;
import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/29
 */
public class OfficeReportDTO {
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

    private List<OfficeDetailsDO> officeDetailsDOList;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getCorpNo() {
        return corpNo;
    }

    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(String reportUserId) {
        this.reportUserId = reportUserId;
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
        this.reportRemark = reportRemark;
    }

    public String getInsEmpNo() {
        return insEmpNo;
    }

    public void setInsEmpNo(String insEmpNo) {
        this.insEmpNo = insEmpNo;
    }

    public String getInsCorpNo() {
        return insCorpNo;
    }

    public void setInsCorpNo(String insCorpNo) {
        this.insCorpNo = insCorpNo;
    }

    public String getInsUserId() {
        return insUserId;
    }

    public void setInsUserId(String insUserId) {
        this.insUserId = insUserId;
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
        this.updUserId = updUserId;
    }

    public String getUpdEmpNo() {
        return updEmpNo;
    }

    public void setUpdEmpNo(String updEmpNo) {
        this.updEmpNo = updEmpNo;
    }

    public String getUpdCorpNo() {
        return updCorpNo;
    }

    public void setUpdCorpNo(String updCorpNo) {
        this.updCorpNo = updCorpNo;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public List<OfficeDetailsDO> getOfficeDetailsDOList() {
        return officeDetailsDOList;
    }

    public void setOfficeDetailsDOList(List<OfficeDetailsDO> officeDetailsDOList) {
        this.officeDetailsDOList = officeDetailsDOList;
    }

    public String getReportAuthor() {
        return reportAuthor;
    }

    public void setReportAuthor(String reportAuthor) {
        this.reportAuthor = reportAuthor;
    }

    @Override
    public String toString() {
        return "OfficeReportDTO{" +
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
                ", officeDetailsDOList=" + officeDetailsDOList +
                '}';
    }
}
