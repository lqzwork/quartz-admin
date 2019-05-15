package com.ffxl.quartz.init;

import com.ffxl.business.service.STimetaskService;
import com.ffxl.dao.model.STimetask;
import com.ffxl.dao.model.STimetaskExample;
import com.ffxl.dao.model.base.BaseSTimetaskExample.Criteria;
import com.ffxl.dao.model.warpper.ScheduleJob;
import com.ffxl.quartz.task.util.QuartzJobFactory;
import com.ffxl.quartz.task.util.QuartzJobFactoryDisallowConcurrentExecution;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 根据上下文获取spring类
 *
 * @author
 */
public class InitQuartzJob implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(InitQuartzJob.class);
    
    private static ApplicationContext appCtx;
    public static SchedulerFactoryBean schedulerFactoryBean = null;
    
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(this.appCtx == null) {
            this.appCtx = applicationContext;
        }
    }
    
    public static void init() {
        schedulerFactoryBean = (SchedulerFactoryBean) appCtx.getBean(SchedulerFactoryBean.class);
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            logger.info(scheduler.getSchedulerName());
        } catch(SchedulerException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // 这里从数据库中获取任务信息数据
        STimetaskService sTimetaskService = (STimetaskService) appCtx.getBean(STimetaskService.class);
        STimetaskExample example = new STimetaskExample();
        Criteria c = example.createCriteria();
        c.andJobStatusEqualTo("1"); // 已发布的定时任务
        List<STimetask> list = sTimetaskService.selectByExample(example);
        List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
        for(STimetask sTimetask : list) {
            ScheduleJob job1 = new ScheduleJob();
            job1.setJobId(sTimetask.getId());
            job1.setJobGroup(sTimetask.getGroupName()); // 任务组
            job1.setJobName(sTimetask.getName());// 任务名称
            job1.setJobStatus(sTimetask.getJobStatus()); // 任务发布状态
            job1.setIsConcurrent(sTimetask.getConcurrent() ? "1" : "0"); // 运行状态
            job1.setCronExpression(sTimetask.getCron());
            job1.setBeanClass(sTimetask.getBeanName());// 一个以所给名字注册的bean的实例
            job1.setMethodName(sTimetask.getMethodName());
            job1.setJobData(sTimetask.getJobData()); // 参数
            job1.setStartTime(sTimetask.getStartTime()); // 参数
            job1.setEndTime(sTimetask.getEndTime()); // 参数
            jobList.add(job1);
        }
        
        for(ScheduleJob job : jobList) {
            try {
                addJob(job);
            } catch(SchedulerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 添加任务
     */
    public static void addJob(ScheduleJob job) throws SchedulerException {
        if(job == null || !ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            return;
        }
        
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        logger.debug(scheduler + "...........................................add");
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        TriggerBuilder<CronTrigger> triggerBuilder = null;
        
        // 不存在，创建一个
        if(null == trigger) {
            Class clazz = ScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class :
                    QuartzJobFactoryDisallowConcurrentExecution.class;
            
            JobDetail jobDetail =
                    JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).usingJobData("data",
                            job.getJobData()).build();
            
            jobDetail.getJobDataMap().put("scheduleJob", job);
            
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            
            triggerBuilder =
                    TriggerBuilder.newTrigger().withDescription(job.getJobId()).withIdentity(job.getJobName(),
                            job.getJobGroup()).withSchedule(scheduleBuilder);
            if(null != job.getStartTime()) {
                triggerBuilder.startAt(job.getStartTime());
            }
            if(null != job.getEndTime()) {
                triggerBuilder.endAt(job.getEndTime());
            }
            trigger = triggerBuilder.build();
            
            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            
            // 按新的cronExpression表达式重新构建trigger
            triggerBuilder = trigger.getTriggerBuilder().withIdentity(triggerKey).usingJobData("data",
                    job.getJobData()).withSchedule(scheduleBuilder);
            
            if(null != job.getStartTime()) {
                triggerBuilder.startAt(job.getStartTime());
            }
            if(null != job.getEndTime()) {
                triggerBuilder.endAt(job.getEndTime());
            }
            trigger = triggerBuilder.build();
            
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }
    
}
