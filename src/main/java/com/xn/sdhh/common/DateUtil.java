package com.xn.sdhh.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtil {

    /**
     * @Fields DATE_FORMAT_STRING : (数据库返回时间格式)
     */
    public static final String DB_DATE_FORMAT_STRING = "yyyyMMdd";

    /**
     * @Fields DISPLAY_DATE_FORMAT_STRING : (前台显示时间格式)
     */
    public static final String FRONT_DATE_FORMAT_STRING = "yyyy-MM-dd";

    /**
     * @Fields DATA_TIME_PATTERN : 日期格式
     */
    public static final String DATA_TIME_PATTERN_1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATA_TIME_PATTERN_2 = "yyyy-MM-dd HH:mm";

    public static final String DATA_TIME_PATTERN_3 = "yyyyMMDDhhmmss";

    public static final String DATA_TIME_PATTERN_4 = "yyyyMMddHHmmssSSS";

    public static final String DATA_TIME_PATTERN_5 = "yyyyMMddHHmmss";

    public static final String TIME_BEGIN = " 00:00:00";

    public static final String TIME_END = " 23:59:59";

    /**
     * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
     * @param beginDate
     * @param endDate
     * @return 
     * @create: 2015年11月16日 上午11:20:51 myb858
     * @history:
     */
    public static int daysBetween(Date beginDate, Date endDate) {
        long times = endDate.getTime() - beginDate.getTime();
        return (int) (times / 60 / 60 / 1000 / 24);
    }

    public static Date getRelativeDate(Date startDate, int second) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(startDate);
            calendar.add(Calendar.SECOND, second);

            return calendar.getTime();
        } catch (Exception e) {
            return startDate;
        }
    }

    /** 
     * Date按格式pattern转String
     * @param date
     * @param pattern
     * @return 
     * @create: 2015-4-18 下午11:02:34 miyb
     * @history: 
     */
    public static String dateToStr(Date date, String pattern) {
        String str = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            str = formater.format(date);
        } catch (Exception e) {
        }
        return str;
    }

    /** 
     * 获取当天开始时间
     * @return 
     * @create: 2014-10-14 下午4:24:57 miyb
     * @history: 
     */
    public static Date getTodayStart() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return (Date) currentDate.getTime().clone();
    }

    /** 
     * 获取当天结束时间
     * @return 
     * @create: 2014-10-14 下午4:24:57 miyb
     * @history: 
     */
    public static Date getTodayEnd() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return (Date) currentDate.getTime().clone();
    }

    /** 
     * String 按格式pattern转Date
     * @param str
     * @param pattern
     * @return 
     * @create: 2015-4-18 下午11:02:34 miyb
     * @history: 
     */
    public static Date strToDate(String str, String pattern) {
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            date = formater.parse(str);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 删除—
     * @param pattern
     * @return 
     * @create: 2015年10月27日 下午7:59:41 myb858
     * @history:
     */
    public static String remove_(String strDate) {
        String string = null;
        try {
            string = strDate.replace("-", "");
        } catch (Exception e) {
        }
        return string;
    }

    /**
     * 按格式获取当前时间
     * @param pattern
     * @return 
     * @create: 2015-5-7 上午11:22:04 miyb
     * @history:
     */
    public static String getToday(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    /**
     * 
     * @param date
     * @param addOneDay 是否加1天
     * @return 
     * @create: 2015-5-7 上午11:25:23 miyb
     * @history:
     */
    public static Date getFrontDate(String date, boolean addOneDay) {
        Date returnDate = null;
        try {
            returnDate = new SimpleDateFormat(FRONT_DATE_FORMAT_STRING)
                .parse(date);
            if (addOneDay) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(returnDate);
                calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
                calendar.add(calendar.SECOND, -1);// 变成23：59：59
                returnDate = calendar.getTime(); // 这个时间就是日期往后推一天的结果
            }
        } catch (Exception e) {

        }
        return returnDate;
    }

    /**
     * 根据两个日期，指定几号，获取日期数组
     * @param dateStartStr 
     * @param dateEndStr
     * @param number
     * @return 
     * @create: 2016年1月7日 上午9:53:59 xieyj
     * @history:
     */
    public static List<Date> getDatesArray(String dateStartStr,
            String dateEndStr, int number) {
        // 时间格式转化
        Date dateStart = strToDate(dateStartStr, FRONT_DATE_FORMAT_STRING);
        Date dateEnd = strToDate(dateEndStr, FRONT_DATE_FORMAT_STRING);
        Calendar calDateStart = Calendar.getInstance();
        calDateStart.setTime(dateStart);
        Calendar calDateEnd = Calendar.getInstance();
        calDateEnd.setTime(dateEnd);
        // 时间List数组
        List<Date> arrayDate = new ArrayList<Date>();
        int k = 0;
        // 末尾时间比较
        while (calDateEnd.after(calDateStart)) {
            if (k == 0) {
                k++;
                // 添加起初时间
                arrayDate.add(dateStart);
                // 判断首次是否加一个月
                int calDateStartMonth = calDateStart.get(Calendar.DAY_OF_MONTH);
                if (calDateStartMonth > number) {
                    calDateStart.add(Calendar.MONTH, 1);
                } else if (calDateStartMonth == number) {
                    continue;
                }
            } else {
                calDateStart.add(Calendar.MONTH, 1);
            }
            calDateStart.set(Calendar.DAY_OF_MONTH, number);
            // 判断是否循环到最后,比较
            if (calDateStart.after(calDateEnd)) {
                arrayDate.add(calDateEnd.getTime());
            } else {
                arrayDate.add(calDateStart.getTime());
            }
        }
        return arrayDate;
    }

    public static Date getCurrentMonthFirstDay() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.DATE, 1);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return (Date) currentDate.getTime().clone();
    }

    public static Date getCurrentMonthLastDay() {
        Date date = new Date();
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(date);
        do {
            currentDate.add(Calendar.DATE, 1);
        } while (currentDate.get(Calendar.DATE) != 1);
        currentDate.add(Calendar.DATE, -1);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return currentDate.getTime();
    }

    /**
     * 获取当本周第一天
     * @param month
     * @return 
     * @create: 2018年5月11日 下午1:58:15 nyc
     * @history:
     */
    public static Date getWeeklyStart() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        int today = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.set(Calendar.DAY_OF_MONTH, (today - weekDay));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当本周最后一天
     * 
     * 周日  = 1
     * 周一  = 2
     * 周二  = 3
     * ......
     * @param month
     * @return 
     * @create: 2018年5月11日 下午1:58:15 nyc
     * @history:
     */
    public static Date getWeeklyEnd() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDay = 7 - (calendar.get(Calendar.DAY_OF_WEEK) - 1);
        int today = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.set(Calendar.DAY_OF_MONTH, (today + weekDay));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当指定月份第一天
     * @param month
     * @return 
     * @create: 2018年5月11日 下午1:58:15 nyc
     * @history:
     */
    public static Date getMonthStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前月份最后一天
     * @param month
     * @return 
     * @create: 2018年5月11日 下午1:58:15 nyc
     * @history:
     */
    public static Date getMonthEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
            calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取当天日
     * @param args 
     * @create: 2018年7月27日 下午7:35:12 nyc
     * @history:
     */

    public static String getToDay() {
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.YEAR) + "-"
                + (calendar.get(Calendar.MONTH) + 1) + "-"
                + calendar.get(Calendar.DAY_OF_MONTH);
        return date;
    }

    /**
     * 获取当前时间的前N小时
     * @param args 
     * @create: 2018年9月28日 下午3:13:13 nyc
     * @history:
     */
    public static Date getBeforeTime(int hours) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - hours);
        return cal.getTime();
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(daysBetween(
            strToDate("2018-10-07", FRONT_DATE_FORMAT_STRING),
            strToDate("2018-10-01", FRONT_DATE_FORMAT_STRING))));
    }
}
