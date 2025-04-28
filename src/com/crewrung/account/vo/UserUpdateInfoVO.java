package com.crewrung.account.vo;

public class UserUpdateInfoVO {
	
	private String userId;
    private String userPw; 
    private String userPwCheck;
    private String email; 
    private String phoneNumber;  
    private String nickname;
    private int guNumber;
    private String guName;
    private String birthDate;
    private String introduction;
    
    
	public UserUpdateInfoVO(){}


	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getGuNumber() {
		return guNumber;
	}

	public void setGuNumber(int guNumber) {
		this.guNumber = guNumber;
	}
	public String getUserPwCheck() {
		return userPwCheck;
	}
	public void setUserPwCheck(String userPwCheck) {
		this.userPwCheck = userPwCheck;
	}

	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getGuName() {
		return guName;
	}


	public void setGuName(String guName) {
		this.guName = guName;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	




}
