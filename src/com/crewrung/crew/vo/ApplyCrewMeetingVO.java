package com.crewrung.crew.vo;

public class ApplyCrewMeetingVO {
	private int crewMeetingNumber;
	private int crewMemberNumber;
	
	
	public ApplyCrewMeetingVO(){}

	public ApplyCrewMeetingVO(int crewMeetingNumber, int crewMemberNumber) {
		this.crewMeetingNumber = crewMeetingNumber;
		this.crewMemberNumber = crewMemberNumber;
	}

	public int getCrewMeetingNumber() {
		return crewMeetingNumber;
	}

	public void setCrewMeetingNumber(int crewMeetingNumber) {
		this.crewMeetingNumber = crewMeetingNumber;
	}

	public int getCrewMemberNumber() {
		return crewMemberNumber;
	}

	public void setCrewMemberNumber(int crewMemberNumber) {
		this.crewMemberNumber = crewMemberNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crewMeetingNumber;
		result = prime * result + crewMemberNumber;
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
		ApplyCrewMeetingVO other = (ApplyCrewMeetingVO) obj;
		if (crewMeetingNumber != other.crewMeetingNumber)
			return false;
		if (crewMemberNumber != other.crewMemberNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplyCrewMeetingVO [crewMeetingNumber=" + crewMeetingNumber + ", crewMemberNumber=" + crewMemberNumber
				+ "]";
	}
	
	
}	
