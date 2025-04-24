package com.crewrung.account.vo;

import java.util.List;

public class MypageVO {

	private String userId;
	private String profileImage;
	private String nickname;
	private String email;
	private String phoneNumber;
	private String introduction;
	private List<String> crewNames;
	private List<String> flashMobTitles;

	public MypageVO(){}

	public MypageVO(String userId){
		this.userId = userId;
	}

	public MypageVO(String userId, String profileImage) {
		super();
		this.userId = userId;
		this.profileImage = profileImage;
	}

	public MypageVO(String userId, String profileImage, String nickname, String email, String phoneNumber,
			String introduction, List<String> crewNames, List<String> flashMobTitles) {
		super();
		this.userId = userId;
		this.profileImage = profileImage;
		this.nickname = nickname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.introduction = introduction;
		this.crewNames = crewNames;
		this.flashMobTitles = flashMobTitles;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<String> getCrewNames() {
		return crewNames;
	}

	public void setCrewNames(List<String> crewNames) {
		this.crewNames = crewNames;
	}

	public List<String> getFlashMobTitles() {
		return flashMobTitles;
	}

	public void setFlashMobTitles(List<String> flashMobTitles) {
		this.flashMobTitles = flashMobTitles;
	}

	@Override
	public String toString() {
		return "MypageVO [userId=" + userId + ", profileImage=" + profileImage + ", nickname=" + nickname + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", introduction=" + introduction + ", crewNames=" + crewNames
				+ ", flashMobTitles=" + flashMobTitles + "]";
	}


}
