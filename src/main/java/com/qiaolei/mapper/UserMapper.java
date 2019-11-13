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

}
