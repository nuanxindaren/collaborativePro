package com.core.service;

import com.core.pojo.weekly.OfficeDetailsDO;
import com.core.pojo.weekly.OfficeReportDO;
import com.core.pojo.weekly.OfficeReportDTO;
import com.core.pojo.weekly.WeeklyDTO;

import java.util.Date;
import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/27
 */
public interface OfficeReportService {
    List<OfficeReportDO> selectByUserId(String id);


    void insertWeekly(WeeklyDTO weeklyDTO);

    OfficeReportDO selectReport(Date beginDate, Date endDate, String id);

    List<OfficeDetailsDO> selectDetails(String reportId);

    List<OfficeReportDO> getWorkerListReport(Date beginDate, Date endDate);

    List<OfficeReportDTO> getWorkerListReportAndDetails(Date beginDate, Date endDate);
}
