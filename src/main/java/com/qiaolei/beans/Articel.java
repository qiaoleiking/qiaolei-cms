package com.qiaolei.beans;

import java.io.Serializable;
//import java.sql.Date;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
    * @ClassName: Articel
    * @Description: 文章实体类
    * @author Administrator
    * @date 2019年11月14日
    *
 */
@Document(indexName="cms_article",type="articel")
public class Articel implements Serializable{
	
	
	    /**
	    * @Fields serialVersionUID
	    */
	    
	private static final long serialVersionUID = 8492574911218797438L;
	@Id
	private Integer id;
	@Field(analyzer="ik_smart",index=true,store=true,searchAnalyzer="ik_smart",type=FieldType.text)
	private String title;
	@Field(analyzer="ik_smart",index=true,store=true,searchAnalyzer="ik_smart",type=FieldType.text)
	private String content;
	
	//url   text
	private String url;
	private String text;
	
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
	private	String  picture;
	private Integer	channel_id;
	// @JsonIgnore
	private Channel channel;
	///////
	private Integer article_id;
	////
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	private Integer	category_id;
	// @JsonIgnore
	private Category category;
	
	private Integer	user_id;
	// @JsonIgnore
	private User user;
	private int	hits;
	private int hot ;
	private int status;
	private int deleted;
	@JsonIgnore
	private Date created;
	@JsonIgnore
	private Date updated;
	
	private int	commentCnt;
	// @JsonIgnore
	private TypeEnum articleType = TypeEnum.HTML;
	//该文章的所有图片
	// @JsonIgnore
	private List<Image> imgList;
	
	@Override
	public String toString() {
		return "Articel [id=" + id + ", title=" + title + ", content="
				+ content + ", picture=" + picture + ", channel_id="
				+ channel_id + ", channel=" + channel + ", category_id="
				+ category_id + ", category=" + category + ", user_id="
				+ user_id + ", user=" + user + ", hits=" + hits + ", hot="
				+ hot + ", status=" + status + ", deleted=" + deleted
				+ ", created=" + created + ", updated=" + updated
				+ ", commentCnt=" + commentCnt + ", articleType=" + articleType
				+ ", imgList=" + imgList + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public TypeEnum getArticleType() {
		return articleType;
	}
	public void setArticleType(TypeEnum articleType) {
		this.articleType = articleType;
	}
	public List<Image> getImgList() {
		return imgList;
	}
	public void setImgList(List<Image> imgList) {
		this.imgList = imgList;
	}
	
	
	public Articel(Integer id, String title, String content, String picture,
			Integer channel_id, Channel channel, Integer category_id,
			Category category, Integer user_id, User user, int hits, int hot,
			int status, int deleted, Date created, Date updated,
			int commentCnt, TypeEnum articleType, List<Image> imgList) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.channel_id = channel_id;
		this.channel = channel;
		this.category_id = category_id;
		this.category = category;
		this.user_id = user_id;
		this.user = user;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.commentCnt = commentCnt;
		this.articleType = articleType;
		this.imgList = imgList;
	}
	public Articel() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category_id == null) ? 0 : category_id.hashCode());
		result = prime * result
				+ ((channel_id == null) ? 0 : channel_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articel other = (Articel) obj;
		if (category_id == null) {
			if (other.category_id != null)
				return false;
		} else if (!category_id.equals(other.category_id))
			return false;
		if (channel_id == null) {
			if (other.channel_id != null)
				return false;
		} else if (!channel_id.equals(other.channel_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

	
	
}













