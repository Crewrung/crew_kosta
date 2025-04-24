package com.crewrung.account.vo;

public class UserIdFindVO {
	
	private String userId;
	private String email;
	private String question;
	private String answer;
	
	public UserIdFindVO(){}
	
	public UserIdFindVO(String email, String question, String answer) {
		super();
		this.email = email;
		this.question = question;
		this.answer = answer;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "UserIdFindVO [userId=" + userId + ", email=" + email + ", question=" + question + ", answer=" + answer
				+ "]";
	}
	
	
	
	
	
	
	

}
