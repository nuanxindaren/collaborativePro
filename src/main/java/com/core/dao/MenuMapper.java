package com.core.dao;

import com.core.pojo.account.Menu_Role_PermissionsDTO;

import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/30
 */
public interface MenuMapper {
    List<Menu_Role_PermissionsDTO> listMenuBySessionsID(String id);
}
