package com.ffxl.admin.util;

import java.util.List;
import java.util.Map;

/**
 * @Description: DataTables服务端分页对象
 * @param <T>
 */
public class DataTablesUtil<T> {
	/** 
	 * 当前页面的第N次请求数据
	 */
	private int draw;
	
	/**
	 * 过滤前的总条数
	 */
	private long recordsTotal;
	
	/**
	 * 过滤后的条数
	 */
	private long recordsFiltered;
	
	/**
	 * 数据（后台查询返回的数据）
	 */
	private List<T> data;
	
	/**
	 * 当前页长度,即每页显示的记录数
	 */
	private int length;	
	
	/** 
	 * 当前页的第一条纪录的索引号
	 */
	private int start;	
	
	/**
	 * 查询条件
	 */
	private Map<String, String> search;	
	
	/**
	 * 排序
	 */
	private Map<String, String>[] order;	

	public DataTablesUtil(int draw, long recordsTotal, long recordsFiltered, List<T> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public DataTablesUtil(int draw, long recordsTotal, long recordsFiltered, List<T> data, int length, int start) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
		this.length = length;
		this.start = start;
	}

	public DataTablesUtil() {
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Map<String, String> getSearch() {
		return search;
	}

	public void setSearch(Map<String, String> search) {
		this.search = search;
	}

	public Map<String, String>[] getOrder() {
		return order;
	}

	public void setOrder(Map<String, String>[] order) {
		this.order = order;
	}
}
