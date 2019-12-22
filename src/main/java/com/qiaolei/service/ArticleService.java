package com.qiaolei.service;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.log4j.chainsaw.Main;

import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.Articel;

public interface ArticleService {
	/**
	 * 
	    * @Title: hotList
	    * @Description: 最火文章
	    * @param @param pageNum
	    * @param @return    参数
	    * @return PageInfo<Articel>    返回类型
	    * @throws
	 */
	PageInfo<Articel> hotList(Integer pageNum);
	/**
	 * 
	    * @Title: getNewArticel
	    * @Description:最新文章
	    * @param @param i
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	List<Articel> getNewArticel(int i);
	
	/**
	 * 
	    * @Title: getArticleContent
	    * @Description: 获取文章内容
	    * @param @param id
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	Articel getArticleContent(Integer id);
	
	/**
	 * 
	    * @Title: getArticelById
	    * @Description: 获取单前栏目的文章列表
	    * @param @param id
	    * @param @param categoryId
	    * @param @param pageNum
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	PageInfo getArticelById(Integer id, int categoryId, Integer pageNum);
	/**
	 * 
	    * @Title: listByUser
	    * @Description: 获取文章列表
	    * @param @param pageNum
	    * @param @param id
	    * @param @return    参数
	    * @return PageInfo    返回类型
	    * @throws
	 */
	PageInfo listByUser(Integer pageNum, Integer id);
	/**
	 * 
	    * @Title: checkExist
	    * @Description: 验证是否有文章
	    * @param @param id
	    * @param @return    参数
	    * @return Articel    返回类型
	    * @throws
	 */
	Articel checkExist(Integer id);
	/**
	 * 
	    * @Title: delete
	    * @Description:用户删除文章
	    * @param @param id
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int delete(Integer id);
	
	/**
	 * 
	    * @Title: getArticlesPageList
	    * @Description: 管理员获取全部的文章
	    * @param @param status
	    * @param @param pageNum
	    * @param @return    参数
	    * @return PageInfo<Articel>    返回类型
	    * @throws
	 */
	PageInfo<Articel> getArticlesPageList(int status, Integer pageNum);
	
	/**
	 * 
	    * @Title: getDetailB1yId
	    * @Description: 获取需要审核的文章
	    * @param @param id
	    * @param @return    参数
	    * @return Articel    返回类型
	    * @throws
	 */
	Articel getDetailB1yId(int id);
	
	/**
	 * 
	    * @Title: apply
	    * @Description: 修改审核状态
	    * @param @param id
	    * @param @param status
	    * @param @return    参数
	    * @return int   返回类型
	    * @throws
	 */
	int apply(int id, int status);
	
	/**
	 * 
	    * @Title: setHot
	    * @Description: 设置热门
	    * @param @param id
	    * @param @param status
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int setHot(int id, int status);
	/**
	 * 
	    * @Title: add
	    * @Description: 发表文章
	    * @param @param article
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int add(Articel article);
	/**
	 * 
	    * @Title: update
	    * @Description: 修改文章
	    * @param @param articel
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int update(Articel articel);
	
	/**
	 * 
	    * @Title: collect
	    * @Description: 收藏文章的方法
	    * @param @param id
	    * @param @param id2
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int collect(int id, Integer id2);
	/**
	 * @param pageNum 
	 * 
	    * @Title: getUserArticle
	    * @Description: 获取当前用户的全部文章
	    * @param @param id
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	PageInfo<Articel> getUserArticle(Integer id, Integer pageNum);
	/**
	 * 
	    * @Title: deleteCollect
	    * @Description: 取消文章的收藏
	    * @param @param id
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int deleteCollect(int id);
	
	/**
	 * 
	    * @Title: getImgArticles
	    * @Description: 图片文章
	    * @param @param num
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	List<Articel> getImgArticles(int num);

}
