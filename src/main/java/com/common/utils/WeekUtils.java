package com.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author renyangze
 * @date 2018/3/29
 */
public class WeekUtils {

    //获取当前(上，下)周的日期范围如：...,-1上一周，0本周，1下一周...
    public static Map getWeekDays(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // getTimeInterval(sdf);
        Map map = new HashMap<>();
        Calendar calendar1 = Calendar.getInstance();
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);

        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayOfWeek) {
            calendar1.add(Calendar.DAY_OF_MONTH, -1);
        }

        // 获得当前日期是一个星期的第几天
        int day = calendar1.get(Calendar.DAY_OF_WEEK);

        //获取当前日期前（下）x周同星几的日期
        calendar1.add(Calendar.DATE, 7*i);

        calendar1.add(Calendar.DATE, calendar1.getFirstDayOfWeek() - day);



        String beginDate = sdf.format(calendar1.getTime());
        calendar1.add(Calendar.DATE, 6);

        String endDate = sdf.format(calendar1.getTime());

        System.out.println(beginDate+" 到 "+endDate);
        map.put("beginDate",beginDate);
        map.put("endDate",endDate);
        return map;
    }

    private static void getTimeInterval(SimpleDateFormat sdf) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); //
        // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String imptimeBegin = sdf.format(cal.getTime());
        System.out.println("所在周星期一的日期：" + imptimeBegin);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        System.out.println(cal.getFirstDayOfWeek());
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        imptimeBegin = sdf.format(cal.getTime());
        System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        System.out.println("所在周星期日的日期：" + imptimeEnd);
    }
}
