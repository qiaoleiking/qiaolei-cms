package com.qiaolei.mapper;

import org.apache.ibatis.annotations.Insert;

import com.qiaolei.beans.Collect;

public interface CollectMapper {
	
	@Insert("INSERT INTO cms_collect(user_id,created,url,text) value(#{user_id},now(),#{url},#{text}) ")
	void add(Collect collect);

}
