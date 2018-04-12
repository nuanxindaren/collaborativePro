package com.core.service.impl;

import com.common.base.OperatorType;
import com.common.controller.BaseController;
import com.common.controller.MessageInfo;
import com.common.utils.IpUtils;
import com.core.dao.LoginDAO;
import com.core.pojo.account.LoginAccountDTO;
import com.core.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author renyangze
 * @date 2018/3/21
 */
@Service
public class LoginServiceImpl extends BaseController implements LoginService {

    @Resource
    private LoginDAO loginDAO;

    @Override
    public Map<String, Object> employeesLogin(LoginAccountDTO loginAccountDTO) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        Map<String,Object> map = new HashMap<String,Object>();

        String userIp = IpUtils.getIpAddr(request);
        if  (loginAccountDTO.getAccount() == null || loginAccountDTO.getAccount().length() <= 0 ||loginAccountDTO.getPassword() == null || loginAccountDTO.getPassword().length() <= 0) {
            logger.warn("用户地址为"+userIp+"访问结果:用户名或者公司代码为空");
            map = failed(map, OperatorType.SELECT, MessageInfo.MSG_FOR_WRONG_USERNAME_PASSWORD);
        }else {
            LoginAccountDTO loginAccount = loginDAO.getLoginMessage(loginAccountDTO.getAccount());
            if(loginAccount!=null){
            if(loginAccountDTO.getPassword().equals(loginAccount.getPassword())){
                loginAccount.setRememberMe(loginAccountDTO.isRememberMe());
                /*map.put("accountMessage",loginAccount);*/
                request.getSession().setAttribute("loginAccountSession",loginAccount);
                String sessionId = UUID.randomUUID().toString();
                map.put("sessionId",sessionId);
                map = success(map,OperatorType.SELECT,MessageInfo.MSG_FOR_SELECT_SUCCESS);
            }else{
                map = failed(map, OperatorType.SELECT, MessageInfo.MSG_FOR_WRONG_USERNAME_PASSWORD);
            }
            }else{
                map = failed(map, OperatorType.SELECT, MessageInfo.MSG_FOR_WRONG_USERNAME_PASSWORD);
            }
        }
        return map;
    }

}
