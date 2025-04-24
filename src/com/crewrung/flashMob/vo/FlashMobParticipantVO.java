package com.crewrung.flashMob.vo;

import java.sql.Date;

public class FlashMobParticipantVO {
	private String userId;
    private int flashMobNumber;
    private Date applyDate;
    
    public FlashMobParticipantVO() {
    	
    }
    
	public FlashMobParticipantVO(String userId, int flashMobNumber) {
		this.userId = userId;
		this.flashMobNumber = flashMobNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getFlashMobNumber() {
		return flashMobNumber;
	}

	public void setFlashMobNumber(int flashMobNumber) {
		this.flashMobNumber = flashMobNumber;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	@Override
	public String toString() {
		return "FlashMobParticipantVO [userId=" + userId + ", flashMobNumber=" + flashMobNumber + ", applyDate="
				+ applyDate + "]";
	}

}
