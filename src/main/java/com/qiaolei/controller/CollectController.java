package com.qiaolei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiaolei.beans.Collect;
import com.qiaolei.beans.User;
import com.qiaolei.common.ConstantClass;
import com.qiaolei.service.ArticleService;
/**
 * 
    * @ClassName: CollectController
    * @Description:处理收藏的业务 的controller
    * @author Administrator
    * @date 2019年11月27日
    *
 */
@Controller
public class CollectController {
	
	@Autowired
	private ArticleService articleService;

	/**
	    * 
	       * @Title: addCollect
	       * @Description:去往添加的页面
	       * @param @param m
	       * @param @return    参数
	       * @return String    返回类型
	       * @throws
	    */
	    @GetMapping("addCollect")
	    public String addCollect(Model m){
	    	m.addAttribute("collect", new Collect());
			return "/showdetail/add";	
	    }
	    
	    
	    /**
	     * 
	        * @Title: addCollect
	        * @Description:新增的方法
	        * @param @param m
	        * @param @return    参数
	        * @return String    返回类型
	        * @throws
	     */
	    @PostMapping("addCollect")
	    public String addCollect(Model m,@Valid @ModelAttribute("collect")Collect collect,
	    		BindingResult result,HttpServletRequest request
	    		){
	    	
	    		if(result.hasErrors()){
	    			return "showdetail/add";	
	    		}
	    		User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
	    		collect.setUser_id(loginUser.getId());
	    		//collectService.add(collect);
	    		return "/user/home";
	    }
	    /**
	     * 
	        * @Title: String
	        * @Description: 删除的业务逻辑
	        * @param     参数
	        * @return void    返回类型
	        * @throws
	     */
	    public void String(){
	    	String str = null;
	    	
	    			str = str.replaceAll("&", "&amp;");
	    			str = str.replaceAll("<", "&lt;");
	    			str = str.replaceAll(">", "&gt;");
	    			str = str.replaceAll("\"", "&quot;");
	    		//	return str;
	    		
	    }
	    
	
	
	
}
