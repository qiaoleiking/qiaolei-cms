package com.qiaolei.service;

import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.User;

public interface UserService {
		
	/**
	    * @Title: getUserList
	    * @Description: 用户列表
	    * @param @return    参数
	    * @return PageInfo    返回类型
	    * @throws
	 */
	PageInfo getUserList(Integer pageNum, Integer pageSize, String mohu);
	
	/**
	 * 
	    * @Title: getUserById
	    * @Description: 查询用户是否存在
	    * @param @param userId
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	User getUserById(Integer userId);
	
	/**
	 * 
	    * @Title: updateState
	    * @Description: 修改审核状态
	    * @param @param userId
	    * @param @param state
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int updateState(Integer userId, Integer state);

}
