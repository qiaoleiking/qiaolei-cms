package com.qiaolei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiaolei.beans.Category;

public interface CategoryMapper {
	/**
	 * 
	    * @Title: getCategoryById
	    * @Description: 获取频道下的分类
	    * @param @param id
	    * @param @return    参数
	    * @return List<Category>    返回类型
	    * @throws
	 */
	List<Category> getCategoryById(@Param("id")Integer id);
	/**
	 * 
	    * @Title: listByChannelId
	    * @Description:联动的代码	
	    * @param @param chaId
	    * @param @return    参数
	    * @return List<Category>    返回类型
	    * @throws
	 */
	List<Category> listByChannelId(@Param("chaId")int chaId);

}
