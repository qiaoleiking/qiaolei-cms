package com.qiaolei.beans;

import java.io.Serializable;
import java.util.Date;

import com.qiaolei.common.ConstantClass;

/*
 * 
    * @ClassName: User
    * @Description:用户实体类
    * @author Administrator
    * @date 2019年11月13日
    *
 */
public class User implements Serializable{
	
	
	
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	
	private Date birthday;
	private Integer gender;
	private Integer locked;
	
	private Date create_time;
	private Date update_time;
	
	private String url;
	private Integer score;	
	private Integer role = ConstantClass.USER_ROLE_GENERAL;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String nickname,
			Date birthday, Integer gender, Integer locked, Date create_time,
			Date update_time, String url, Integer score, Integer role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.gender = gender;
		this.locked = locked;
		this.create_time = create_time;
		this.update_time = update_time;
		this.url = url;
		this.score = score;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", birthday="
				+ birthday + ", gender=" + gender + ", locked=" + locked
				+ ", create_time=" + create_time + ", update_time="
				+ update_time + ", url=" + url + ", score=" + score + ", role="
				+ role + "]";
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
