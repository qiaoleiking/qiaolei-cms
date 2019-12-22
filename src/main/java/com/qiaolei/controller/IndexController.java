package com.qiaolei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.Articel;
import com.qiaolei.beans.Category;
import com.qiaolei.beans.Channel;
import com.qiaolei.beans.Link;
import com.qiaolei.common.ConstantClass;
import com.qiaolei.common.HLUtils;
import com.qiaolei.mapper.ArticlesResp;
import com.qiaolei.service.ArticleService;
import com.qiaolei.service.CategoryService;
import com.qiaolei.service.ChannelService;
import com.qiaolei.service.LinkService;

@Controller
public class IndexController {

	@Autowired
	private ChannelService  ChannelService;
	
	@Autowired
	private CategoryService categoryservice;
	
	@Autowired
	private ArticleService articleservice;
	
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private ArticlesResp articlesResp;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	
	@GetMapping("index")
	public String search(Model model,String key,
			@RequestParam(defaultValue="1")Integer pageNum){
		
	
		//如果pageNum到达0页  使他等于1
		if (pageNum == 0) {
			pageNum = 1;
		}
		
		AggregatedPage<?> selectObjects = HLUtils.selectObjects(elasticsearchTemplate,
				Articel.class,pageNum,3,new String[] {"title"},"id",key);
		
		
		List<Articel> content = (List<Articel>) selectObjects.getContent();
			
		PageInfo<Articel> pageInfo = new PageInfo<Articel>(content);
		
		pageInfo.setPageNum(pageNum); // 当前页
		
		pageInfo.setPageSize(3); // 每页显示多少条
		pageInfo.setTotal(selectObjects.getTotalElements());// 总条数
		
		int totalRecord = (int) selectObjects.getTotalElements();// 数据总条数
		
		int pages = totalRecord % 3 == 0 ? totalRecord / 3
				: totalRecord / 3 + 1; // 数据总条数/3 ? 总页数 : 总页书 + 1
		
		pageInfo.setPages(pages); // 封装总页数
		
		if (pageNum == pages) {// 当前页如果和总页数相等  就把总页数赋值个当前页
			pageNum = pages;
		}
		
		pageInfo.setPrePage(pageNum - 1);  // 上一页
		
 		pageInfo.setNextPage(pageNum + 1); // 下一页

		model.addAttribute("info", pageInfo);
		model.addAttribute("key", key);
//		List<Articel> list = articlesResp.findByTitle(key);
//		PageInfo<Articel> pageInfo = new PageInfo<Articel>(list);
//		model.addAttribute("info", pageInfo);
		
		
		List<Channel> list = ChannelService.getChannelList();
		model.addAttribute("list", list);
		
		List<Articel> articellist = articleService.getNewArticel(5);
		model.addAttribute("articellist", articellist);
		
		List<Articel> imgArticles = articleService.getImgArticles(10);
		model.addAttribute("imgArticles", imgArticles);
		
		return "index";
		
	}
	
	
	@RequestMapping(value= {"index","/"})
	public String index(Model m,@RequestParam(defaultValue="1")Integer pageNum){

		List<Channel> list = ChannelService.getChannelList();
		m.addAttribute("list", list);
		
		
		PageInfo<Articel> info = articleService.hotList(pageNum);	
		
		List<Articel> articellist = articleService.getNewArticel(5);
		m.addAttribute("info", info);
		m.addAttribute("articellist", articellist);
		//友情链接
		PageInfo linklist = linkService.list(1);
		m.addAttribute("linklist", linklist);
		
		
		// 获取最新图片文章
		List<Articel> imgArticles = articleService.getImgArticles(10);
		m.addAttribute("imgArticles", imgArticles);
		return "index";
	}
	
	
	
	@RequestMapping("indexchn")
	public String indexchn(Model m,Integer id,@RequestParam(defaultValue="1")Integer pageNum
			,@RequestParam(defaultValue = "0") int categoryId
			){
		
		m.addAttribute("id",id);
		m.addAttribute("categoryId",categoryId);
		
		//获取所有的频道
		List<Channel> list = ChannelService.getChannelList();
		m.addAttribute("list", list);
		
		PageInfo<Articel> info = articleService.hotList(pageNum);
		m.addAttribute("info", info);
		
		List<Articel> articellist = articleService.getNewArticel(5);
		m.addAttribute("articellist", articellist);
		
		//频道下所有分类
		List<Category> categoryList = categoryservice.getCategoryById(id);
		m.addAttribute("categoryList", categoryList);

		
		PageInfo artList = articleservice.getArticelById(id,categoryId,pageNum);
		m.addAttribute("artList", artList);
		
		//友情链接
		PageInfo linklist = linkService.list(1);
		m.addAttribute("linklist", linklist);
		
		
		// 获取最新图片文章
		List<Articel> imgArticles = articleService.getImgArticles(10);
		m.addAttribute("imgArticles", imgArticles);
		
		return "index_type";
	}
}






