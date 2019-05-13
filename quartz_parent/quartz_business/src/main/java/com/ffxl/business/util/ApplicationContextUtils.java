package com.ffxl.business.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 根据上下文获取spring类
 * @author
 *
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
	private static ApplicationContextUtils instance = null;

	public static synchronized ApplicationContextUtils getInstance() {
		if (instance == null) {
			instance = new ApplicationContextUtils();
		}
		return instance;
	}

	private ApplicationContext appCtx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCtx = applicationContext;
	}

	public static <T> T getBean(Class<T> beanClass) throws BeansException {
		ApplicationContextUtils appCtxUtils = ApplicationContextUtils.getInstance();
		return appCtxUtils.appCtx.getBean(beanClass);
	}

	public static <T> T getBean(String name, Class<T> beanClass) throws BeansException {
		ApplicationContextUtils appCtxUtils = ApplicationContextUtils.getInstance();
		return appCtxUtils.appCtx.getBean(name, beanClass);
	}

	public static boolean containsBean(String name) {
		ApplicationContextUtils appCtxUtils = ApplicationContextUtils.getInstance();
		return appCtxUtils.appCtx.containsBean(name);
	}
}
