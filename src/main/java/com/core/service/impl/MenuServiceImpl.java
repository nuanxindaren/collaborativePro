package com.core.service.impl;

import com.core.dao.MenuMapper;
import com.core.pojo.account.Menu_Role_PermissionsDTO;
import com.core.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/30
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu_Role_PermissionsDTO> listMenuBySessionsID(String id) {
        List<Menu_Role_PermissionsDTO> list = menuMapper.listMenuBySessionsID(id);
        return list;
    }
}
