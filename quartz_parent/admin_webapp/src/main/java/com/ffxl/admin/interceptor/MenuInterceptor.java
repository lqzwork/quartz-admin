package com.ffxl.admin.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 菜单拦截器
 */
public class MenuInterceptor extends HandlerInterceptorAdapter {

  private final Logger log = LoggerFactory.getLogger(MenuInterceptor.class);

  /**
   * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
   * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String path = request.getContextPath(); // eg: /admin
    String remoteUser = request.getRemoteUser(); // 登陆用户名
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path ;
    String servletPath = request.getServletPath(); // 请求接口名
    remoteUser = remoteUser==null?"用户未登陆":remoteUser;
    log.info("操作用户名: " +remoteUser );
    log.info("请求URL: " + basePath + servletPath);
    HttpSession session = request.getSession();
    Enumeration<?> enu = request.getParameterNames();
    String thirdMenu = null;
    String secondMenu = null;
    while (enu.hasMoreElements()) {
      String paraName = (String) enu.nextElement();
      if (paraName.equals("secondMenu")) {
        secondMenu = request.getParameter(paraName);
      }
      if (paraName.equals("thirdMenu")) {
        thirdMenu = request.getParameter(paraName);
      }
      session.setAttribute(paraName, request.getParameter(paraName));
    }
    return true;
  }

  /**
   * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
  }

  /**
   * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
  }
}
