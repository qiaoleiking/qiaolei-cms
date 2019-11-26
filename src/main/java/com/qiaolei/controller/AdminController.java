package com.qiaolei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.Articel;
import com.qiaolei.beans.User;
import com.qiaolei.common.CmsAssert;
import com.qiaolei.common.MsgResult;
import com.qiaolei.service.ArticleService;
import com.qiaolei.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	
	@Autowired 
	private UserService userservice;
	
	
	@Autowired
	private ArticleService articleService;
	
	
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
		m.addAttribute("mohu", mohu);
		return "admin/users/list";
	}
	
	@RequestMapping("transform")
	@ResponseBody
	public MsgResult transform(Integer userId,int state){
		// 如果状态不是0,1  提示
		if(state != 0 && state != 1){
			return new MsgResult(2,"参数无效",null);
		}
		
		User user = userservice.getUserById(userId);
		// 无用户信息时 提示
		if(user == null){
			return new MsgResult(2,"该用户不存在",null);
		}
		// 当前信息与数据库相等时 提示
		if(user.getLocked() == state){
			return new MsgResult(2,"无需做该操作",null);
		}
		
		
		int result = userservice.updateState(userId,state);
		
		if(result > 0){
			return new MsgResult(1,"恭喜您,处理成功",null);
		}else{
			return new MsgResult(2,"处理失败,请与管理员联系",null);
		}
	}
	/**
	 * 
	    * @Title: articles
	    * @Description: 获取管理员权限下的全部文章
	    * @param @param m
	    * @param @param pageNum
	    * @param @param status
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("articles")
	public String articles(Model m,@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="-1")int status
			){
				
		PageInfo<Articel> articelList = articleService.getArticlesPageList(status,pageNum);
		m.addAttribute("articelList", articelList);
		m.addAttribute("status", status);
		
		return "/admin/article/list";
		
	}
	
	/**
	 * 
	    * @Title: getArticle
	    * @Description: 获取需要审核的文章
	    * @param @return    参数
	    * @return MsgResult    返回类型
	    * @throws
	 */
	@RequestMapping("getArticle")
	@ResponseBody
	public MsgResult getArticle(int id){
		
		Articel articel = articleService.getDetailB1yId(id);
		CmsAssert.AssertTrue(articel != null , "文章不存在");
		return new MsgResult(1,"获取成功",articel);

		
	}
	
	/**
	 * 
	    * @Title: applyArticle
	    * @Description: 修改审核
	    * @param @param id
	    * @param @param status
	    * @param @return    参数
	    * @return MsgResult    返回类型
	    * @throws
	 */
	@RequestMapping("applyArticle")
	@ResponseBody
	public MsgResult applyArticle(int id,int status) {
		Articel article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.apply( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
	
	
	/**
	 * 
	    * @Title: setArticleHot
	    * @Description: 设置热门
	    * @param @param id
	    * @param @param status
	    * @param @return    参数
	    * @return MsgResult    返回类型
	    * @throws
	 */
	@RequestMapping("setArticleHot")
	@ResponseBody
	public MsgResult setArticleHot(int id,int status) {
		Articel article = articleService.checkExist(id);
		CmsAssert.AssertTrue(article!=null, "该文已经不存在");
		int result = articleService.setHot( id,status);
		if(result>0) {
			return new MsgResult(1,"处理成功",null);
		}else {
			return new MsgResult(2,"处理失败",null);
		}
	}
	
	
	
}








