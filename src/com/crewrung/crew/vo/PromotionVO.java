package com.crewrung.crew.vo;

public class PromotionVO {
	private String promotionMessage;
	private String introduction;
	
	public PromotionVO(){}
	public PromotionVO(String promotionMessage, String introduction) {
		super();
		this.promotionMessage = promotionMessage;
		this.introduction = introduction;
	}
	
	public String getPromotionMessage() {
		return promotionMessage;
	}
	
	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "PromotionVO [promotionMessage=" + promotionMessage + ", introduction=" + introduction + "]\n";
	}

}
