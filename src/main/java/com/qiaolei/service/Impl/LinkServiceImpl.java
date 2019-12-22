package com.qiaolei.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiaolei.StringUtils;
import com.qiaolei.beans.Link;
import com.qiaolei.common.CmcException;
import com.qiaolei.mapper.LinkMapper;
import com.qiaolei.service.LinkService;
@Service
public class LinkServiceImpl implements LinkService {
	
	@Autowired
	private LinkMapper mapper;
	
	// 添加一个友情链接
	@Override
	public void add(Link link) {
		
		boolean httpUrl = StringUtils.isHttpUrl(link.getUrl());
		if(httpUrl){
			mapper.add(link);
		}else{
			throw new CmcException("您收藏的链接不合法");
		}
		
		
	}
	
	
	// 友情链接集合
	@Override
	public PageInfo list(int pageNum) {
		// TODO Auto-generated method stub
		//排序查询且限定返回条数的方法
		PageHelper.startPage(pageNum,10);
		
		return new PageInfo(mapper.list());
	}
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public Link get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public int update(Link link) {
		// TODO Auto-generated method stub
		return mapper.update(link);
		
	}
	
}
