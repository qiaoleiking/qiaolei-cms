package com.qiaolei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qiaolei.beans.Articel;

public interface ArticleMapper {
	
	/*
	 * 获取热门文章
	 */
	List<Articel> hotList();

	/*
	 * 获取最新文章
	 */
	List<Articel> getNewRrticel(@Param("i")int i);
	
	/**
	 * 
	    * @Title: getArticleContent
	    * @Description: 获取文章内容
	    * @param @param id
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	Articel getArticleContent(@Param("id")Integer id);
	
	/**
	 * 
	    * @Title: getArticelById
	    * @Description: 获取单前栏目的文章
	    * @param @param id
	    * @param @param categoryId
	    * @param @param pageNum
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	List<Articel> getArticelById(@Param("id")Integer id,@Param("categoryId")int categoryId);
	
	/**
	 * 
	    * @Title: listByUser
	    * @Description: 获取文章列表
	    * @param @param id
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	List<Articel> listByUser(@Param("id")Integer id);
	/**
	 * 
	    * @Title: checkExist
	    * @Description: 验证是否有文章
	    * @param @param id
	    * @param @return    参数
	    * @return Articel    返回类型
	    * @throws
	 */
	Articel checkExist(@Param("id")Integer id);
	/**
	 * 
	    * @Title: delete
	    * @Description: 用户删除文章
	    * @param @param id
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	@Update(" UPDATE cms_article SET  deleted=1 WHERE id=${id} ")
	int delete(@Param("id")Integer id);
	
	
	/**
	 * 
	    * @Title: getArticlesPageList
	    * @Description: 管理员获取全部文章
	    * @param @param status
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	List<Articel> getArticlesPageList(@Param("status")int status);
	/**
	 * 
	    * @Title: getDetailB1yId
	    * @Description: 获取需要审核的文章
	    * @param @param id
	    * @param @return    参数
	    * @return Articel    返回类型
	    * @throws
	 */
	Articel getDetailB1yId(@Param("id")int id);
	/**
	 * 
	    * @Title: apply
	    * @Description:修改审核状态
	    * @param @param id
	    * @param @param status
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	@Update(" UPDATE cms_article SET  status=${status} "
			+ " WHERE id=${id} ")
	int apply(@Param("id")int id,@Param("status") int status);
	
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
	@Update(" UPDATE cms_article SET  hot=#{status} "
			+ " WHERE id=#{id} ")
	int setHot(@Param("id")int id, @Param("status")int status);
	/**
	 * 
	    * @Title: add
	    * @Description:发表文章
	    * @param @param article
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	int add(Articel article);
	/**
	 * 
	    * @Title: update
	    * @Description:修改文章
	    * @param @param articel
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	@Update("UPDATE cms_article SET title=#{title},content=#{content},"
			+ "picture=#{picture},channel_id=#{channel_id},"
			+ "category_id=#{category_id},status=0,updated=now() WHERE id=#{id}")
	int update(Articel articel);
	/**
	 * 
	    * @Title: collect
	    * @Description: 收藏成功
	    * @param @param uid
	    * @param @param id
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	@Insert("REPLACE cms_collect(user_id,article_id,created)"
			+ " values(${uid},${id},now())")
	int collect(@Param("uid")Integer uid, @Param("id")int id);
	/**
	 * 
	    * @Title: getUserArticle
	    * @Description:获取当前用户的文章
	    * @param @param id
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	@Select("select * from cms_collect a LEFT JOIN "
			+ "cms_article b on a.article_id = b.id where a.user_id = ${id}")
	@ResultMap("artitcelMap")
	List<Articel> getUserArticle(@Param("id")Integer id);
	/**
	 * 
	    * @Title: deleteCollect
	    * @Description: 取消文章的收藏
	    * @param @param id
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	@Delete("DELETE FROM cms_Collect where id = ${id}")
	int deleteCollect(@Param("id")int id);
	/**
	 * 
	    * @Title: getImgArticles
	    * @Description:获取图片文章
	    * @param @param num
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	List<Articel> getImgArticles(int num);
	/**
	 * 
	    * @Title: getArticleList
	    * @Description: 查询mysql数据库中的文章列表
	    * @param @return    参数
	    * @return List<Articel>    返回类型
	    * @throws
	 */
	List<Articel> getArticleList();
	
}




