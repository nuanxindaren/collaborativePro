package com.core.controller;

import com.common.base.OperatorType;
import com.common.controller.BaseController;
import com.core.pojo.account.LoginAccountDTO;
import com.core.pojo.account.Menu_Role_PermissionsDTO;
import com.core.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author renyangze
 * @date 2018/3/30
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController extends BaseController {

    @Resource
    private MenuService menuService;
    /**
     * 根据用户角色获取相应后台权限
     * Menu_PermissionsDO Version:1.0
     * @author      任杨泽
     * @version     1.0
     * */
    @RequestMapping(value = "listMenuById",method = RequestMethod.POST)
    @ResponseBody
    public Map ListMenuBySessionID (HttpServletRequest request,HttpSession session) {
        LoginAccountDTO sessionObj = (LoginAccountDTO)request.getSession().getAttribute("loginAccountSession");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Menu_Role_PermissionsDTO> list = menuService.listMenuBySessionsID(sessionObj.getId());
            System.out.println(list);
            map.put("menuList",list);
        }catch (Exception e) {

        }

        return success(map, OperatorType.SELECT,"查询成功");
    }
}
