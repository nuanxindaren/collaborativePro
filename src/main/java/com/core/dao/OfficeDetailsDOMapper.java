package com.core.dao;

import com.core.pojo.weekly.OfficeDetailsDO;

import java.util.List;

public interface OfficeDetailsDOMapper {
    int deleteByPrimaryKey(String detailsId);

    int insert(OfficeDetailsDO record);

    int insertSelective(OfficeDetailsDO record);

    OfficeDetailsDO selectByPrimaryKey(String detailsId);

    int updateByPrimaryKeySelective(OfficeDetailsDO record);

    int updateByPrimaryKey(OfficeDetailsDO record);

    List<OfficeDetailsDO> selectDetailsByReportId(String reportId);

    void deleteByReportId(String reportId);
}