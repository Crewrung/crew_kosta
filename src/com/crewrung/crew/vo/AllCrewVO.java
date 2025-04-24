 package com.crewrung.crew.vo;

public class AllCrewVO {
	private int crewNumber;
	private String crewName;
	private String introduction;
	private String interestCategory;
	private String image;
	private String guName;
	private int crewMembersCount;
	
	public AllCrewVO(){}
	public AllCrewVO(int crewNumber, String crewName, String introduction, String interestCategory, String image,
			String guName, int crewMembersCount) {
		super();
		this.crewNumber = crewNumber;
		this.crewName = crewName;
		this.introduction = introduction;
		this.interestCategory = interestCategory;
		this.image = image;
		this.guName = guName;
		this.crewMembersCount = crewMembersCount;
	}
	
	public int getCrewNumber() {
		return crewNumber;
	}
	public void setCrewNumber(int crewNumber) {
		this.crewNumber = crewNumber;
	}
	public String getCrewName() {
		return crewName;
	}
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getInterestCategory() {
		return interestCategory;
	}
	public void setInterestCategory(String interestCategory) {
		this.interestCategory = interestCategory;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGuName() {
		return guName;
	}
	public void setGuName(String guName) {
		this.guName = guName;
	}
	public int getCrewMembersCount() {
		return crewMembersCount;
	}
	public void setCrewMembersCount(int crewMembersCount) {
		this.crewMembersCount = crewMembersCount;
	}

	@Override
	public String toString() {
		return "GetAllCrewVO [crewNumber=" + crewNumber + ", crewName=" + crewName + ", introduction=" + introduction
				+ ", interestCategory=" + interestCategory + ", image=" + image + ", guName=" + guName
				+ ", crewMembersCount=" + crewMembersCount + "]";
	}
	
}

