package com.crewrung.crew.vo;

public class CrewAppliesVO {
	private int crewApplyNumber;
	private int crewNumber;
	private String userId;
	private String introduction;
	
	public CrewAppliesVO(){}

	public CrewAppliesVO(int crewApplyNumber, int crewNumber, String userId, String introduction) {
		this.crewApplyNumber = crewApplyNumber;
		this.crewNumber = crewNumber;
		this.userId = userId;
		this.introduction = introduction;
	}
	
	public CrewAppliesVO(int crewApplyNumber, int crewNumber){
		this(crewApplyNumber, crewNumber,null,null);
	}
	
	public int getCrewApplyNumber() {
		return crewApplyNumber;
	}

	public void setCrewApplyNumber(int crewApplyNumber) {
		this.crewApplyNumber = crewApplyNumber;
	}

	public int getCrewNumber() {
		return crewNumber;
	}

	public void setCrewNumber(int crewNumber) {
		this.crewNumber = crewNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crewNumber;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrewAppliesVO other = (CrewAppliesVO) obj;
		if (crewNumber != other.crewNumber)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrewAppliesVO [crewApplyNumber=" + crewApplyNumber + ", crewNumber=" + crewNumber + ", userId=" + userId
				+ ", introduction=" + introduction + "]";
	}
}
