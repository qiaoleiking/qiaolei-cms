package com.qiaolei.link;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.qiaolei.beans.Link;
import com.qiaolei.service.LinkService;


@ContextConfiguration("classpath:spring-beans.xml")
@RunWith(SpringRunner.class)
public class LinkTest {
	
	@Autowired
	private LinkService linkService;
	
	@Test
	public void add(){
		
		Link link = new Link(0,"http:","",null);
		linkService.add(link);
		
	}
	
	@Test
	public void addTo(){
		
		Link link = new Link(0,"aaa:","",null);
		linkService.add(link);
		
	}
	
	
	@Test
	public void list(){
		
		
		PageInfo list = linkService.list(3);
		System.out.println(list);
	}
	
}





