package com.qiaolei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.qiaolei.beans.Articel;
import com.qiaolei.beans.Category;
import com.qiaolei.beans.Image;
import com.qiaolei.beans.TypeEnum;
import com.qiaolei.common.MsgResult;
import com.qiaolei.service.ArticleService;
import com.qiaolei.service.CategoryService;

/**
 * 
    * @ClassName: ArticleController
    * @Description:获取文章的内容
    * @author Administrator
    * @date 2019年11月15日
    *
 */
@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService categoryService;
	//获取文章的嫩容
	@RequestMapping("showdetail")
	public String showDetail(Integer id,Model m){
		
		Articel articel = articleService.getArticleContent(id);		
		m.addAttribute("articel",articel);
		
		if(articel.getArticleType()==TypeEnum.HTML)
			return "/showdetail/detail";
		else {
			Gson gson = new Gson();
			// 文章内容转换成集合对象
			List<Image> imgs = gson.fromJson(articel.getContent(), List.class);
			articel.setImgList(imgs);
			System.out.println(" article is "  + articel);
			return "/showdetail/detailimg";
		}
		
		
	}
	
	// 联动的代码
	@RequestMapping("getCategoryByChannel")
	@ResponseBody
	public MsgResult getCategoryByChannel(int chaId){
		
		List<Category> categories = categoryService.listByChannelId(chaId);
		return new MsgResult(1, "",  categories);
	}
	
}






















