package com.ffxl.admin.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ffxl.admin.controller.BaseController;


/**
 * 登录控制器
 * @author jiawei
 * 2018年6月24日
 */
@Controller
public class LoginController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model,HttpServletRequest request, HttpServletResponse response) {
        return "system/timeTaskList";
    }
    
    /**
     * 跳转401
     */
    @RequestMapping("/401")
    public String t401(Model model) {
        return  "error/401";
    }
    
    /**
     * 跳转404
     */
    @RequestMapping("/404")
    public String t404(Model model) {
        return  "error/404";
    }
    
    /**
     * 跳转500
     */
    @RequestMapping("/500")
    public String t500(Model model) {
        return  "error/500";
    }
}
