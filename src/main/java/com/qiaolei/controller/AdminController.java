package com.qiaolei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.qiaolei.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	
	@Autowired 
	private UserService userservice;
	/**
	 * 
	    * @Title: index
	    * @Description: 访问主页
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("index.do")
	public String index(HttpServletRequest request){
		return "admin/index";
	}
	
	/**
	 * 
	    * @Title: users
	    * @Description: 获取用户列表
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("users")
	public String users(Model m,@RequestParam(defaultValue="1")Integer pageNum,String mohu){
		Integer pageSize = 5;
		PageInfo info = userservice.getUserList(pageNum,pageSize,mohu);
		m.addAttribute("info", info);
		return "admin/users/list";
	}
	
	
	
	
	
}








