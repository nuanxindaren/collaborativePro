package com.core.dao;

import com.core.pojo.account.OfficeRolePerMissionDO;
import com.core.pojo.account.OfficeRolePerMissionDOKey;

public interface OfficeRolePerMissionDOMapper {
    int deleteByPrimaryKey(OfficeRolePerMissionDOKey key);

    int insert(OfficeRolePerMissionDO record);

    int insertSelective(OfficeRolePerMissionDO record);

    OfficeRolePerMissionDO selectByPrimaryKey(OfficeRolePerMissionDOKey key);

    int updateByPrimaryKeySelective(OfficeRolePerMissionDO record);

    int updateByPrimaryKey(OfficeRolePerMissionDO record);
}