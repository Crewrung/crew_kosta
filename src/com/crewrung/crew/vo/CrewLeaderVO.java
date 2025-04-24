package com.crewrung.crew.vo;

public class CrewLeaderVO {
	private String name;
	private String nickname;
	
	public CrewLeaderVO(){} //기본생성자 추가함
	public CrewLeaderVO(String name, String nickname) {
		super();
		this.name = name;
		this.nickname = nickname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "GetCrewLeaderVO [name=" + name + ", nickname=" + nickname + "]";
	}
	
}
