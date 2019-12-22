package com.qiaolei.service.Impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiaolei.StringUtils;
import com.qiaolei.beans.Articel;
import com.qiaolei.beans.Collect;
import com.qiaolei.common.CmcException;
import com.qiaolei.mapper.ArticleMapper;
import com.qiaolei.mapper.CollectMapper;
import com.qiaolei.service.CollectService;


@Service
public class CollectServiceImpl implements CollectService {
	
	@Autowired
	private CollectMapper collectMapper;

	@Autowired
	private ArticleMapper articleMapper;
	
	
	@Override
	public void add(Collect collect) {
		// TODO Auto-generated method stub
		
		
		if(StringUtils.isHttpUrl(collect.getUrl())){
			collectMapper.add(collect);
		}else{
			throw new CmcException("地址不合法");
		}

	}

	// 查询收藏夹列表
	public PageInfo<Articel> getUserArticle(Integer id, Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);	
		return new PageInfo<Articel>(articleMapper.getUserArticle(id));
	}
	
	
	//取消文章的收藏
		@Override
		public int deleteCollect(int id) {
			// TODO Auto-generated method stub
			return articleMapper.deleteCollect(id);
		}
	
	
	
}
