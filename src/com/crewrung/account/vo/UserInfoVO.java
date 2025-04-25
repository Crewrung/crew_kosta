package com.crewrung.account.vo;

import java.time.LocalDate;

public class UserInfoVO {
    private String userId;
    private String userPw;
    private String email;
    private String phoneNumber;
    private String nickname;
    private String gender;
    private int guNumber;
    private LocalDate birthDate;
    
    
    public UserInfoVO(){}
    
	public UserInfoVO(String userId) {
		super();
		this.userId = userId;
	}
	
	

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGuNumber() {
		return guNumber;
	}

	public void setGuNumber(int guNumber) {
		this.guNumber = guNumber;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
