package com.core.dao;

import com.core.pojo.account.OfficeMenuPerMissionDO;

public interface OfficeMenuPerMissionDOMapper {
    int deleteByPrimaryKey(String perId);

    int insert(OfficeMenuPerMissionDO record);

    int insertSelective(OfficeMenuPerMissionDO record);

    OfficeMenuPerMissionDO selectByPrimaryKey(String perId);

    int updateByPrimaryKeySelective(OfficeMenuPerMissionDO record);

    int updateByPrimaryKey(OfficeMenuPerMissionDO record);
}