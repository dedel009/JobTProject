package com.jobT.web.DTO;

import java.util.Date;

public class member {
	private String id;
	private String password;
	private String name;
	private String nickname;
	private Date regdate;
	private String category;
	private boolean flag;
	
	
	public member() {
		
	}


	public member(String id, String password, String nickname, String name, String category) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.name = name;
		this.category = category;
	}
	
	public member(String id, String password, String name, String nickname, Date regdate, boolean flag) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.regdate = regdate;
		this.flag = flag;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
