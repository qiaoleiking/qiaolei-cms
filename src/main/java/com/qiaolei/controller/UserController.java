package com.qiaolei.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.qiaolei.beans.Articel;
import com.qiaolei.beans.Channel;
import com.qiaolei.beans.Collect;
import com.qiaolei.beans.Image;
import com.qiaolei.beans.TypeEnum;
import com.qiaolei.beans.User;
import com.qiaolei.common.CmsAssert;
import com.qiaolei.common.ConstantClass;
import com.qiaolei.common.MsgResult;
import com.qiaolei.service.ArticleService;
import com.qiaolei.service.ChannelService;
import com.qiaolei.service.CollectService;
import com.qiaolei.service.UserService;

/*
 * 
    * @ClassName: UserController
    * @Description: 管理用户的层级
    * @author Administrator
    * @date 2019年11月18日
    *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	private SimpleDateFormat dateFormat;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private CollectService collectService;
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	
	/**
	 * 
	    * @Title: register
	    * @Description:跳转到注册页面
	    * @param @param m
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(Model m){
			return "user/register";
	}
	
	/**
	 * 
	    * @Title: register
	    * @Description:用户注册
	    * @param @param m
	    * @param @param user
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(Model m,User user){
		System.out.println("46546465");
		int result = userService.register(user);	
		CmsAssert.AssertTrue(result>0,"用户注册失败,请稍后再试");
		return "redirect:/user/login";
		
	}
	
	/**
	 * 
	    * @Title: login
	    * @Description: 跳转到登录页面
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model m){
		return "user/login";
	}
	
	
	/**
	 * 
	    * @Title: login
	    * @Description:   登录
	    * @param @param m
	    * @param @param user
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Model m,User user,HttpServletRequest request){
		
		User loginUser = userService.login(user);
		
		if(loginUser!= null){
			request.getSession().setAttribute(ConstantClass.USER_KEY, loginUser);
			
			return loginUser.getRole() == ConstantClass.USER_ROLE_ADMIN ?
					"redirect:/admin/index.do" : "redirect:/user/home";	
		} else{
			request.setAttribute("errorMsg", "用户名或密码错误！！");
			request.setAttribute("user", user);
			return "user/login";
		}
	
	}
	
	/**
	 * 
	    * @Title: logout
	    * @Description: 退出登录
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute(ConstantClass.USER_KEY);
		return "redirect:/";
	}
	/**
	 * 
	    * @Title: home
	    * @Description: 跳转到用户管理
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("home")
	public String home(HttpServletRequest request){
		return "/user/home";
	}
	
	
	/**
	 * 
	    * @Title: myarticles
	    * @Description: 获取文章列表
	    * @param @param m
	    * @param @param pageNum
	    * @param @param request
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("myarticles")
	public String myarticles(Model m,@RequestParam(defaultValue="1")Integer pageNum
			,HttpServletRequest request){
		System.out.println("exaction:852963");
		User user = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		PageInfo info = articleService.listByUser(pageNum,user.getId());
		m.addAttribute("info", info);
		
		return "user/myarticles";
		
	}
	
	
	
	/**
	 * 
	    * @Title: MsgResult
	    * @Description: 删除自己的文章
	    * @param @return    参数
	    * @return MsgResult    返回类型
	    * @throws
	 */
	@RequestMapping("deleteArt")
	@ResponseBody
	public MsgResult MsgResult(Model m,Integer id,HttpServletRequest request){
		
		CmsAssert.AssertTrue(id>0, "文章id必须大于0");
		Articel articel = articleService.checkExist(id);
		CmsAssert.AssertTrue(articel!=null, "该文章不存在");
		
		User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
		CmsAssert.AssertTrue(loginUser.getRole() == ConstantClass.USER_ROLE_ADMIN 
				|| loginUser.getId() == articel.getUser().getId(),
				"只有管理员和文章的作者能删除文章");
		int result = articleService.delete(id);
		// kafka通知
		kafkaTemplate.send("articles","del="+id);
		
		CmsAssert.AssertTrue(result>0,"文章删除失败");
		return new MsgResult(1,"删除成功",null);
	}
	
	/**
	 * 
	    * @Title: postArticle
	    * @Description:获取get方法的postArticle的响应
	    * @param @param m
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@GetMapping("postArticle")
	public String postArticle(Model m){
		//获取所有的频道	
		List<Channel> channelList = channelService.getChannelList();
		m.addAttribute("channelList", channelList);
		return "showdetail/publish";
	}
	
	
	/**
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * 	    * @Title: postArticle
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param m
	    * @param @param file
	    * @param @param article
	    * @param @return    参数
	    * @return MsgResult    返回类型
	    * @throws
	 */
	@PostMapping("postArticle")
	@ResponseBody
	public MsgResult postArticle(HttpServletRequest request,Model m,MultipartFile file,Articel article) throws IllegalStateException, IOException{
		
	
		if(!file.isEmpty()){
			String processFile = processFile(file);
			article.setPicture(processFile);
		}
		
		User loginUser  = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		article.setUser_id(loginUser.getId());
		int result = articleService.add(article);
		System.err.println("+++++++++++"+article.getId());
		//通知次逻辑redis进行新增
		String jsonString = JSON.toJSONString(article);
		kafkaTemplate.send("articles","add="+jsonString);

		if(result>0) {
			return new MsgResult(1, "处理成功",null);
		}else {
			return new MsgResult(2, "添加失败，请稍后再试试！",null);
		}
	}
	
	
	/**
	 * 
	 * @param file
	 * @return  保存文件的相对路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
    private String processFile(MultipartFile file) throws IllegalStateException, IOException {
    	
    	//1 求扩展名  "xxx.jpg"
    	String suffixName =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
    	String fileNamePre = UUID.randomUUID().toString();
    	// 计算出新的文件名称
    	String fileName = fileNamePre + suffixName;
    	
    	dateFormat = new SimpleDateFormat("yyyyMMdd");
    	String path = dateFormat.format(new Date());
    	File pathFile  = new File("d:/pic/" + path);
    	if(!pathFile.exists()) {
    		pathFile.mkdirs();
    	}
    	
    	// 最终的新的文件名称
    	String newFileName = "d:/pic/"+ path + "/" + fileName;
    	file.transferTo(new File(newFileName));
    	
    	return path + "/" + fileName ;
    }

	
    @GetMapping("updateArticle")
    public String updateArticle(int id,Model m){
    	
    	//获取文章的详情 用于回显 
    	Articel articel = articleService.getDetailB1yId(id);
    	m.addAttribute("articel", articel);
    	m.addAttribute("content1", htmlspecialchars(articel.getContent()));
    	
    	System.out.println("将要修改文章" + articel);
    	
    	// 获取所有频道
    	List<Channel> channelList = channelService.getChannelList();
    	m.addAttribute("channelList", channelList);
		return "/showdetail/update";
    }
    
    
    /**
     * @throws IOException 
     * @throws IllegalStateException 
     * 
        * @Title: updateArticle
        * @Description: 修改文章
        * @param @param id
        * @param @param m
        * @param @return    参数
        * @return String    返回类型
        * @throws
     */
    @PostMapping("updateArticle")
    @ResponseBody
    public MsgResult updateArticle(HttpServletRequest request,Model m,MultipartFile file,Articel articel) throws IllegalStateException, IOException{

    	
    	if(!file.isEmpty()){
    		String processFile = processFile(file);
    		articel.setPicture(processFile);
    	}
    	
    	int result = articleService.update(articel);
    	//kafaka发送修改的文章
    	String jsonString = JSON.toJSONString(articel);
    	kafkaTemplate.send("articles","update="+jsonString);
    	 
		if(result>0) {
			// 成功
			return new MsgResult(1,"",null);
		}else {
			return new MsgResult(2,"失败",null);
		}
    }
    /**
     * 
        * @Title: collect
        * @Description: 收藏文章
        * @param @param id
        * @param @param request
        * @param @return    参数
        * @return MsgResult    返回类型
        * @throws
     */
    @RequestMapping("collect")
    @ResponseBody
    public MsgResult collect(int id,HttpServletRequest request){
		
    	CmsAssert.AssertTrue(id>0, "id不为空");
    	User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
    	CmsAssert.AssertTrue(loginUser != null,"未登陆");
    	int result = articleService.collect(id,loginUser.getId());
    	CmsAssert.AssertTrue(result > 0 ,"收藏失败");
    	return new MsgResult(1,"恭喜收藏成功",null);
    }
    
    /**
     * 
        * @Title: postImg
        * @Description: 跳转到发布图片的页面
        * @param @return    参数
        * @return String    返回类型
        * @throws
     */
    @GetMapping("postImg")
    public String postImg(Model m){
    	List<Channel> channelList = channelService.getChannelList();
		m.addAttribute("channelList", channelList);
    	return "/showdetail/postimg";
    }
    
    /**
     * 
        * @Title: postImg
        * @Description: 发表图片集
        * @param @param request
        * @param @param article
        * @param @param file
        * @param @param desc
        * @param @return
        * @param @throws IllegalStateException
        * @param @throws IOException    参数
        * @return MsgResult    返回类型
        * @throws
     */
    
    @RequestMapping(value = "postImg",method=RequestMethod.POST)
	@ResponseBody
	public MsgResult postImg(HttpServletRequest request,Articel article,
			MultipartFile file[],String desc[]) throws IllegalStateException, IOException {
		
		User loginUser = (User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		
		List<Image> list = new ArrayList<>();
		// 遍历处理每个上传图片 并存入list
		for (int i = 0; i < file.length && i < desc.length; i++) {
			String url = processFile(file[i]);
			Image image = new Image();
			image.setDesc(desc[i]);
			image.setUrl(url);
			list.add(image);
		}
		
		//
		Gson gson = new Gson();
		
		//设置作者
		article.setUser_id(loginUser.getId());
		article.setContent(gson.toJson(list));
		//设置文章类型 是图片
		article.setArticleType(TypeEnum.IMG);
		
		int add = articleService.add(article);
		if(add > 0) {
			return new MsgResult(1,"发布成功11",null);
		}else {
			return new MsgResult(2,"发布失败11",null);
		}

	}
    /**-
     * 
        * @Title: favorite
        * @Description: 收藏夹功能
        * @param @return    参数
        * @return String    返回类型
        * @throws
     */
    @RequestMapping("favorite")
    public String favorite(Model m,HttpServletRequest request,@RequestParam(defaultValue="1")Integer pageNum){
    	User loginUser = (User) request.getSession().getAttribute(ConstantClass.USER_KEY);
    	//PageInfo<Articel> info = articleService.getUserArticle(loginUser.getId(),pageNum);
    	PageInfo<Articel> info = collectService.getUserArticle(loginUser.getId(),pageNum);
    	m.addAttribute("info", info);
		return "/showdetail/collect";
    }
    
    /**
     * 
        * @Title: deleteCollect
        * @Description: 取消文章的收藏
        * @param @param id
        * @param @return    参数
        * @return MsgResult    返回类型
        * @throws
     */
    @RequestMapping("deleteCollect")
    @ResponseBody
    public MsgResult deleteCollect(int id){
    	
    	
    	int result = collectService.deleteCollect(id);
    	return new MsgResult(1,"删除成功","");
    }
    
    
  
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
    		collectService.add(collect);
    		return "/user/home";
    }
    
    
    
    
    /*
     * 方法拼接
     */
    private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
    
    
    
    
    
    
    
    
}











