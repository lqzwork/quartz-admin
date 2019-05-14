package com.ffxl.common.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.google.common.base.Strings;

/**
 * 日期格式化
 * 
 */
public final class DateUtil {

    public static final String LONG_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String PURE_LONG_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmssSSS";

    public static final String STANDARD_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String STANDARD_DATE_TIME_FORMAT_STR_EXT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String PURE_STANDARD_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmss";
    
    public static final String STANDARD_DATE_TIME_ZONE_FORMAT_STR ="yyyy-MM-dd HH:mm:ss Z"; 

    public static final String MIDDLE_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm";
    public static final String PURE_MIDDLE_DATE_TIME_FORMAT_STR = "yyyyMMddHHmm";

    public static final String SHORT_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH";
    public static final String PURE_SHORT_DATE_TIME_FORMAT_STR = "yyyyMMddHH";

    public static final String STANDARD_DATE_FORMAT_STR = "yyyy-MM-dd";
    public static final String PURE_STANDARD_DATE_FORMAT_STR = "yyyyMMdd";

    public static final String MIDDLE_DATE_FORMAT_STR = "yyyy-MM";
    public static final String PURE_MIDDLE_DATE_FORMAT_STR = "yyyyMM";

    public static final String YEAR_FORMAT_STR = "yyyy";
    
    public static final String SHORT_STANDARD_DATE_FORMAT_STR = "MM-dd";
    public static final String PURE_SHORT_STANDARD_DATE_FORMAT_STR = "MMdd";

    public static final String EXCEL_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss.SSS";
    
    public static final String SHORT_STANDARD_HM_FORMAT_STR = "HH:mm";
    public static final String SHORT_STANDARD_H_FORMAT_STR = "HH";


    /**
     * 通用日期模式
     */
    private static final String[] GENERIC_DATE_PATTERNS = {
            LONG_DATE_TIME_FORMAT_STR, STANDARD_DATE_TIME_FORMAT_STR,
            MIDDLE_DATE_TIME_FORMAT_STR, STANDARD_DATE_FORMAT_STR,STANDARD_DATE_TIME_FORMAT_STR_EXT,MIDDLE_DATE_FORMAT_STR,PURE_STANDARD_DATE_FORMAT_STR,
            STANDARD_DATE_TIME_ZONE_FORMAT_STR, EXCEL_DATE_TIME_FORMAT_STR,SHORT_STANDARD_HM_FORMAT_STR,SHORT_STANDARD_H_FORMAT_STR};

    private DateUtil() {
    }

    /**
     * 日期字符串转化为日期
     * 
     * @param src
     *            日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String str) {
        try {
            return DateUtils.parseDate(str, GENERIC_DATE_PATTERNS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期时间格式(yyyyMMdd)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureStandardDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_STANDARD_DATE_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmmss)
     * 
     * @param date
     * @return yyyyMMddHHmmss
     * @throws ParseException
     */
    public static String formatPureStandardDate(Date date) {
        return DateFormatUtils.format(date, PURE_STANDARD_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyy-MM-dd HH:mm:ss)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatStandardDatetime(Date date) {
        return DateFormatUtils.format(date, STANDARD_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmmssSSS)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureLongDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_LONG_DATE_TIME_FORMAT_STR);
    }
    /**
     * 日期时间格式(yyyy-MM-dd HH:mm:ss SSS)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureLongDatetime2(Date date) {
        return DateFormatUtils.format(date, LONG_DATE_TIME_FORMAT_STR);
    }
    /**
     * 日期时间格式(yyyy-MM-dd HH:mm)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatMiddleDatetime(Date date) {
    	return DateFormatUtils.format(date, MIDDLE_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmm)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureMiddleDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_MIDDLE_DATE_TIME_FORMAT_STR);
    }

    /**
     * 格式日期为系统的标准格式(yyyy-MM-dd)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatStandardDate(Date date) {
        return DateFormatUtils.format(date, STANDARD_DATE_FORMAT_STR);
    }
    
    /**
     * 格式日期为系统的标准格式(MM-dd)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatShortStandardDate(Date date) {
        return DateFormatUtils.format(date, SHORT_STANDARD_DATE_FORMAT_STR);
    }
    
    /**
     * 格式日期为系统的标准格式(HH:mm)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatHMStandardDate(Date date) {
        return DateFormatUtils.format(date, SHORT_STANDARD_HM_FORMAT_STR);
    }
    
    /**
     * 格式日期为系统的标准格式(HH)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatHStandardDate(Date date) {
        return DateFormatUtils.format(date, SHORT_STANDARD_H_FORMAT_STR);
    }
    
    /**
     * 格式日期为系统的标准格式(yyyy-MM)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatYMStandardDate(Date date) {
        return DateFormatUtils.format(date, MIDDLE_DATE_FORMAT_STR);
    }

    /**
     * 根据出生日期计算年龄
     * @param birthday
     * @return
     */
    public static int getAgeByBirthday(String birthday) {
    	if (Strings.isNullOrEmpty(birthday)) {
    		return 0;
    	}
    	
        return getAgeByBirthday(parseDate(birthday));
    }
    
    /**
     * 根据出生日期计算年龄
     * @param birthday
     * @return
     */
    public static int getAgeByBirthday(Date brithday) {
    	if (brithday == null) {
    		return 0;
    	}
    	
        Calendar todayCalendar = Calendar.getInstance();
        Calendar brithdayCalendar = Calendar.getInstance();
        brithdayCalendar.setTime(brithday);
        
        return todayCalendar.get(Calendar.YEAR) - brithdayCalendar.get(Calendar.YEAR);
    }
  

    /**
     * 根据日期计算天数差
     * @param beforeDate 早日期
     * @param afterDate 晚日期
     * @return
     */
	public static int getDaysNum(Date beforeDate,
			Date afterDate) {
		Calendar calBefore = Calendar.getInstance();
		Calendar calAfter = Calendar.getInstance();
		calBefore.setTime(beforeDate);
		calAfter.setTime(afterDate);
		long day = ((calAfter.getTimeInMillis() - calBefore.getTimeInMillis()) / (60 * 60 * 24 * 1000));
		return (int) day;
	}
	
	 /**
     * 根据日期计算分钟差
     * @param beforeDate 早日期
     * @param afterDate 晚日期
     * @return
     */
    public static int getMinutesNum(Date beforeDate, Date afterDate) {
        Calendar calBefore = Calendar.getInstance();
        Calendar calAfter = Calendar.getInstance();
        calBefore.setTime(beforeDate);
        calAfter.setTime(afterDate);
        long minute = ((calAfter.getTimeInMillis() - calBefore.getTimeInMillis()) / (60 * 1000));
        return (int) minute;
    }
    
    /**
     * 根据日期计算秒差
     * @param beforeDate 早日期
     * @param afterDate 晚日期
     * @return
     */
    public static int getSecondNum(Date beforeDate, Date afterDate) {
        Calendar calBefore = Calendar.getInstance();
        Calendar calAfter = Calendar.getInstance();
        calBefore.setTime(beforeDate);
        calAfter.setTime(afterDate);
        long secnd = ((calAfter.getTimeInMillis() - calBefore.getTimeInMillis()) / (1000));
        return (int) secnd;
    }
	
	 /**
     * 根据天数，计算日期
     * @param date 日期
     * @param dayNum 天数差
     * @return
     */
	public static Date getDateByDayNum(Date date,int dayNum){
		long oneDayMillis = (60 * 60 * 24 * 1000);
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		return new Date(calDate.getTimeInMillis()+oneDayMillis*dayNum);
	}
	
	
	
	/**
     * 根据日期计算星期
     * @param date
     * @return
     */
	public static Integer getDayOfWeek(Date date){
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		return calDate.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
     * 根据日期计算星期,
     * @param date
     * @return 返回周一至周日
     */
    public static String getDayNameOfWeek(Date date){
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        int day = calDate.get(Calendar.DAY_OF_WEEK);
        String dayName ="";
        switch(day){
        case 1 : dayName="日";
        break;
        case 2 : dayName="一";
        break;
        case 3 : dayName="二";
        break;
        case 4 : dayName="三";
        break;
        case 5 : dayName="四";
        break;
        case 6 : dayName="五";
        break;
        case 7 : dayName="六";
        break;
        }
        return dayName;
    }
	
	/**
     * 根据日期计算月份
     * @param date
     * @return
     */
	public static Integer getMonth(Date date){
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		return calDate.get(Calendar.MONTH);
	}
	
	/**
     * 根据日期计算天数
     * @param date
     * @return
     */
	public static Integer getDayOfMonth(Date date){
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		return calDate.get(Calendar.DAY_OF_MONTH);
	}
	

	/**
     * 根据日期计算年
     * @param date
     * @return
     */
	public static Integer getYear(Date date){
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		return calDate.get(Calendar.YEAR);
	}
	

	/**
     * 根据日期计算年
     * @param date
     * @return
     */
	public static Integer getHour(Date date){
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		return calDate.get(Calendar.HOUR);
	}
	
	/**
     * 根据数字获取对应的星期数
     * 
     * @author 
     * @param dayOfWeek 数字
     * @param desc 描述（周、星期或者不填）
     * @param isEnglish 是否英文
     * @return String
     */
    public static String getDayOfWeekText(int dayOfWeek, String desc, boolean isEnglish) {
        String dayOfWeekText = null;
        switch (dayOfWeek){ 
            case 1 : 
            	if (!isEnglish) {
            		dayOfWeekText = desc + "日";
            	} else {
            		dayOfWeekText = "Sun.";
            	}
                break; 
            case 2 : 
            	if (!isEnglish) {
            		dayOfWeekText = desc + "一"; 
            	} else {
            		dayOfWeekText = "Mon.";
            	}
                break; 
            case 3 : 
            	if (!isEnglish) {
            		dayOfWeekText = desc + "二"; 
		        } else {
		    		dayOfWeekText = "Tues.";
		    	}
                break; 
            case 4 : 
            	if (!isEnglish) {
            		dayOfWeekText = desc + "三"; 
			    } else {
					dayOfWeekText = "Wed.";
				}
                break; 
            case 5 : 
            	if (!isEnglish) {
            		dayOfWeekText = desc + "四"; 
				} else {
					dayOfWeekText = "Thur.";
				}
                break; 
            case 6 : 
            	if (!isEnglish) {
            		dayOfWeekText = desc + "五"; 
	            } else {
	        		dayOfWeekText = "Fri.";
	        	}
                break;
            case 7 : 
            	if (!isEnglish) {
            		dayOfWeekText = desc + "六"; 
	            } else {
	        		dayOfWeekText = "Sat.";
	        	}
                break; 
        } 
        return dayOfWeekText;
    }
    
    /**
     * 日期时间格式(yyyy-MM-dd HH:mm:ss.SSS)
     * 
     * @param date
     * @return
     * @throws ParseException
     * @author xieyingbin add 2015/12/29
     */
    public static String formatExcelLongDatetime(Date date) {
        return DateFormatUtils.format(date, EXCEL_DATE_TIME_FORMAT_STR);
    }
    
    /**
    * 是否在指定日期区间，beginDay等于endDay时，返回是否是当天
    * @param date
    * @param beginDay
    * @param endDay
    * @return
    *  @author liqz and liyj
    */
    public static boolean isTheDay(final Date date, final Date beginDay, final Date endDay) {
            return date.getTime() >= DateUtil.dayBegin(beginDay).getTime()
                            && date.getTime() <= DateUtil.dayEnd(endDay).getTime();
    }
    
    /**
     * 是否在指定日期区间，beginDay等于endDay时，返回是否是当天
     * @param date
     * @param beginDay
     * @param endDay
     * @return
     *  @author liqz and liyj
     */
     public static boolean isTheDayTime(final Date date, final Date beginDay, final Date endDay) {
             return date.getTime() >= beginDay.getTime()
                             && date.getTime() <= endDay.getTime();
     }
     
    /**
    * 获取指定时间的那天 00:00:00.000 的时间
    * @param date
    * @return
    * @author liqz and liyj
    */
    public static Date dayBegin(final Date date) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return c.getTime();
    }
    /**
    * 获取指定时间的那天 23:59:59.999 的时间
    *
    * @param date
    * @return
    * @author liqz and liyj
    */
    public static Date dayEnd(final Date date) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            c.set(Calendar.MILLISECOND, 999);
            return c.getTime();
    }
    /**
     * 获取昨天日期
     *
     * @param date
     * @return
     * @author ys
     */
    public static Date yesterday(final Date date) {
    	Calendar   cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
//        String yesterday = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
        return cal.getTime();
    }
    /**
     * 获取本周一和周末的日期
     *
     * @return
     * @author ys
     */
    public static List<Date> week() {
    	Calendar calendar = Calendar.getInstance();
        List<Date> week = new ArrayList<Date>();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        for (int i = 0; i < 7; i++) {
        	if (i == 0 || i == 6) {
        		week.add(calendar.getTime());
        	}
        	calendar.add(Calendar.DATE, 1);
        }
        return week;
    }
    

    // 季度一年四季， 第一季度：1月-3月， 第二季度：4月-6月， 第三季度：7月-9月， 第四季度：10月-12月  
    /**
     * 
     * @param month 月份
     * @param isQuarterStart 是否为季度首月
     * @return 月份
     * @createDate：2016年3月29日
     * @author：jiawei
     */
    public static int getQuarterInMonth(int month, boolean isQuarterStart) {  
        int months[] = { 1, 4, 7, 10 }; 
        if (!isQuarterStart) {  
            months = new int[] { 3, 6, 9, 12 };  
        }  
        if (month >= 1 && month <= 3)  
            return months[0];  
        else if (month >= 3 && month <= 5)  
            return months[1];  
        else if (month >= 6 && month <= 8)  
            return months[2];  
        else  
            return months[3];  
    }  
    
    /**
     * 当前日期+1天
     */
    public static Date getAfterDay(Date dt){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DAY_OF_MONTH, +1);// 今天+1天
        Date tomorrow = c.getTime();
        
        return tomorrow;
    }
    /**
     * 当前日期+n天
     */
    public static Date getAfterNumDay(Date dt,int n){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DAY_OF_MONTH, +n);// 今天+1天
        Date tomorrow = c.getTime();
        
        return tomorrow;
    }
    /**
     * 获取一天内的所有间隔30分钟的整点，半点时刻
     * @return
     */
    public static List<String> getTimes(int time){
        Date statDateTime = DateUtil.dayBegin(new Date());
        Date endDateTime = DateUtil.getAfterDay(statDateTime);
        return DateUtil.getTimes(statDateTime, endDateTime,time);
    }
    
    /**
     * 获取指定时间内的所有间隔30分钟的整点，半点时刻
     */
    public static List<String> getTimes(Date statDateTime, Date endDateTime,int time){
        List<String> timeList = new ArrayList<String>();
        Calendar c = Calendar.getInstance();
        c.setTime(statDateTime);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date beginDate = c.getTime();
        
        Calendar tomc = Calendar.getInstance();
        tomc.setTime(beginDate);
        tomc.add(Calendar.DAY_OF_MONTH, +1);// 今天+1天
        Date tomorrow = tomc.getTime();
        Boolean b= beginDate.getTime() < tomorrow.getTime();
        while(b){
//            System.out.println(DateUtil.formatMiddleDatetime(beginDate));
//            System.out.println("--"+DateUtil.formatMiddleDatetime(statDateTime));
//            System.out.println("++"+DateUtil.formatMiddleDatetime(endDateTime));
            boolean isDay = DateUtil.isTheDayTime(beginDate, statDateTime, endDateTime);
            if(isDay){
                timeList.add(DateUtil.formatHMStandardDate(beginDate));
            }
            Calendar nextc = Calendar.getInstance();
            nextc.setTime(beginDate);
            nextc.add(Calendar.MINUTE, time);
            beginDate = nextc.getTime();
            b = beginDate.getTime() < tomorrow.getTime();
        }
        return timeList;
    }
    
    /**
     * 获取指定时间内的所有间隔60分钟的整点
     */
    public static List<String> getRoomTimes(Date statDateTime, Date endDateTime){
        List<String> timeList = new ArrayList<String>();
        Calendar c = Calendar.getInstance();
        c.setTime(statDateTime);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date beginDate = c.getTime();
        
        Calendar tomc = Calendar.getInstance();
        tomc.setTime(beginDate);
        tomc.add(Calendar.DAY_OF_MONTH, +1);// 今天+1天
        Date tomorrow = tomc.getTime();
        Boolean b= beginDate.getTime() < tomorrow.getTime();
        while(b){
//            System.out.println(DateUtil.formatMiddleDatetime(beginDate));
//            System.out.println("--"+DateUtil.formatMiddleDatetime(statDateTime));
//            System.out.println("++"+DateUtil.formatMiddleDatetime(endDateTime));
            boolean isDay = DateUtil.isTheDayTime(beginDate, statDateTime, endDateTime);
            if(isDay){
                timeList.add(DateUtil.formatHMStandardDate(beginDate));
            }
            Calendar nextc = Calendar.getInstance();
            nextc.setTime(beginDate);
            nextc.add(Calendar.MINUTE, 60);
            beginDate = nextc.getTime();
            b = beginDate.getTime() < tomorrow.getTime();
        }
        return timeList;
    }
    
    /**
     * 验证时间有效性是否在误差正负一分钟之内
     * @param date
     * @param beginDay
     * @param endDay
     * @return
     * @author liqz and liyj
     */
    public static boolean validateTime(final long validate, final Date currentDate) {
        long currentTime = currentDate.getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        Date cd = c.getTime();
        c.add(Calendar.SECOND, -60);
        Date before = c.getTime();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(currentDate);
        c2.add(Calendar.SECOND, 60);
        Date after = c2.getTime();
        if( validate >= before.getTime()&& validate <= after.getTime()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * 验证时间有效性是否在误差分钟内
     * @param validate 当前时间
     * @param canDate 参考时间
     * @param beforeM
     * @param afterM
     * @return
     * @author liqz and liyj
     */
    public static int validateTime(final long validate, final Date canDate,int beforeM, int afterM) {
        Calendar c = Calendar.getInstance();
        c.setTime(canDate);
        Date cd = c.getTime();
        c.add(Calendar.MINUTE, beforeM);
        Date before = c.getTime();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(canDate);
        c2.add(Calendar.MINUTE, afterM);
        Date after = c2.getTime();
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");   
        String sd = sdf.format(new Date(validate));  
        System.out.println("需要验证时间"+sd);
        String bsd = sdf.format(new Date(before.getTime()));  
        System.out.println("范围开始"+bsd);
        String esd = sdf.format(new Date(after.getTime()));  
        System.out.println("范围结束"+esd);
        if( validate >= before.getTime()&& validate <= after.getTime()){
            System.out.println("进行"+0);
            return 0;
        } else if( validate > after.getTime()){
            System.out.println("超时"+1);
            /**
             * 2017-03-21 去掉音视频超时，超时的时候，只要咨询师未确认完成订单，订单状态为待咨询，咨询中是均可发起
             */
            return 0;
        } else{
            System.out.println("等待"+-1);
            return -1;
        }
    }
    
    /**
     * 获取指定时间范围内的所有指定间隔的时长
     * @param statDateTime 开始时间
     * @param duration
     * @param interval
     * @return
     * @author liqz and liyj
     */
    public static List<Integer> getCountTimes( int duration, int interval){
        List<Integer> timeList = new LinkedList<Integer>();
        int i=1;
        int realDur = interval * i;
        while(realDur <= duration){
            timeList.add(realDur);
            i++;
            realDur = interval * i;
        }
        return timeList;
    }

    public static Date getNextTime() {
        Date currentDate = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(currentDate);
        int h = c1.get(Calendar.HOUR_OF_DAY); //小时
       
        c1.set(Calendar.HOUR_OF_DAY, h);
        c1.set(Calendar.MINUTE, 15);
        c1.set(Calendar.SECOND, 0);
        Date d1 = c1.getTime();
        
        Calendar c2 = Calendar.getInstance();
        c2.setTime(currentDate);
        c2.set(Calendar.HOUR_OF_DAY, h);
        c2.set(Calendar.MINUTE, 30);
        c2.set(Calendar.SECOND, 0);
        Date d2 = c2.getTime();
        
        Calendar c3 = Calendar.getInstance();
        c3.setTime(currentDate);
        c3.set(Calendar.HOUR_OF_DAY, h);
        c3.set(Calendar.MINUTE, 45);
        c3.set(Calendar.SECOND, 0);
        Date d3 = c3.getTime();
        
        Calendar c4 = Calendar.getInstance();
        c4.setTime(currentDate);
        c4.set(Calendar.HOUR_OF_DAY, h+1);
        c4.set(Calendar.MINUTE, 0);
        c4.set(Calendar.SECOND, 0);
        Date d4 = c4.getTime();
        
        if(currentDate.getTime() <= d1.getTime()){
            return d1;
        }
        if(currentDate.getTime() <= d2.getTime()){
            return d2;
        }
        if(currentDate.getTime() <= d3.getTime()){
            return d3;
        }else{
            return d4;
        }
    }
    
    /**
     * 指定时间前推/后推N小时的时间
     */
    public static Date getResultDate(Date dt, int type,int hours ){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        if(type >0){
            c.add(Calendar.HOUR_OF_DAY, +hours);// 时间+N小时
        }else{
            c.add(Calendar.DAY_OF_MONTH, -hours);// 时间-N小时
        }
        Date resultDate = c.getTime();
        return resultDate;
    }
    
    /**
     * 指定时间前推/后推N分钟的时间
     */
    public static Date getResultMintDate(Date dt, int type,int minutes ){
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        if(type >0){
            c.add(Calendar.MINUTE, +minutes);// 时间+N分钟
        }else{
            c.add(Calendar.MINUTE, -minutes);// 时间-N分钟
        }
        Date resultDate = c.getTime();
        return resultDate;
    }
    /**
     * 时间转换
     * @param dateTimeStamp
     * @return
     */
    public static String getDateDiff(long dateTimeStamp){
        String d = 0 + "天" + 0 + "小时" + 0 + "分" + 0 + "秒";
        try {
            long days = dateTimeStamp / (1000 * 60 * 60 * 24);
            long hours = (dateTimeStamp - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (dateTimeStamp - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            long second = (dateTimeStamp - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / (1000);
            d = days + "天" + hours + "时" + minutes + "分" + second + "秒";
            return d;
        } catch (Exception ignored) {
        }
        return d;
    }
}
