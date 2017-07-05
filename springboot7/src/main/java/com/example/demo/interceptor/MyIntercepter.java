package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器类===验证用户session
@Component
public class MyIntercepter implements HandlerInterceptor{
		org.slf4j.Logger logger=LoggerFactory.getLogger(MyIntercepter.class);
	
	/**
	 * 在执行目标方法之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("=========请求"+request.getRequestURI());
		logger.info("==========preHandle###{请求正式处理前}");
		request.setAttribute("startTime", System.currentTimeMillis());//开始时间
		 // 验证用户是否登陆
/*		Object obj=request.getSession().getAttribute("session");//验证session是否存在
		if (obj==null) {
			response.sendRedirect("/Friend/login");
			return false;
		}*/
		return true;//注意此处返回
	}

	/**
	 * 执行目标方法之后执行
	 *   /**
     *当前请求进行处理之后，也就是Controller 方法调用之后执行，
     *但是它会在DispatcherServlet 进行视图返回渲染之前被调用。
     *此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理。
     */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.error("==========postHandle###{请求正式处理完成}");
		Long startTime=(Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		Long endTime=System.currentTimeMillis();
		logger.info("=========请求"+request.getRequestURI()+"处理时间"+(endTime-startTime));
		
	}
	
	/**
	 *     /**
     *方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     *这个方法的主要作用是用于进行资源清理工作的。
     */

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("=============afterComplete");
	}

}
