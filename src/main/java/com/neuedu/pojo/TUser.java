package com.neuedu.pojo;

public class TUser {
	 int userId;
	 String userName;
	 String password;
	 String userSex;//1男0女
	 String delTag;//1正常0删除
	public int getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		return "TUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userSex=" + userSex
				+ ", delTag=" + delTag + "]";
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getDelTag() {
		return delTag;
	}
	public void setDelTag(String delTag) {
		this.delTag = delTag;
	}
	 
}
