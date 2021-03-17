package com.jobT.web.DTO;

import java.util.Date;

public class commentDTO {
	private int wid;
	private String id;
	private String comment;
	private int score;
	private Date regdate;
	private String userID;
	private String delFlag;
	
	@Override
	public String toString() {
		return "commentDTO [wid=" + wid + ", id=" + id + ", commet=" + comment + ", score=" + score + ", regdate="
				+ regdate + ", userID=" + userID + ", delFlag=" + delFlag + "]";
	}

	
	
	public commentDTO(String id, String commet, int score, String userID) {
		this.id = id;
		this.comment = commet;
		this.score = score;
		this.userID = userID;
	}



	public commentDTO(int wid, String id, String commet, int score, Date regdate, String userID, String delFlag) {
		this.wid = wid;
		this.id = id;
		this.comment = commet;
		this.score = score;
		this.regdate = regdate;
		this.userID = userID;
		this.delFlag = delFlag;
	}
	
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String commet) {
		this.comment = commet;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	
}
