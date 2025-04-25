package com.crewrung.flashMob.vo;

import java.sql.Date;

public class FlashMobMainViewVO {
	private int flashMobNumber;
    private String title;
    private String content;
    private String interestCategory;
    private String guName;
    private int participantCount;
    private int maxMember;
    private String image;
    private Date meetingDate;
    
    public FlashMobMainViewVO(){
    }
    
	public FlashMobMainViewVO(int flashMobNumber, String title, String content, String interestCategory, String guName,
			int participantCount, int maxMember, Date meetingDate, String image) {
		this.flashMobNumber = flashMobNumber;
		this.title = title;
		this.content = content;
		this.interestCategory = interestCategory;
		this.guName = guName;
		this.participantCount = participantCount;
		this.maxMember = maxMember;
		this.meetingDate = meetingDate;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getFlashMobNumber() {
		return flashMobNumber;
	}

	public void setFlashMobNumber(int flashMobNumber) {
		this.flashMobNumber = flashMobNumber;
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

	public String getInterestCategory() {
		return interestCategory;
	}

	public void setInterestCategory(String interestCategory) {
		this.interestCategory = interestCategory;
	}

	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	public int getParticipantCount() {
		return participantCount;
	}

	public void setParticipantCount(int participantCount) {
		this.participantCount = participantCount;
	}

	public int getMaxMember() {
		return maxMember;
	}

	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	@Override
	public String toString() {
		return "FlashMobMainViewVO [flashMobNumber=" + flashMobNumber + ", title=" + title + ", content=" + content
				+ ", interestCategory=" + interestCategory + ", guName=" + guName + ", participantCount="
				+ participantCount + ", maxMember=" + maxMember + ", meetingDate=" + meetingDate + "]";
	}
    
}
