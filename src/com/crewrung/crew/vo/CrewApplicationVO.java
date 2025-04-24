package com.crewrung.crew.vo;

public class CrewApplicationVO {
	private int crewNumber;
	private String userId;
	private String introduction;
	
	public CrewApplicationVO(){}
	public CrewApplicationVO(int crewNumber, String userId, String introduction) {
		super();
		this.crewNumber = crewNumber;
		this.userId = userId;
		this.introduction = introduction;
	}
	public int getCrewNumber() {
		return crewNumber;
	}
	public void setCrewNumber(int crewNumber) {
		this.crewNumber = crewNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "CrewApplicationVO [crewNumber=" + crewNumber + ", userId=" + userId + ", introduction=" + introduction
				+ "]";
	}

	
}
