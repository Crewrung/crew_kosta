package com.crewrung.crew.vo;

public class CrewVO {
	private int crewNumber;
	private String crewName;
	private String crewLeaderId;
	private String introduction;
	private String interestCategory;
	private String ageRange;
	private String image;
	private String promotionMessage;
	private char isPromotion; 
	private int guNumber;
	
	public CrewVO(String crewName, String crewLeaderId, String introduction, String interestCategory, String ageRange,
			String image, String promotionMessage, char isPromotion, int guNumber) {
		super();
		this.crewName = crewName;
		this.crewLeaderId = crewLeaderId;
		this.introduction = introduction;
		this.interestCategory = interestCategory;
		this.ageRange = ageRange;
		this.image = image;
		this.promotionMessage = promotionMessage;
		this.isPromotion = isPromotion;
		this.guNumber = guNumber;
	}
	
	public CrewVO(int crewNumber, String crewName, String crewLeaderId, String introduction, String interestCategory,
			String ageRange, String image, String promotionMessage, char isPromotion, int guNumber) {
		super();
		this.crewNumber = crewNumber;
		this.crewName = crewName;
		this.crewLeaderId = crewLeaderId;
		this.introduction = introduction;
		this.interestCategory = interestCategory;
		this.ageRange = ageRange;
		this.image = image;
		this.promotionMessage = promotionMessage;
		this.isPromotion = isPromotion;
		this.guNumber = guNumber;
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
	public String getCrewLeaderId() {
		return crewLeaderId;
	}
	public void setCrewLeaderId(String crewLeaderId) {
		this.crewLeaderId = crewLeaderId;
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
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPromotionMessage() {
		return promotionMessage;
	}
	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
	}
	public char getIsPromotion() {
		return isPromotion;
	}
	public void setIsPromotion(char isPromotion) {
		this.isPromotion = isPromotion;
	}
	public int getGuNumber() {
		return guNumber;
	}
	public void setGuNumber(int guNumber) {
		this.guNumber = guNumber;
	}

	@Override
	public String toString() {
		return "CrewVO [crewNumber=" + crewNumber + ", crewName=" + crewName + ", crewLeaderId=" + crewLeaderId
				+ ", introduction=" + introduction + ", interestCategory=" + interestCategory + ", ageRange=" + ageRange
				+ ", image=" + image + ", promotionMessage=" + promotionMessage + ", isPromotion=" + isPromotion
				+ ", guNumber=" + guNumber + "]";
	}
}
