package com.qiaolei.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.User;
import com.qiaolei.common.CmsAssert;
import com.qiaolei.common.Md5;
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
	
	// 判断是否有此用户名
	public User findByName(String username) {
		
		return mapper.findByName(username);
	}
	
	
	//注册用户
	@Override
	public int register(User user) {
		//判断用户是否存在
		System.out.println(user);
		User existUser = findByName(user.getUsername());
		CmsAssert.AssertTrue(existUser==null, "该用户以注册");
		
		
		//密码加盐
		user.setPassword(Md5.password(user.getPassword(), user.getUsername().substring(0, 2)));
		return mapper.add(user);
	}
	
	// 用户登录
	@Override
	public User login(User user) {
		
		// 验证姓名是否存在
		User loginUser = findByName(user.getUsername());
		if(loginUser == null ){
			return null;
		}
		
		// 计算加密后的密码
		String passwordMd5 = Md5.password(user.getPassword(), user.getUsername().substring(0,2));
		
		if(passwordMd5.equals(loginUser.getPassword())){
			return loginUser;
		}else{
		     return null;
		}
	}

	
	
	
}







