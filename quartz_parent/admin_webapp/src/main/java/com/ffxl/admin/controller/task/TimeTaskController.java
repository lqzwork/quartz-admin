package com.ffxl.admin.controller.task;

import com.ffxl.admin.controller.BaseController;
import com.ffxl.admin.util.DataTablesUtil;
import com.ffxl.business.service.STimetaskService;
import com.ffxl.common.constant.Const;
import com.ffxl.common.core.Page;
import com.ffxl.common.exception.BusinessException;
import com.ffxl.common.util.*;
import com.ffxl.dao.model.STimetask;
import com.ffxl.dao.model.warpper.ScheduleJob;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 定时任务
 *
 * @author wison
 */
@Controller
@RequestMapping(value = "/task")
public class TimeTaskController extends BaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(TimeTaskController.class);
    @Autowired
    private STimetaskService stimetaskService;
    
    // private static String JOB_URL = Const.QUARTZ_JOB_URL;
    // private static String JOB_URL = "http://192.168.253.5:8088";
    
    //被监控定时任务所在服务IP   bill_down服务
    // private static String RUNNING_IP = "172.29.10.133";
    // private static String JOB_URL = "http://172.18.98.25:8099";
    
    //被监控定时任务所在服务IP   bill_balance服务
    private static String JOB_URL = "http://172.18.98.61:8099";
    private static String RUNNING_IP = "172.29.11.129";
    
    private static String ALL_JOB = JOB_URL + "/opt/getAllJob"; //所有计划中的任务列表
    private static String RUNNING_JOB = JOB_URL + "/opt/getRunningJob";//所有正在运行的job
    private static String ADD_JOB = JOB_URL + "/opt/addJob";//添加任务
    private static String PAUSE_JOB = JOB_URL + "/opt/pauseJob";//暂停一个job
    private static String RESUME_JOB = JOB_URL + "/opt/resumeJob";//恢复一个job
    private static String DELETE_JOB = JOB_URL + "/opt/deleteJob";//删除一个job
    private static String RUNA_JOB = JOB_URL + "/opt/runAJobNow";//立即执行job
    private static String UPDATE_JOB = JOB_URL + "/opt/updateJobCron";//更新job时间表达式
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat fmt = new SimpleDateFormat(DateUtil.STANDARD_DATE_FORMAT_STR);
        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
    
    /**
     * 列表页面跳转
     */
    @RequestMapping(value = "/list")
    public ModelAndView userList(STimetask task) {
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("system/timeTaskList");
        return mv;
    }
    
    /**
     * 列表
     */
    @RequestMapping(value = "/task_list")
    @ResponseBody
    public JsonResult taskList(DataTablesUtil dataTables, STimetask task, Page page, HttpSession session) {
        task.setRunningIp(RUNNING_IP);
        List<STimetask> list = stimetaskService.selectByPage(task, page);
        /**
         * 查询所有任务
         */
        String planResult = HttpConnectUtil.httpRequest(ALL_JOB, Const.REQUEST_METHOD_GET, null);
        if(planResult != null) {
            JSONObject jsonPlanResult = JSONObject.fromObject(planResult);
            Map<String, ScheduleJob> planMap = new HashMap<String, ScheduleJob>();
            if(jsonPlanResult.get("code").equals("2000")) {
                JSONObject js = (JSONObject) jsonPlanResult.get("data");
                JSONArray dataArray = (JSONArray) js.get("job");
                if(dataArray.size() > 0) {
                    List<ScheduleJob> jobList = JSONArray.toList(dataArray, ScheduleJob.class);
                    for(ScheduleJob job : jobList) {
                        planMap.put(job.getJobId(), job);
                    }
                }
            }
            for(STimetask st : list) {
                if(planMap.containsKey(st.getId())) {
                    st.setPlanStatus(planMap.get(st.getId()).getJobStatus());
                }
            }
        }
        //返回dataTable所需数据
        dataTables = this.getDataTables(page, dataTables, list);
        return new JsonResult("2000", dataTables);
    }
    
    /**
     * 立即执行一次job
     * 用于测试任务是否正确
     */
    @RequestMapping(value = "/run_task2job")
    @ResponseBody
    public JsonResult run_task2job(String id) {
        //查询task
        STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
        String result = HttpConnectUtil.httpRequest(RUNA_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
        logger.info(result);
        if(result == null) {
            return new JsonResult("5000", "定时项目未启动", null);
        } else {
            return new JsonResult("2000", null);
        }
    }
    
    /**
     * 添加job到计划列表
     */
    @RequestMapping(value = "/add_task2job")
    @ResponseBody
    public JsonResult add_task2job(String id) {
        //查询task
        STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
        String result = HttpConnectUtil.httpRequest(ADD_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
        logger.info(result);
        if(result == null) {
            return new JsonResult("5000", "定时项目未启动", null);
        } else {
            return new JsonResult("2000", null);
        }
        
    }
    
    /**
     * 从计划列表中暂停job
     */
    @RequestMapping(value = "/stop_task2job")
    @ResponseBody
    public JsonResult stop_task2job(String id) {
        //查询task
        STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
        String result = HttpConnectUtil.httpRequest(PAUSE_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
        logger.info(result);
        if(result == null) {
            return new JsonResult("5000", "定时项目未启动", null);
        } else {
            return new JsonResult("2000", null);
        }
    }
    
    /**
     * 从计划列表中移除job
     */
    @RequestMapping(value = "/remove_task2job")
    @ResponseBody
    public JsonResult remove_task2job(String id) {
        //查询task
        STimetask stimetask = stimetaskService.selectByPrimaryKey(id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject jsonArray = JSONObject.fromObject(stimetask, jsonConfig);
        String result = HttpConnectUtil.httpRequest(DELETE_JOB, Const.REQUEST_METHOD_POST, jsonArray.toString());
        logger.info(result);
        if(result == null) {
            return new JsonResult("5000", "定时项目未启动", null);
        } else {
            return new JsonResult("2000", null);
        }
    }
    
    /**
     * 变更job状态
     */
    @RequestMapping(value = "/update_task")
    @ResponseBody
    public JsonResult update_task(String ids, String type) {
        //查询task
        String[] idArray = ids.split(",");
        Map<String, String> selectedIdMap = new HashMap<String, String>();
        List<String> idList = new ArrayList<String>();
        for(int i = 0; i < idArray.length; i++) {
            idList.add(idArray[i]);
        }
        int ret = stimetaskService.updatebyOperate(idList, type);
        if(ret > 0) {
            return new JsonResult(true);
        } else {
            return new JsonResult(false);
        }
    }
    
    /**
     * 删除job
     */
    @RequestMapping(value = "/delete_task")
    @ResponseBody
    public JsonResult delete_task(String ids) {
        //查询task
        String[] idArray = ids.split(",");
        Map<String, String> selectedIdMap = new HashMap<String, String>();
        List<String> idList = new ArrayList<String>();
        for(int i = 0; i < idArray.length; i++) {
            idList.add(idArray[i]);
        }
        int ret = stimetaskService.deleteByIds(idList);
        if(ret > 0) {
            return new JsonResult(true);
        } else {
            return new JsonResult(false);
        }
    }
    
    
    /**
     * 详情页面
     */
    @RequestMapping(value = "/task_detail")
    public ModelAndView detail(String id) {
        ModelAndView mv = this.getModelAndView();
        STimetask model = new STimetask();
        model = stimetaskService.selectByPrimaryKey(id);
        mv.addObject("model", model);
        mv.setViewName("system/timeTaskDetail");
        return mv;
    }
    
    /**
     * 解析cron
     */
    @RequestMapping(value = "/analysis_cron")
    @ResponseBody
    public JsonResult analysisCron(String cron) {
        try {
            Date date = new Date();
            String dateStr = DateUtil.formatStandardDatetime(date);
            List<String> dateList = CronUtil.cronAlgBuNums(cron, dateStr, 5);
            return new JsonResult("2000", dateList);
        } catch(Exception e) {
            e.printStackTrace();
            return new JsonResult("5000", null);
        }
    }
    
    /**
     * 验证名称是否存在
     */
    @RequestMapping(value = "/check_name")
    @ResponseBody
    public Boolean check_name(String id, String groupName, String name) {
        if(StringUtil.isEmpty(groupName, name)) {
            throw new BusinessException(Message.M4003);
        }
        STimetask task = new STimetask();
        task.setId(id);
        task.setGroupName(groupName);
        task.setName(name);
        STimetask queryTask = stimetaskService.checkName(task);
        if(queryTask != null) {
            logger.debug("组.任务名 exists,return false");
            return false;
        } else {
            logger.debug("组.任务名 not exists,return true");
            return true;
        }
    }
    
    /**
     * 保存
     */
    @RequestMapping(value = "/task_save")
    @ResponseBody
    public JsonResult userSave(STimetask task, HttpSession session) {
        //获取系统操作人员
        String longName = "admin";
        task.setModifyUserId(longName);
        try {
            int ret = stimetaskService.insertOrUpdateByUser(task, longName);
            if(ret > 0) {
                return new JsonResult("2000", task);
            } else {
                return new JsonResult("5000");
            }
        } catch(BusinessException e) {
            return new JsonResult("5001", e.getMessage(), null);
        }
    }
    
}
