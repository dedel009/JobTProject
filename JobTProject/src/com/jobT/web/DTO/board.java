package com.jobT.web.DTO;

import java.util.Date;

public class board {
	private int num;
	private String title;
	private String content;
	private Date regdate;
	private String nickname;
	private String tag;
	private boolean flag;
	
	public board() {
		
	}
	
	public board(int num, String title, String content, Date regdate, String nickname) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.nickname = nickname;
	}
	
	public board(int num, String title, String content, Date regdate, String nickname, String tag) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.nickname = nickname;
		this.tag = tag;
	}
	
	
	public board(int num, String title, String content, Date regdate, String nickname, boolean flag) {

		this.num = num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.nickname = nickname;
		this.flag = flag;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
