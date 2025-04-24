package com.crewrung.crew.vo;

public class CrewMeetingParticipantVO {
	private String profileImage;
	private String name;
	private String nickname;
	
	public CrewMeetingParticipantVO(){}
	public CrewMeetingParticipantVO(String profileImage, String name, String nickname) {
		this.profileImage = profileImage;
		this.name = name;
		this.nickname = nickname;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "ReadCrewMeetingParticipantsVO [profileImage=" + profileImage + ", name=" + name + ", nickname="
				+ nickname + "]";
	}
}
