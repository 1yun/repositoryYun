package com.yc.blog.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yc.blog.vo.Result;
import com.yc.blog.vo.resultEnum;

public class LoginInterceptor implements HandlerInterceptor{
	//action 执行前的前置方法
	//return 表示 是否执行action方法
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object action) throws Exception {
		System.out.println("拦截器。。。。。。。。");
		if(request.getSession().getAttribute("loginedUser")==null){
			//判断是否是ajax请求
			if(request.getHeader("X-Requested-With") == null){
				response.sendRedirect("index?login");
			}else{
				//如果是ajax请求 需要用户先登录
				String str = JSON.toJSONString(new Result(resultEnum.LOGIN));
				//让jquery  将json字符串转换成json对象
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().append(str);
			}
			return false;
		}
		return true;
	}
}
