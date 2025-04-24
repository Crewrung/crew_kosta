package com.crewrung.account.vo;

public class FindUserIdVO {

	private String email;
	private String question;
	private String answer;
	
	public FindUserIdVO(){}
	
	public FindUserIdVO(String email, String question, String answer) {
		super();
		this.email = email;
		this.question = question;
		this.answer = answer;
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
}