package com.core.service;

import com.core.pojo.account.Menu_Role_PermissionsDTO;

import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/30
 */
public interface MenuService {
    List<Menu_Role_PermissionsDTO> listMenuBySessionsID(String id);
}
