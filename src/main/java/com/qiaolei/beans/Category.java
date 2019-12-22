package com.qiaolei.beans;

import java.io.Serializable;

/**
 * 
    * @ClassName: Category
    * @Description: 文章的分类
    * @author Administrator
    * @date 2019年11月14日
    *
 */
public class Category implements Serializable{
	
	
	
	
	    /**
	    * @Fields serialVersionUID : 
	    */
	    
	private static final long serialVersionUID = 2591188771348930129L;
	
	private Integer id;
	private String name;
	private int channel_id;
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channel_id="
				+ channel_id + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}
	
	
	
	public Category(Integer id, String name, int channel_id) {
		super();
		this.id = id;
		this.name = name;
		this.channel_id = channel_id;
	}
	public Category() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
