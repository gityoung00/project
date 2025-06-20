package com.example.vo;

public class UserVO {

	private String userID;
	private String userPW;

	public UserVO() {
		super();
	}

	public UserVO(String userID, String userPW) {
		super();
		this.userID = userID;
		this.userPW = userPW;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

}
