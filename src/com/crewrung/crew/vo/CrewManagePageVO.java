package com.crewrung.crew.vo;

public class CrewManagePageVO {
	private String profileImage;
	private String nickname;
	private int age;
	private String gender;
	private String city;
	private String introduction;
	
	
	public CrewManagePageVO(){}
	//农风 包府其捞瘤 炼雀(农风啊涝脚没磊)阑 困茄 积己磊
	public CrewManagePageVO(String profileImage, String nickname, int age, String gender, String city,
			String introduction) {
		super();
		this.profileImage = profileImage;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.introduction = introduction;
	}
	
	//农风 包府其捞瘤 炼雀(农风盔)阑 困茄 积己磊
	public CrewManagePageVO(String profileImage, String nickname, int age, String gender, String city) {
		this(profileImage, nickname, age, gender, city, null);
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

	@Override
	public String toString() {
		return "CrewManagePageVO [profileImage=" + profileImage + ", nickname=" + nickname + ", age=" + age
				+ ", gender=" + gender + ", city=" + city + ", introduction=" + introduction + "]";
	}

}
