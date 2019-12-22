package com.qiaolei.MyListener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.qiaolei.beans.Articel;
import com.qiaolei.mapper.ArticleMapper;
import com.qiaolei.mapper.ArticlesResp;
@SuppressWarnings("all")
public class MsgListener implements MessageListener<String,String>{
	

	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private ArticlesResp articlesResp;
	
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		
		String jsonString = data.value();
		
		if(jsonString.startsWith("update")){//修改
			//判断是否是卡发卡发送来的修改的消息  来进行次逻辑的操作
			redisTemplate.delete("rangeList");
			String[] split = jsonString.split("=");			
			articlesResp.save(JSON.parseObject(split[1],Articel.class));
			
		}else if(jsonString.startsWith("del")){//删除
			System.err.println(jsonString);
			redisTemplate.delete("rangeList");	
			String[] split = jsonString.split("=");	
			articlesResp.deleteById(Integer.parseInt(split[1]));
		}else if(jsonString.startsWith("add")){
			System.err.println(jsonString);
			redisTemplate.delete("rangeList");	
			
			String[] split = jsonString.split("=");	
			articlesResp.save(JSON.parseObject(split[1],Articel.class));
			
		}else{
			System.err.println("接收到消息");
			Articel articel = JSON.parseObject(jsonString,Articel.class);
			articleMapper.add(articel);
		}

	}
}





