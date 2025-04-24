package com.crewrung.crew.vo;

public class CrewMeetingVO {
	private String image;
	private String title;
	private String content;
	private String meetingDate;
	private int maxMember;
	private int guNumber;
	private int crewMeetingNumber;
	private int crewNumber;
	private int crewMeetingHostNumber;
	private String guName;
	private String hostName;
	
	public CrewMeetingVO(){}

	public CrewMeetingVO(String image, String title, String content, String meetingDate, int maxMember, int guNumber,
			int crewMeetingNumber, int crewNumber, int crewMeetingHostNumber,String guName, String hostName) {
		this.image = image;
		this.title = title;
		this.content = content;
		this.meetingDate = meetingDate;
		this.maxMember = maxMember;
		this.guNumber = guNumber;
		this.crewMeetingNumber = crewMeetingNumber;
		this.crewNumber = crewNumber;
		this.crewMeetingHostNumber = crewMeetingHostNumber;
		this.guName = guName;
		this.hostName = hostName;
	}
	
	public CrewMeetingVO(String title, String content, String meetingDate, int maxMember,
			int crewNumber, int crewMeetingHostNumber, int guNumber) {
		this(null,title, content, meetingDate, maxMember, guNumber, 0, crewNumber, crewMeetingHostNumber,null,null);
	}
	
	public CrewMeetingVO(String image, String title, String content, String meetingDate, int maxMember, int guNumber,
			int crewMeetingNumber) {
		this(image, title, content, meetingDate, maxMember, guNumber, crewMeetingNumber, 0,0,null,null);
	}
	
	public CrewMeetingVO(String image, String title, String content){
		this(image, title, content, null, 0, 0, 0, 0,0,null,null);
	}
	
	public CrewMeetingVO(String title, String meetingDate, String guName, String hostName){
		this(null, title, null, meetingDate, 0, 0, 0, 0,0,guName,hostName);
	}
	
	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

	public int getMaxMember() {
		return maxMember;
	}

	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	public int getGuNumber() {
		return guNumber;
	}

	public void setGuNumber(int guNumber) {
		this.guNumber = guNumber;
	}

	public int getCrewMeetingNumber() {
		return crewMeetingNumber;
	}

	public void setCrewMeetingNumber(int crewMeetingNumber) {
		this.crewMeetingNumber = crewMeetingNumber;
	}

	public int getCrewNumber() {
		return crewNumber;
	}

	public void setCrewNumber(int crewNumber) {
		this.crewNumber = crewNumber;
	}

	public int getCrewMeetingHostNumber() {
		return crewMeetingHostNumber;
	}

	public void setCrewMeetingHostNumber(int crewMeetingHostNumber) {
		this.crewMeetingHostNumber = crewMeetingHostNumber;
	}

	@Override
	public String toString() {
		return "CrewMeetingVO [image=" + image + ", title=" + title + ", content=" + content + ", meetingDate="
				+ meetingDate + ", maxMember=" + maxMember + ", guNumber=" + guNumber + ", crewMeetingNumber="
				+ crewMeetingNumber + ", crewNumber=" + crewNumber + ", crewMeetingHostNumber=" + crewMeetingHostNumber
				+ ", guName=" + guName + ", hostName=" + hostName + "]";
	}
}
