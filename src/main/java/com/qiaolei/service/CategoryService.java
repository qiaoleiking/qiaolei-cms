package com.qiaolei.service;

import java.util.List;

import com.qiaolei.beans.Category;

public interface CategoryService {
	
	/**
	 * 
	    * @Title: getCategoryById
	    * @Description:获取当前频道下的分类
	    * @param @param id
	    * @param @return    参数
	    * @return List<Category>    返回类型
	    * @throws
	 */
	List<Category> getCategoryById(Integer id);
	
	/**
	 * 
	    * @Title: listByChannelId
	    * @Description: 联动的方法
	    * @param @param chaId
	    * @param @return    参数
	    * @return List<Category>返回类型
	    * @throws
	 */
	List<Category> listByChannelId(int chaId);

}






