package com.ffxl.platform.util.utf8;



import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utf8Mb4HttpServletRequestWrapper extends HttpServletRequestWrapper {
	private static final Logger log = LoggerFactory.getLogger(Utf8Mb4HttpServletRequestWrapper.class);
	
	public Utf8Mb4HttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		 
		String value = super.getParameter(name);
		
		String result = null;
		try {
			result = Utf8Mb4Utils.filterOffUtf8Mb4(value);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}
		return result;
		 
	}

	@Override
	public Map getParameterMap() {
		return super.getParameterMap();
	}

	@Override
	public String[] getParameterValues(String name) {
	 
		String[] values = super.getParameterValues(name);
		if (values != null ) {
			for (int i = 0; i < values.length; i++) {
				try {
					values[i] = Utf8Mb4Utils.filterOffUtf8Mb4(values[i]);
				} catch (UnsupportedEncodingException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		  
		return values;
		 
	}
	
}
