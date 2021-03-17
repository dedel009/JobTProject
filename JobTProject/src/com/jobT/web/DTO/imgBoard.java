package com.jobT.web.DTO;

import java.util.Date;

public class imgBoard {
	private String id;
	private String name;
	private String content;
	private String category;
	private int price;
	private Date regdate;
	private String delFlag;
	private String path;
	
	@Override
	public String toString() {
		return "imgBoard [id=" + id + ", name=" + name + ", content=" + content + ", category=" + category + ", price="
				+ price + ", regdate=" + regdate + ", delFlag=" + delFlag + ", path=" + path + "]";
	}
	public imgBoard() {

	}
	

	public imgBoard(String id, String name, String content, String category, int price, Date regdate, String delFlag,
			String path) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.category = category;
		this.price = price;
		this.regdate = regdate;
		this.delFlag = delFlag;
		this.path = path;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
