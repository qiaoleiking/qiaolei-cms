package com.qiaolei.service;

import com.github.pagehelper.PageInfo;

public interface UserService {
		
	/**
	    * @Title: getUserList
	    * @Description: 用户列表
	    * @param @return    参数
	    * @return PageInfo    返回类型
	    * @throws
	 */
	PageInfo getUserList(Integer pageNum, Integer pageSize, String mohu);

}
