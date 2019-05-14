package com.ffxl.admin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ffxl.admin.util.DataTablesUtil;
import com.ffxl.common.core.Page;
public class BaseController {
	@Autowired  
    private HttpSession session;  
	
	public ModelAndView mv = this.getModelAndView();
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		ModelAndView mv= new ModelAndView();
		return mv;
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}
	/**
	 * 得到ContextPath
	 */
	public String getBasePath(String url){
		return this.getRequest().getContextPath()+url;
	}
	
	public Page getPageInfo(Page page ,DataTablesUtil dataTables){
		if(dataTables.getLength()  == 0){
			dataTables.setLength(Integer.valueOf(Page.DEFAULT_PAGE_SIZE));
		}
		page.setPageNo(dataTables.getStart()/dataTables.getLength() +1);
		page.setPageSize(dataTables.getLength());
		return page;
	}
	
	/**
	 * 返回分页dataTable数据
	 * @param page
	 * @param dataTables
	 * @param dataList
	 * @return
	 */
	public DataTablesUtil getDataTables(Page page,DataTablesUtil dataTables,List dataList){
		dataTables.setRecordsTotal(page.getTotalRecord());
		dataTables.setRecordsFiltered(page.getTotalRecord());
		dataTables.setData(dataList);
		return dataTables;
	}
	
	/**
	 * 返回不带分页dataTable数据
	 * @param dataTables
	 * @param dataList
	 * @return
	 */
	public DataTablesUtil getDataTables(DataTablesUtil dataTables,List dataList){
		dataTables.setRecordsTotal(dataList.size());
		dataTables.setRecordsFiltered(dataList.size());
		dataTables.setData(dataList);
		return dataTables;
	}
}
