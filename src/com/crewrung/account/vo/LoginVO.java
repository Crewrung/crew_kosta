package com.crewrung.account.vo;

public class LoginVO {
	
	private String userId;
	private String userPw;
	private String nickname;
	
	public LoginVO(){}
	
	
	public LoginVO(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}
	
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
}