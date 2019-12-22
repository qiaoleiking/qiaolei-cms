package com.qiaolei.mapper;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qiaolei.beans.Articel;

public interface ArticlesResp extends ElasticsearchRepository<Articel,Integer>{

	/*void findAll(List<Articel> articleList);*/

	//List<Articel> getArticleList();
	
	List<Articel> findByTitle(String key);
}
