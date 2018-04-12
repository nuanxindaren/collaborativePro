package com.common.controller;

import com.common.base.OperatorType;
import com.common.utils.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author renyangze
 * @date 2018/3/21
 */
public class BaseController {
    protected int pageNo =1;
    public static  int pageSize = 10;
    protected final static Logger logger = Logger.getLogger(BaseController.class);
    protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    public static String URL404 =  "/404.html";

    private final static String PARAM_PAGE_NO = "pageNo";
    public final static String SESSION_ID = "loginAccountSession";

    protected String pageSizeName = "pageSize";

    /**
     * 往Request里带值
     * @param request
     * @param key
     * @param value
     */
    protected static void setValue2Request(HttpServletRequest request,String key,Object value){
        request.setAttribute(key, value);
    }

    /**
     * [获取session]
     * @param request
     * @return
     */
    public static HttpSession getSession(HttpServletRequest request){
        return request.getSession();
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        BaseController.pageSize = pageSize;
    }

    public ModelAndView redirect(String redirectUrl,Map<String,Object>...parament){
        ModelAndView view = new ModelAndView(new RedirectView(redirectUrl));
        if(null != parament && parament.length > 0){
            view.addAllObjects(parament[0]);
        }
        return view;
    }
    public ModelAndView redirect404(){
        return new ModelAndView(new RedirectView(URL404));
    }

    @SuppressWarnings("unchecked")
    protected Map<String, Object> prepareParams(Object obj, HttpServletRequest request) throws Exception {
        if (request != null) {
            String pageNoStr   = (String)request.getParameter(PARAM_PAGE_NO),
                    pageSizeStr = (String)request.getParameter(pageSizeName);
            if (StringUtils.isNotBlank(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            if (StringUtils.isNotBlank(pageSizeStr)) {
                pageSize = Integer.parseInt(pageSizeStr);
            }
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params = BeanUtils.describe(obj);
        params = handleParams(params);
        // 回填值项
        //BeanUtils.populate(obj, params);
        return params;
    }
    private Map<String, Object> handleParams(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (null != params) {
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();

            for (Iterator<Map.Entry<String, Object>> it = entrySet.iterator(); it.hasNext(); ) {
                Map.Entry<String, Object> entry = it.next();
                if (entry.getValue() != null) {
                    result.put(entry.getKey(), StringUtils.trimToEmpty((String) entry.getValue()));
                }
            }
        }
        return result;
    }

    /**
     * 前端提交的请示处理成功，返回用map封装的状态信息和操作成功信息
     *
     * @param map  用于封装返回的信息
     * @param type 操作类型：包含添加、修改、删除、查询、文件上传
     * @param msg  操作结果信息
     * @return Map结果信息
     */
    public Map success(Map<String, Object> map, OperatorType type, String msg) {
        map.put(MessageInfo.CODE, MessageInfo.CODE_FOR_SUCCESS);
        return successMsg(map, type, msg);
    }
    /**
     * 前端提交的请示处理失败，返回用map封装的状态信息和操作失败信息
     *
     * @param map  用于封装返回的信息
     * @param type 操作类型：包含添加、修改、删除、查询、文件上传
     * @param msg  操作结果信息
     * @return Map结果信息
     */
    public Map failed(Map<String, Object> map, OperatorType type, String msg) {
        map.put(MessageInfo.CODE, MessageInfo.CODE_FOR_FAILED);
        return failedMsg(map, type, msg);
    }

    /**
     * 前端提交的请示处理成功，返回用map封装操作成功信息
     *
     * @param map  用于封装返回的信息
     * @param type 操作类型：包含添加、修改、删除、查询、文件上传
     * @param msg  操作结果信息
     * @return Map结果信息
     */
    public Map successMsg(Map<String, Object> map, OperatorType type, String msg) {
        if (Objects.nonNull(msg))
            map.put(MessageInfo.MSG, msg);
        else {
            if (type.equals(OperatorType.ADD))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_ADD_SUCCESS);
            else if (type.equals(OperatorType.DELETE))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_DELETE_SUCCESS);
            else if (type.equals(OperatorType.UPDATE))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_MODIFY_SUCCESS);
            else if (type.equals(OperatorType.SELECT))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_SELECT_SUCCESS);
            else if (type.equals(OperatorType.UPLOAD))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_UPLOAD_SUCCESS);
        }
        return map;
    }

    /**
     * 前端提交的请示处理失败，返回用map封装操作失败信息
     *
     * @param map  用于封装返回的信息
     * @param type 操作类型：包含添加、修改、删除、查询、文件上传、异常
     * @param msg  操作结果信息
     * @return Map结果信息
     */
    public Map failedMsg(Map<String, Object> map, OperatorType type, String msg) {
        if (Objects.nonNull(msg)) {
            map.put(MessageInfo.MSG, msg);
        } else {
            if (type.equals(OperatorType.ADD))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_ADD_FAILED);
            else if (type.equals(OperatorType.DELETE))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_DELETE_FAILED);
            else if (type.equals(OperatorType.UPDATE))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_MODIFY_FAILED);
            else if (type.equals(OperatorType.SELECT))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_SELECT_FAILED);
            else if (type.equals(OperatorType.UPLOAD))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_UPLOAD_FAILED);
            else if (type.equals(OperatorType.ERROR))
                map.put(MessageInfo.MSG, MessageInfo.MSG_FOR_ERROR);
        }
        return map;
    }

    /**
     * 本方法用于处理控制层及控制层调用所产生的异常，异常将被写入日志，同时返回失败信息给前端
     *
     * @param e 由控制层及控制层调用所产生的异常信息
     * @return Map结果信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        logger.error(MessageInfo.MSG_FOR_ERROR, e);
        Map<String, Object> map = new HashMap();
        failed(map, OperatorType.ERROR, null);
        return map;
    }
}
