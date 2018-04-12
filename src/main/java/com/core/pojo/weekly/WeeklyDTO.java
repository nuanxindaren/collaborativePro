package com.core.pojo.weekly;

import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/29
 */
public class WeeklyDTO {

    private OfficeReportDO officeReportDO;

    private List<OfficeDetailsDO> thisWeek;

    private List<OfficeDetailsDO> nextWeek;

    public List<OfficeDetailsDO> getThisWeek() {
        return thisWeek;
    }

    public void setThisWeek(List<OfficeDetailsDO> thisWeek) {
        this.thisWeek = thisWeek;
    }

    public List<OfficeDetailsDO> getNextWeek() {
        return nextWeek;
    }

    public void setNextWeek(List<OfficeDetailsDO> nextWeek) {
        this.nextWeek = nextWeek;
    }

    public OfficeReportDO getOfficeReportDO() {
        return officeReportDO;
    }

    public void setOfficeReportDO(OfficeReportDO officeReportDO) {
        this.officeReportDO = officeReportDO;
    }

    @Override
    public String toString() {
        return "WeeklyDTO{" +
                "officeReportDO=" + officeReportDO +
                ", thisWeek=" + thisWeek +
                ", nextWeek=" + nextWeek +
                '}';
    }
}
