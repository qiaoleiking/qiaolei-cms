package com.qiaolei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("list.do")
	public String test(HttpServletRequest request){
		
		request.setAttribute("hellow","hellow");
		return "index";
	}
}
