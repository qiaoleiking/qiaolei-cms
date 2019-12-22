package com.qiaolei.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qiaolei.StringUtils;
import com.qiaolei.beans.Link;
import com.qiaolei.common.MsgResult;
import com.qiaolei.service.LinkService;

/**
 * 
    * @ClassName: LinkController
    * @Description: 管理友情链接
    * @author Administrator
    * @date 2019年11月23日
    *
 */
@Controller
@RequestMapping("link")
public class LinkController {
	
	
	@Autowired
	private LinkService linkService;
	
	
	
	/**
	 * 
	    * @Title: add
	    * @Description: 跳转到添加的页面
	    * @param @param m
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@GetMapping("add")
	public String add(Model m){
		m.addAttribute("link", new Link());
		return "/admin/link/add";
	}
	/**
	 * 
	    * @Title: add
	    * @Description: 执行添加功能
	    * @param @param m
	    * @param @param link
	    * @param @param result
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@PostMapping("add")
	public String add(Model m,@Valid @ModelAttribute("link")Link link,
			BindingResult result){
	
		if(result.hasErrors()){
			return "admin/link/add";
		}
		
		linkService.add(link);
		
		return "redirect:/admin/index.do"; 
	}
	
	/**
	 * 
	    * @Title: list
	    * @Description:友情链接链表
	    * @param @param request
	    * @param @param pageNum
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request, 
			@RequestParam(defaultValue="1") int pageNum) {
		
		PageInfo info = linkService.list(pageNum);
		request.setAttribute("info", info);
		return "admin/link/list";
		
		
	}
	
	
	//删除
	@RequestMapping("delete")
	@ResponseBody
	public MsgResult delete(HttpServletRequest request,int id) {
		int result = linkService.delete(id);
		if(result<1)
			return new MsgResult(2,"删除失败",null);
		
		return new MsgResult(1,"删除失败",null);
		
	}
	
	//修改
	@GetMapping("update")
	public String add(HttpServletRequest request,int id) {
		request.setAttribute("link", linkService.get(id));
		return "admin/link/update";	 
	}
	
	
	@PostMapping("update")
	public String update(HttpServletRequest request,
			@Valid  @ModelAttribute("link") Link link,
			BindingResult result
			) {
		
		if(!StringUtils.isHttpUrl(link.getUrl())) {
			result.rejectValue("url", "不是合法的url", "不是合法的url");
		}
		
		// 有错误 还在原来的页面
		if(result.hasErrors()) {
			//request.setAttribute("link", link);
			return "admin/link/update";	
		}
		
		linkService.update(link);
		
		// 没有错误跳转到列表页面
		return "redirect:list";
	}
	
	
	
	
	
	
}










