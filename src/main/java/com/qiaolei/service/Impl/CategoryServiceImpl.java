package com.qiaolei.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiaolei.beans.Category;
import com.qiaolei.mapper.CategoryMapper;
import com.qiaolei.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper mapper;

	@Override
	public List<Category> getCategoryById(Integer id) {
		return mapper.getCategoryById(id);
	}
	// 联动的代码
	@Override
	public List<Category> listByChannelId(int chaId) {
		// TODO Auto-generated method stub
		return mapper.listByChannelId(chaId);
	}
	
}
