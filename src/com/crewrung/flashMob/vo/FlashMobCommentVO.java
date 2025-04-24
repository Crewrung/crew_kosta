package com.crewrung.flashMob.vo;

import java.sql.Date;

public class FlashMobCommentVO {
	private int flashMobCommentId;
    private String flashMobComment;
    private Date commentDate;
    private String userId;
    private int flashMobNumber;
    
    public FlashMobCommentVO() {
    	
    }
    
	public FlashMobCommentVO(int flashMobCommentId, String flashMobComment, Date commentDate, String userId,
			int flashMobNumber) {
		this.flashMobCommentId = flashMobCommentId;
		this.flashMobComment = flashMobComment;
		this.commentDate = commentDate;
		this.userId = userId;
		this.flashMobNumber = flashMobNumber;
	}
	
	public int getFlashMobCommentId() {
		return flashMobCommentId;
	}
	
	public void setFlashMobCommentId(int flashMobCommentId) {
		this.flashMobCommentId = flashMobCommentId;
	}
	
	public String getFlashMobComment() {
		return flashMobComment;
	}
	
	public void setFlashMobComment(String flashMobComment) {
		this.flashMobComment = flashMobComment;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}
	
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
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

	@Override
	public String toString() {
		return "FlashMobCommentVO [flashMobCommentId=" + flashMobCommentId + ", flashMobComment=" + flashMobComment
				+ ", commentDate=" + commentDate + ", userId=" + userId + ", flashMobNumber=" + flashMobNumber + "]";
	}

}
