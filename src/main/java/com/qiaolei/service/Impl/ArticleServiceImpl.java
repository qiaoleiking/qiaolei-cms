package com.qiaolei.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.Articel;
import com.qiaolei.mapper.ArticleMapper;
import com.qiaolei.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper mapper;

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public PageInfo<Articel> hotList(Integer pageNum) {
		//1.从redis中查询热点文章
	//	PageHelper.startPage(pageNum,3);
		List<Articel> rangeList = redisTemplate.opsForList().range("rangeList",0,-1);
		//2:判断redis是否为空
		if(rangeList != null && rangeList.size()>0){
			//3.如果非空直接返回给web层
			System.err.println("从redis中查询了热点文章....");
			return new PageInfo<Articel>(rangeList);
		}		
		//4.如果为空,从mysql中查询数据,添加到reidis,并返回给web层
		List<Articel> list = mapper.hotList();	
		System.err.println("从mysql中查询了热点文章....");
		redisTemplate.opsForList().leftPushAll("rangeList", list.toArray());
		return new PageInfo<Articel>(list);
	}

	@Override
	public List<Articel> getNewArticel(int i) {
		// TODO Auto-generated method stub
		return mapper.getNewRrticel(i);
	}

	@Override
	public Articel getArticleContent(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getArticleContent(id);
	}

	@Override
	public PageInfo getArticelById(Integer id, int categoryId,
			Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);
		List<Articel> articelList = mapper.getArticelById(id,categoryId);
		PageInfo info = new PageInfo(articelList);
		return info;
	}
	//获取文章列表
	@Override
	public PageInfo listByUser(Integer pageNum, Integer id) {
		
		PageHelper.startPage(pageNum, 4);
		List<Articel> list = mapper.listByUser(id);
		PageInfo info = new PageInfo(list);
		return info;
	}
	
	// 验证是否有文章
	@Override
	public Articel checkExist(Integer id) {
		
		return mapper.checkExist(id);
	}
	
	//用户删除文章
	@Override
	public int delete(Integer id) {
	
		return mapper.delete(id);
	}

	@Override
	public PageInfo<Articel> getArticlesPageList(int status, Integer pageNum) {
		PageHelper.startPage(pageNum, 5);
		return new PageInfo<Articel>(mapper.getArticlesPageList(status));
	}

	@Override
	public Articel getDetailB1yId(int id) {
		// TODO Auto-generated method stub
		return mapper.getDetailB1yId(id);
	}
	
	//修改审核状态
	@Override
	public int apply(int id, int status) {
		// TODO Auto-generated method stub
		return mapper.apply(id,status);
	}

	@Override
	public int setHot(int id, int status) {
		// TODO Auto-generated method stub
		return mapper.setHot(id,status);
	}

	@Override
	public int add(Articel article) {
		// TODO Auto-generated method stub
		return mapper.add(article);
	}

	@Override
	public int update(Articel articel) {
		// TODO Auto-generated method stub
		return mapper.update(articel);
	}
	//收藏文章
	@Override
	public int collect(int id, Integer uid) {
		// TODO Auto-generated method stub
		return mapper.collect(uid,id);
	}
	
	
	/**
	 * 收藏夹模块的
	 */
	//获取当前用户的文章
	@Override
	public PageInfo<Articel> getUserArticle(Integer id, Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);	
		return new PageInfo<Articel>(mapper.getUserArticle(id));
	}
	//取消文章的收藏
	@Override
	public int deleteCollect(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteCollect(id);
	}
	//图片文章
	@Override
	public List<Articel> getImgArticles(int num) {
		// TODO Auto-generated method stub
		return mapper.getImgArticles(num);
	}

}
