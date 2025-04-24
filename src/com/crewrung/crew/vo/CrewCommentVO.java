package com.crewrung.crew.vo;

public class CrewCommentVO {
	private String nickname;
	private String crewComment;
	
	public CrewCommentVO(){}
	public CrewCommentVO(String nickname, String crewComment) {
		super();
		this.nickname = nickname;
		this.crewComment = crewComment;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCrewComment() {
		return crewComment;
	}
	public void setCrewComment(String crewComment) {
		this.crewComment = crewComment;
	}

	@Override
	public String toString() {
		return "CrewCommentVO [nickname=" + nickname + ", crewComment=" + crewComment + "]";
	}

}
