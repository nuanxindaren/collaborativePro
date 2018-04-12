package com.core.dao;

import com.core.pojo.weekly.OfficeReportDO;
import com.core.pojo.weekly.OfficeReportDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OfficeReportDOMapper {
    int deleteByPrimaryKey(String reportId);

    int insert(OfficeReportDO record);

    int insertSelective(OfficeReportDO record);

    OfficeReportDO selectByPrimaryKey(String reportId);

    int updateByPrimaryKeySelective(OfficeReportDO record);

    int updateByPrimaryKey(OfficeReportDO record);

    List<OfficeReportDO> selectByUserId(String id);

    OfficeReportDO selectReport(@Param(value = "beginDate")Date beginDate, @Param(value = "endDate")Date endDate, @Param(value = "id")String id);

    List<OfficeReportDO> getWorkerListReport(@Param(value = "beginDate")Date beginDate, @Param(value = "endDate")Date endDate);

    List<OfficeReportDTO> getWorkerListReportAndDetails(@Param(value = "beginDate")Date beginDate, @Param(value = "endDate")Date endDate);

    OfficeReportDO selectByUserIdAndDate(@Param(value = "id")String reportUserId,@Param(value = "beginDate") Date reportSdtTime, @Param(value = "endDate") Date reportEndTime);
}