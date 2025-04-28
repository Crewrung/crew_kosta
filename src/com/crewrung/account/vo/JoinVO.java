package com.crewrung.account.vo;

import java.time.LocalDate;

public class JoinVO {
	
	private String userId;
	private String userPw;
	private String userPwCheck;
	private String name;
	private String email;
	private String phoneNumber;
	private String nickname;
	private String gender;
	private String guName;
	private int guNumber;
	private String question;
	private String answer;
	private String birthDate;
	private String introduction;
	private String profileImage;
	
	public JoinVO(){}

	
	
	
	public String getUserPwCheck() {
		return userPwCheck;
	}

	public void setUserPwCheck(String userPwCheck) {
		this.userPwCheck = userPwCheck;
	}

	public String getGuName() {
		return guName;
	}
	public void setGuName(String guName) {
		this.guName = guName;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
}
