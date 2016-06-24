package com.xhly.godutch.model;

import java.util.Date;

public class User {
	// 用户ID
	private int userID;
	// 用户名称
	private String userName;
	// 添加日期
	private Date createDate = new Date();
	// 状态0失效1启用
	private int state = 1;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String userName, Date createDate, int state) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.createDate = createDate;
		this.state = state;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", createDate=" + createDate + ", state=" + state + "]";
	}

}
