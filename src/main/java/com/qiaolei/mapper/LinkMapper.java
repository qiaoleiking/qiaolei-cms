package com.qiaolei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qiaolei.beans.Link;

/**
 * 
    * @ClassName: LinkMapper
    * @Description: 友情链接
    * @author Administrator
    * @date 2019年11月23日
    *
 */
public interface LinkMapper {
	/**
	 * 
	    * @Title: add
	    * @Description:友情链接
	    * @param @param link    参数
	    * @return void    返回类型
	    * @throws
	 */
	@Insert("INSERT INTO cms_link (url,name,created) "
			+ " VALUES(#{url},#{name},now())")
	void add(Link link);
	/**
	 * 
	    * @Title: list
	    * @Description:友情链接的链表
	    * @param @return    参数
	    * @return List    返回类型
	    * @throws
	 */
	List list();
	
	@Update("UPDATE cms_link set url=#{url},name=#{name} "
			+ "	WHERE id=#{id}")
	int  update(Link link);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM cms_link WHERE id=#{value} ")
	Link get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE  FROM cms_link WHERE id=#{value} ")
	int delete(int id);
	
	

}
