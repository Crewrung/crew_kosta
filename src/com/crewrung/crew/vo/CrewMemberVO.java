package com.crewrung.crew.vo;

public class CrewMemberVO {
	private int crewMemberNumber;
	private int crewNumber;
	private String crewMemberId;
	private String join_date;
	
	public CrewMemberVO(){}

	public CrewMemberVO(int crewMemberNumber, int crewNumber, String crewMemberId, String join_date) {
		this.crewMemberNumber = crewMemberNumber;
		this.crewNumber = crewNumber;
		this.crewMemberId = crewMemberId;
		this.join_date = join_date;
	}
	
	public CrewMemberVO(int crewNumber, String crewMemberId) {
		this(0, crewNumber, crewMemberId, null);
	}
	
	public CrewMemberVO(int crewMemberNumber, int crewNumber) {
		this(crewMemberNumber, crewNumber, null, null);
	}
	
	public int getCrewMemberNumber() {
		return crewMemberNumber;
	}

	public void setCrewMemberNumber(int crewMemberNumber) {
		this.crewMemberNumber = crewMemberNumber;
	}

	public int getCrewNumber() {
		return crewNumber;
	}

	public void setCrewNumber(int crewNumber) {
		this.crewNumber = crewNumber;
	}

	public String getCrewMemberId() {
		return crewMemberId;
	}

	public void setCrewMemberId(String crewMemberId) {
		this.crewMemberId = crewMemberId;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crewMemberId == null) ? 0 : crewMemberId.hashCode());
		result = prime * result + crewNumber;
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
		CrewMemberVO other = (CrewMemberVO) obj;
		if (crewMemberId == null) {
			if (other.crewMemberId != null)
				return false;
		} else if (!crewMemberId.equals(other.crewMemberId))
			return false;
		if (crewNumber != other.crewNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrewMemberVO [crewMemberNumber=" + crewMemberNumber + ", crewNumber=" + crewNumber + ", crewMemberId="
				+ crewMemberId + ", join_date=" + join_date + "]";
	}
}
