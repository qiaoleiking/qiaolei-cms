package com.qiaolei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiaolei.beans.User;

public interface UserMapper {
	
	/**
	 * 
	    * @Title: getUserList
	    * @Description: 获取用户列表
	    * @param @param mohu
	    * @param @return    参数
	    * @return List<User>    返回类型
	    * @throws
	 */
	List<User> getUserList(@Param("mohu")String mohu);
	/**
	 * 
	    * @Title: getUserById
	    * @Description: 根据Id查询是否有用户
	    * @param @param userId
	    * @param @return    参数
	    * @return User    返回类型
	    * @throws
	 */
	User getUserById(@Param("userId")Integer userId);
	/**
	 * 
	    * @Title: updateState
	    * @Description:修改审核状态
	    * @param @param userId
	    * @param @param state
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int updateState(@Param("userId")Integer userId, @Param("state")Integer state);

}
