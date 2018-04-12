package com.core.dao;

import com.core.pojo.account.OfficeAccountDO;

public interface OfficeAccountDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(OfficeAccountDO record);

    int insertSelective(OfficeAccountDO record);

    OfficeAccountDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OfficeAccountDO record);

    int updateByPrimaryKey(OfficeAccountDO record);
}