package com.qiaolei.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.Link;
/*
 * 
    * @ClassName: LinkService
    * @Description: 友情链接
    * @author Administrator
    * @date 2019年11月23日
    *
 */
public interface LinkService {

	/**
	 * 
	    * @Title: add
	    * @Description: 添加一个友情链接
	    * @param @param link    参数
	    * @return void    返回类型
	    * @throws
	 */
	void add(Link link);
	/**
	 * 
	    * @Title: list
	    * @Description: 友情链表功能
	    * @param @param pageNum
	    * @param @return    参数
	    * @return PageInfo    返回类型
	    * @throws
	 */
	PageInfo list(int pageNum);

	/**
	 * 	
	    * @Title: delete
	    * @Description: 删除
	    * @param @param id
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int delete(int id);
	/**
	 * 
	    * @Title: get
	    * @Description: 回显
	    * @param @param id
	    * @param @return    参数
	    * @return Link    返回类型
	    * @throws
	 */
	Link get(int id);
	/**
	 * 
	    * @Title: get
	    * @Description: 修改
	    * @param @param id
	    * @param @return    参数
	    * @return Link    返回类型
	    * @throws
	 */
	int update( Link link);
}
