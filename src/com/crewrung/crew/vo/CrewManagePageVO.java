package com.crewrung.crew.vo;

public class CrewManagePageVO {
	private String profileImage;
	private String nickname;
	private int age;
	private String gender;
	private String city;
	private String introduction;
	private String memberId;
	
	public CrewManagePageVO(){}

	public CrewManagePageVO(String profileImage, String nickname, int age, String gender, String city,
			String introduction, String memberId) {
		super();
		this.profileImage = profileImage;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.introduction = introduction;
		this.memberId = memberId;
	}

	public CrewManagePageVO(String profileImage, String nickname, int age, String gender, String city,
			String memberId) {
		super();
		this.profileImage = profileImage;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.memberId = memberId;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getIntroduction() {
		return introduction;
	}


	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "CrewManagePageVO [profileImage=" + profileImage + ", nickname=" + nickname + ", age=" + age
				+ ", gender=" + gender + ", city=" + city + ", introduction=" + introduction + ", memberId=" + memberId
				+ "]";
	}
	
}
	

