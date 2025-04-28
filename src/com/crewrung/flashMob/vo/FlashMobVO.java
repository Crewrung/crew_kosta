package com.crewrung.flashMob.vo;

import java.sql.Date;

public class FlashMobVO {
	private int flashMobNumber;
	private String flashMobHostId;
    private String title;
    private String content;
    private String interestCategory;
    private String ageRange;
    private int maxMember;
    private Date meetingDate;
    private String image;
    private int guNumber;
    
    public FlashMobVO() {
    	
    }
    
    public FlashMobVO(String flashMobHostId, String title, String content, String interestCategory,
			String ageRange, int maxMember, Date meetingDate, int guNumber) {
		this.flashMobHostId = flashMobHostId;
		this.title = title;
		this.content = content;
		this.interestCategory = interestCategory;
		this.ageRange = ageRange;
		this.maxMember = maxMember;
		this.meetingDate = meetingDate;
		this.guNumber = guNumber;
	}
    
	public FlashMobVO(int flashMobNumber, String flashMobHostId, String title, String content, String interestCategory,
			String ageRange, int maxMember, Date meetingDate, String image, int guNumber) {
		this.flashMobNumber = flashMobNumber;
		this.flashMobHostId = flashMobHostId;
		this.title = title;
		this.content = content;
		this.interestCategory = interestCategory;
		this.ageRange = ageRange;
		this.maxMember = maxMember;
		this.meetingDate = meetingDate;
		this.image = image;
		this.guNumber = guNumber;
	}

	public int getFlashMobNumber() {
		return flashMobNumber;
	}

	public void setFlashMobNumber(int flashMobNumber) {
		this.flashMobNumber = flashMobNumber;
	}

	public String getFlashMobHostId() {
		return flashMobHostId;
	}

	public void setFlashMobHostId(String flashMobHostId) {
		this.flashMobHostId = flashMobHostId;
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

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getGuNumber() {
		return guNumber;
	}

	public void setGuNumber(int guNumber) {
		this.guNumber = guNumber;
	}

	@Override
	public String toString() {
		return "FlashMobVO [flashMobNumber=" + flashMobNumber + ", flashMobHostId=" + flashMobHostId + ", title="
				+ title + ", content=" + content + ", interestCategory=" + interestCategory + ", ageRange=" + ageRange
				+ ", maxMember=" + maxMember + ", meetingDate=" + meetingDate + ", image=" + image + ", guNumber="
				+ guNumber + "]";
	}

}
