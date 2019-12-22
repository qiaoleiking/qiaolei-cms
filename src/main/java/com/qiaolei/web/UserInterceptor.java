package com.qiaolei.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.qiaolei.beans.User;
import com.qiaolei.common.ConstantClass;

/**
 * 
    * @ClassName: UserInterceptor
    * @Description: 自定义一个拦截器
    * @author Administrator
    * @date 2019年11月20日
    *
 */
public class UserInterceptor implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			
		User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		if(loginUser == null){
			response.sendRedirect("/user/login");
			return false;
		}
		
		/**
		 * 普通用户不能进入管理员页面
		 */
		if(request.getServletPath().contains("/admin/") 
				&& loginUser.getRole() == ConstantClass.USER_ROLE_GENERAL){
		
			request.setAttribute("errorMsg","只有管理员才能访问这个页面");
			request.getRequestDispatcher("/user/login").forward(request, response);
			return false;
			}
		return true;
		}	
	}










	