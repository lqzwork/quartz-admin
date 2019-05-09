package com.ffxl.quartz.task.wxs;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ffxl.cloud.annotation.ControllerLogAnnotation;
import com.ffxl.cloud.service.STimetaskLogService;
import com.ffxl.cloud.util.ApplicationContextUtils;
import com.ffxl.platform.util.DateUtil;

/**
 * 一：定时cron的格式，一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。
    按顺序依次为：
    1.秒（0~59）
    2.分钟（0~59）
    3.小时（0~23）
    4.天（月（0~31，但是你需要考虑你月的天数）
    5.月（0~11）
    6.天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
    7.年份（1970－2099）
    二：定时cron可以写的参数
    
    其中每个元素可以是一个值(如6), 一个连续区间(9-12), 一个间隔时间(8-18/4)(/表示每隔4小时), 一个列表(1,3,5), 通配符。
    由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?。
    三：定时案例分析  
    0 0 10,14,16  *  *  ? 每天上午10点，下午2点，4点
    
    0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
    
    0 0 12 ? * WED  表示每个星期三中午12点
    
    0 0 12 * * ? 每天12点触发 
    
    0 15 10 ? * * 每天10点15分触发 
    0 15 10 * * ? 每天10点15分触发 
    0 15 10 * * ? * 每天10点15分触发 
    0 15 10 * * ? 2005 2005年每天10点15分触发 
    0 * 14 * * ? 每天下午的 2点到2点59分每分触发 
    0 0/5 14 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发) 
    0 0/5 14,18 * * ? 每天下午的 2点到2点59分、18点到18点59分(整点开始，每隔5分触发) 
    0 0-5 14 * * ? 每天下午的 2点到2点05分每分触发 
    0 10,44 14 ? 3 WED 3月每周三下午的 2点10分和2点44分触发 
    0 15 10 ? * MON-FRI 从周一到周五每天上午的10点15分触发 
    0 15 10 15 * ? 每月15号上午10点15分触发 
    0 15 10 L * ? 每月最后一天的10点15分触发 
    0 15 10 ? * 6L 每月最后一周的星期五的10点15分触发 
    0 15 10 ? * 6L 2002-2005 从2002年到2005年每月最后一周的星期五的10点15分触发 
    0 15 10 ? * 6#3 每月的第三周的星期五开始触发 
    0 0 12 1/5 * ? 每月的第一个中午开始每隔5天触发一次 
    0 11 11 11 11 ? 每年的11月11号 11点11分触发(光棍节)
 * @author jiawei
 *
 */
@Component
public class TimeTaskLogDispatchController {
    private static final Logger LOGGER = Logger.getLogger(TimeTaskLogDispatchController.class);
    /**
     * 定时清除timeTaskLog 7天之前的记录
     */
    public void deleteTimeTaskLog(String data) {
    	LOGGER.info("【定时清除timeTaskLog 7天之前的记录】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始执行");
    	
    	STimetaskLogService bActiveService = (STimetaskLogService) ApplicationContextUtils.getBean(STimetaskLogService.class);
    	Date currentDate = new Date();
    	int day = -7;
    	Date deleteDate = DateUtil.getAfterNumDay(currentDate, day);
    	int ret = bActiveService.deleteLog(deleteDate);
    	if(ret >0){
    		LOGGER.info("【定时清除timeTaskLog 7天之前的记录】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>执行成功");
    	}else{
    		LOGGER.info("【定时清除timeTaskLog 7天之前的记录】>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>执行失败");
    	}
	  }
}
