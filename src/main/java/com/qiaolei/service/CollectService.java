package com.qiaolei.service;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.Articel;
import com.qiaolei.beans.Collect;

public interface CollectService {
	/**
	 * 
	    * @Title: add
	    * @Description: 添加网络文章收藏
	    * @param @param collect    参数
	    * @return void    返回类型
	    * @throws
	 */
	void add(Collect collect);
	/**
	 * 
	    * @Title: getUserArticle
	    * @Description:收藏夹
	    * @param @param id
	    * @param @param pageNum
	    * @param @return    参数
	    * @return PageInfo<Articel>    返回类型
	    * @throws
	 */
	PageInfo<Articel> getUserArticle(Integer id, Integer pageNum);
	
	/**
	 * 
	    * @Title: deleteCollect
	    * @Description: 取消收藏
	    * @param @param id
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int deleteCollect(int id);
	
	
	

}
