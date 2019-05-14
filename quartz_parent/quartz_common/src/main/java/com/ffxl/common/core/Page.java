package com.ffxl.common.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page {
	private static final Logger logger = LoggerFactory.getLogger(Page.class);
	private int tag; // 1:重置分页从第一页 0:继续session中的分页信息
	public static final Integer DEFAULT_PAGE_SIZE = 10;
	public static final Integer DEFAULT_CURRENT_PAGE = 1;
	private Integer pageNo; // 当前页码
	private Integer pageSize; // 每页行数
	private Integer totalRecord; // 总记录数
	private Integer totalPage; // 总页数

	private Object dataList;
	private String orderBy;
	private String sortName;

	/**
	 * 无参构造器
	 */
	public Page() {
		this(DEFAULT_PAGE_SIZE, 1);
	}

	public Page(Integer pageSize, Integer pageNo) {
		this.totalRecord = 0;
		this.setPageSize(pageSize);
		this.setPageNo(pageNo);
	}

	/**
	 * 静态工厂方法
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param url
	 * @return Page对象
	 * @author wison
	 * @createDate 2015年7月29日
	 */
	public static Page newBuilder(Integer pageNo, Integer pageSize, String url) {
		Page page = new Page();
		if (pageNo != null) {
			page.setPageNo(pageNo);
		}
		if (pageSize != null) {
			page.setPageSize(pageSize);
		}
		return page;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = (pageNo == null ? DEFAULT_CURRENT_PAGE : pageNo);
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = (pageSize == null ? DEFAULT_PAGE_SIZE : pageSize);
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = (totalRecord == null ? 0 : totalRecord);
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getBegin() {
		return (this.pageNo - 1) * this.pageSize;
	}

	public Integer getEnd() {
		return this.pageNo * this.pageSize;
	}

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public int getTotalPageNumber() {
		return (int) Math.ceil((this.totalRecord * 1.0d) / this.pageSize);
	}

	/**
	 * 是否第一页
	 * 
	 * @return
	 */
	public boolean isFirstPage() {
		return pageNo == 1;
	}

	/**
	 * 是否最后一页
	 * 
	 * @return
	 */
	public boolean isLastPage() {
		return pageNo >= (int) Math.ceil((this.totalRecord * 1.0d) / this.pageSize);
	}

	public Object getDataList() {
		return dataList;
	}

	public void setDataList(Object dataList) {
		this.dataList = dataList;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

}
