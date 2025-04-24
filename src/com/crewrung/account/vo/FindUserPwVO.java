package com.crewrung.account.vo;

public class FindUserPwVO {
	private String userId;
	private String email;
	
	public FindUserPwVO(){}
	
	
	
	public FindUserPwVO(String userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserPwFindVO [userId=" + userId + ", email=" + email + "]";
	}
	
	

	
	
	
	
	
	
}
