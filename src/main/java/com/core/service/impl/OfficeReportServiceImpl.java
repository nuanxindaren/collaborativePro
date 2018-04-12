package com.core.service.impl;

import com.common.controller.BaseController;
import com.common.utils.WeekUtils;
import com.core.dao.OfficeDetailsDOMapper;
import com.core.dao.OfficeReportDOMapper;
import com.core.pojo.account.LoginAccountDTO;
import com.core.pojo.weekly.OfficeDetailsDO;
import com.core.pojo.weekly.OfficeReportDO;
import com.core.pojo.weekly.OfficeReportDTO;
import com.core.pojo.weekly.WeeklyDTO;
import com.core.service.OfficeReportService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author renyangze
 * @date 2018/3/26
 */
@Service
public class OfficeReportServiceImpl extends BaseController implements OfficeReportService{

    @Resource
    private OfficeReportDOMapper officeReportDOMapper;
    @Resource
    private OfficeDetailsDOMapper officeDetailsDOMapper;


    @Override
    public List<OfficeReportDO> selectByUserId(String id) {
        return officeReportDOMapper.selectByUserId(id);
    }

    @Override
    public void insertWeekly(WeeklyDTO weeklyDTO) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        LoginAccountDTO sessionObj = (LoginAccountDTO)request.getSession().getAttribute("loginAccountSession");
        Map map = WeekUtils.getWeekDays(0);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        OfficeReportDO officeReportDO = new OfficeReportDO();
        Date date = new Date();
        officeReportDO.setReportId(UUID.randomUUID().toString());
        officeReportDO.setReportTitle(map.get("endDate") + "周报");
        officeReportDO.setReportUserId(sessionObj.getId());
        officeReportDO.setInsUserId(sessionObj.getId());
        officeReportDO.setInsDate(date);
        officeReportDO.setReportAuthor(sessionObj.getUser_name());
        try {
            officeReportDO.setReportSdtTime(format1.parse((String) map.get("beginDate")));
            officeReportDO.setReportEndTime(format1.parse((String) map.get("endDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        weeklyDTO.setOfficeReportDO(officeReportDO);
        OfficeReportDO officeReportDO1 = officeReportDOMapper.selectByUserIdAndDate(officeReportDO.getReportUserId(),officeReportDO.getReportSdtTime(),officeReportDO.getReportEndTime());
        if(officeReportDO1!=null){
            officeReportDOMapper.deleteByPrimaryKey(officeReportDO1.getReportId());
            officeDetailsDOMapper.deleteByReportId(officeReportDO1.getReportId());
        }
                officeReportDOMapper.insertSelective(officeReportDO);
        OfficeReportDO officeReportDO2 = officeReportDOMapper.selectByUserIdAndDate(officeReportDO.getReportUserId(),officeReportDO.getReportSdtTime(),officeReportDO.getReportEndTime());

        Integer number1 = 1;
        for (OfficeDetailsDO officeDetailsDO :weeklyDTO.getThisWeek()){
            officeDetailsDO.setDetailsId(UUID.randomUUID().toString());
            officeDetailsDO.setReportId(officeReportDO2.getReportId());
            officeDetailsDO.setDetailsUserId(sessionObj.getId());
            officeDetailsDO.setInsDate(date);
            officeDetailsDO.setInsUserId(sessionObj.getId());
            officeDetailsDO.setDetailsNumber(String.valueOf(number1));
            officeDetailsDO.setDetailsComplete("1");
            officeDetailsDOMapper.insertSelective(officeDetailsDO);
            number1++;
        }

        Integer number2 = 1;
        for (OfficeDetailsDO officeDetailsDO :weeklyDTO.getNextWeek()){
            officeDetailsDO.setDetailsId(UUID.randomUUID().toString());
            officeDetailsDO.setReportId(officeReportDO2.getReportId());
            officeDetailsDO.setDetailsUserId(sessionObj.getId());
            officeDetailsDO.setInsDate(date);
            officeDetailsDO.setInsUserId(sessionObj.getId());
            officeDetailsDO.setDetailsNumber(String.valueOf(number2));
            officeDetailsDO.setDetailsComplete("2");
            officeDetailsDOMapper.insertSelective(officeDetailsDO);
            number2++;
        }
    }

    @Override
    public OfficeReportDO selectReport(Date beginDate, Date endDate, String id) {
        return officeReportDOMapper.selectReport(beginDate,endDate,id);
    }

    @Override
    public List<OfficeDetailsDO> selectDetails(String reportId) {
        return officeDetailsDOMapper.selectDetailsByReportId(reportId);
    }

    @Override
    public List<OfficeReportDO> getWorkerListReport(Date beginDate, Date endDate) {
        return officeReportDOMapper.getWorkerListReport(beginDate,endDate);
    }

    @Override
    public List<OfficeReportDTO> getWorkerListReportAndDetails(Date beginDate, Date endDate) {
        return officeReportDOMapper.getWorkerListReportAndDetails(beginDate,endDate);
    }
}
