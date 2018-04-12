package com.core.controller;

import com.common.base.OperatorType;
import com.common.controller.BaseController;
import com.common.utils.UploadExcelUtil;
import com.common.utils.WeekUtils;
import com.core.pojo.account.LoginAccountDTO;
import com.core.pojo.weekly.OfficeDetailsDO;
import com.core.pojo.weekly.OfficeReportDO;
import com.core.pojo.weekly.OfficeReportDTO;
import com.core.pojo.weekly.WeeklyDTO;
import com.core.service.OfficeReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author renyangze
 * @date 2018/3/27
 */
@Controller
@RequestMapping(value = "weekly")
public class WeeklyController extends BaseController {

    @Resource
    private OfficeReportService officeReportService;

    @RequestMapping(value = "listReport",method = RequestMethod.POST)
    @ResponseBody
    public Map listReport(HttpServletRequest request){
        Map map = new HashMap<>();
        LoginAccountDTO sessionObj = (LoginAccountDTO)request.getSession().getAttribute(SESSION_ID);
        List<OfficeReportDO> officeReportDOList = officeReportService.selectByUserId(sessionObj.getId());
        map.put("officeReportDOList",officeReportDOList);
        return success(map, OperatorType.SELECT,null);
    }
    @RequestMapping(value = "getWorkerListReport",method = RequestMethod.POST)
    @ResponseBody
    public Map getWorkerListReport(HttpServletRequest request){
        Map map = new HashMap<>();
        LoginAccountDTO sessionObj = (LoginAccountDTO)request.getSession().getAttribute(SESSION_ID);
        Map dataMap = WeekUtils.getWeekDays(0);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginDate = format1.parse((String) dataMap.get("beginDate"));
            Date endDate = format1.parse((String) dataMap.get("endDate"));
            List<OfficeReportDO> officeReportDOList = officeReportService.getWorkerListReport(beginDate, endDate);
            map.put("officeReportDOList",officeReportDOList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return success(map, OperatorType.SELECT,null);
    }
    @RequestMapping(value = "getWeeklyData",method = RequestMethod.POST)
    @ResponseBody
    public Map getWeeklyData(HttpServletRequest request){
        Map map = new HashMap<>();
        LoginAccountDTO sessionObj = (LoginAccountDTO)request.getSession().getAttribute(SESSION_ID);
        Map dataMap = WeekUtils.getWeekDays(0);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginDate = format1.parse((String) dataMap.get("beginDate"));
            Date endDate = format1.parse((String) dataMap.get("endDate"));
            OfficeReportDO officeReportDO = officeReportService.selectReport(beginDate,endDate,sessionObj.getId());
            if(officeReportDO != null){
                List<OfficeDetailsDO> officeDetailsDOList = officeReportService.selectDetails(officeReportDO.getReportId());
                map.put("officeDetailsDOList",officeDetailsDOList);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return success(map, OperatorType.SELECT,null);
    }

    @RequestMapping(value = "getReportById",method = RequestMethod.POST)
    @ResponseBody
    public Map getReportById(HttpServletRequest request,String reportId){
        Map map = new HashMap<>();
        List<OfficeDetailsDO> officeDetailsDOList = officeReportService.selectDetails(reportId);
        map.put("officeDetailsDOList",officeDetailsDOList);
        return success(map, OperatorType.SELECT,null);
    }
    @RequestMapping(value = "SetWeekly")
    @ResponseBody
    public String SetWeekly(@RequestBody WeeklyDTO weeklyDTO){
        System.out.println(weeklyDTO);
        officeReportService.insertWeekly(weeklyDTO);
        return "";
    }

    @RequestMapping(value = "exportWeekly")
    public String exportWeekly(HttpServletRequest request,HttpSession session,HttpServletResponse response){
        Map map = new HashMap<>();
        String   path   =  session.getServletContext().getRealPath("/");
        String separator = File.separator;
        LoginAccountDTO sessionObj = (LoginAccountDTO)request.getSession().getAttribute(SESSION_ID);
        Map dataMap = WeekUtils.getWeekDays(0);
        Map nextDataMap = WeekUtils.getWeekDays(1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String title = (String) dataMap.get("endDate") +"周报";
        String[] rowsName = new String[]{"姓名",
                dataMap.get("beginDate")+"至"+dataMap.get("endDate")+"本周报告",
                nextDataMap.get("beginDate")+"至"+nextDataMap.get("endDate")+"下周工作计划"};
        List<Object[]>  dataList = new ArrayList<Object[]>();

        try {
            Date beginDate = format1.parse((String) dataMap.get("beginDate"));
            Date endDate = format1.parse((String) dataMap.get("endDate"));
            List<OfficeReportDTO> officeReportDTOList = officeReportService.getWorkerListReportAndDetails(beginDate, endDate);
            for(OfficeReportDTO officeReportDTO :officeReportDTOList){
                String thisWeekly = "";
                String nextWeekly = "";
                Object[] obj = new Object[rowsName.length];


                for(OfficeDetailsDO officeDetailsDO :officeReportDTO.getOfficeDetailsDOList()){
                    if(officeDetailsDO.getDetailsComplete().equals("1")){
                        thisWeekly += officeDetailsDO.getDetailsContext()+"\n";
                    }else{
                        nextWeekly += officeDetailsDO.getDetailsContext()+"\n";
                    }
                }
                obj[0] = officeReportDTO.getReportAuthor();
                obj[1] = thisWeekly;
                obj[2] = nextWeekly;
                dataList.add(obj);
            }
            /*ExportExcelUtil excelUtil = new ExportExcelUtil("周报模板.xlsx");
            try {
                excelUtil.export(response);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            UploadExcelUtil ex = new UploadExcelUtil(title, rowsName, dataList);
            ex.export(response);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
