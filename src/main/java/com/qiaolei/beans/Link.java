package com.qiaolei.beans;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

public class Link {
	
	private Integer id;
	
	@Length(max=32,min=5,message="长度超出范围")
	@URL
	private String url;
	@Length(max=10,min=2,message="长度超出范围")	
	private String name;
	private Date created;
	@Override
	public String toString() {
		return "Link [id=" + id + ", url=" + url + ", name=" + name
				+ ", created=" + created + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Link(Integer id, String url, String name, Date created) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.created = created;
	}
	public Link() {
		super();
	}
	
	

}
