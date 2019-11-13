package com.qiaolei.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.User;
import com.qiaolei.mapper.UserMapper;
import com.qiaolei.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	// 用户列表
	@Override
	public PageInfo getUserList(Integer pageNum, Integer pageSize, String mohu) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<User> user = mapper.getUserList(mohu);
		PageInfo info = new PageInfo(user);
		return info;
	}

	@Override
	public User getUserById(Integer userId) {
		
		return mapper.getUserById(userId);
	}

	@Override
	public int updateState(Integer userId, Integer state) {
		// TODO Auto-generated method stub
		return mapper.updateState(userId,state);
	}
	
	
}







