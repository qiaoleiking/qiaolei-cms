package com.qiaolei.beans;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
	
/**
 * 
    * @ClassName: Collect
    * @Description: 收藏夹功能
    * @author Administrator
    * @date 2019年11月24日
    *
 */
public class Collect {
	
	private Integer id;
	private int user_id;
	private int article_id;
	private Date created;
	@Length(max=32,min=5,message="长度超出范围")
	@URL
	private String url;
	private String text;
	@Override
	public String toString() {
		return "Collect [id=" + id + ", user_id=" + user_id + ", article_id="
				+ article_id + ", created=" + created + ", url=" + url
				+ ", text=" + text + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Collect(Integer id, int user_id, int article_id, Date created,
			String url, String text) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.article_id = article_id;
		this.created = created;
		this.url = url;
		this.text = text;
	}
	public Collect() {
		super();
	}
	
	
}











