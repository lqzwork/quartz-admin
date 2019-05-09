package com.ffxl.quartz.task.util;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ffxl.cloud.model.warpper.ScheduleJob;

/**
 * 
 * @Description: 计划任务执行处 无状态
 * @author wison
 * @date 2017年11月11日 下午5:05:47
 */
public class QuartzJobFactory implements Job {
	public final Logger log = Logger.getLogger(this.getClass());

	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtils.invokMethod(scheduleJob);
	}
}