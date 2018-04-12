package com.core.controller;

import com.common.base.OperatorType;
import com.common.controller.BaseController;
import com.common.utils.LoggerUtils;
import com.common.utils.StringUtils;
import com.core.pojo.account.LoginAccountDTO;
import com.core.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author renyangze
 * @date 2018/3/19
 */
@Controller
@RequestMapping(value = "login")
public class LoginController extends BaseController implements HandlerInterceptor {

    @Resource
    private LoginService loginService;
    /**
     *
     *
     * */
    @RequestMapping(value="submitLogin",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitLogin(@RequestBody LoginAccountDTO loginAccountDTO,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        map = loginService.employeesLogin(loginAccountDTO);
        //获取登录之前的地址
        String url = (String) request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE);
        LoggerUtils.fmtDebug(getClass(), "获取登录之前的URL:[%s]", url);
        //如果登录之前没有地址，那么就跳转到首页。
        if(StringUtils.isBlank(url)){
            url = "/user/index.shtml";
        }
        System.out.println(map);
        return map;
    }

    @RequestMapping(value="goOut",method= RequestMethod.POST)
    @ResponseBody
    public Map goOut(HttpServletRequest request,HttpSession session, HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        session.removeAttribute("loginAccountSession");
        return success(map,OperatorType.SELECT,null);
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginAccountDTO sessionObj = (LoginAccountDTO)request.getSession().getAttribute("loginAccountSession");
        String type = request.getHeader("X-Requested-With");// XMLHttpRequest
        String  xml = "XMLHttpRequest";

        if (sessionObj == null) {
            String url = (String) request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE);
            if (xml.equals(type)){
                // ajax请求
                response.setHeader("SESSIONSTATUS", "TIMEOUT");
                response.setHeader("CONTEXTPATH", url);
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;
            }
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
