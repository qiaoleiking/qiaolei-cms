package com.qiaolei.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
    * @ClassName: ControllerInterceptor
    * @Description: 超级controller类
    * @author Administrator
    * @date 2019年11月22日
    *
 */
//@ControllerAdvice
//public class ControllerInterceptor {
//	
//	@ExceptionHandler(CmcException.class)
//	@ResponseBody
//	public MsgResult interceptorException(CmcException exception){
//		System.out.println(" 错误是 "  + exception);
//		return new MsgResult(100,exception.getMessage(), null);
//	}
//	
//	@ExceptionHandler(CmcException.class)
//	public ModelAndView interceptorExceptionHtml(CmcExceptionHtml excetion){
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("error");
//		modelAndView.addObject("errorInfo", excetion.getMessage());
//		return modelAndView;	
//	}
//}










