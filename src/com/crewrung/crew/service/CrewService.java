package com.crewrung.crew.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.crew.vo.ApplyCrewMeetingVO;
import com.crewrung.crew.vo.CrewApplicationVO;
import com.crewrung.crew.vo.CrewAppliesVO;
import com.crewrung.crew.vo.CrewCommentVO;
import com.crewrung.crew.vo.CrewLeaderVO;
import com.crewrung.crew.vo.CrewManagePageVO;
import com.crewrung.crew.vo.CrewMeetingParticipantVO;
import com.crewrung.crew.vo.CrewMeetingVO;
import com.crewrung.crew.vo.CrewMemberVO;
import com.crewrung.crew.vo.CrewVO;
import com.crewrung.crew.vo.PromotionVO;

public class CrewService {
	private CrewDAO crewDAO;
	
	public CrewService(CrewDAO crewDAO) {
		this.crewDAO = crewDAO;
	}

	public CrewService() {}

	public boolean isCrewMember(int crewNumber, String userId) {
		boolean result = false;
		CrewMemberVO cm = new CrewMemberVO();
		if((crewNumber == cm.getCrewNumber()) && (userId == cm.getCrewMemberId())) {
			result = true;
		}
		return result;
	}

	//크루 멤버인지 확인
	public boolean checkCrewMembership(int crewNumber, String userId) {
		return crewDAO.isMemberOfCrew(crewNumber, userId);
	}

	//홍보 중인 크루 목록 조회
	public List<PromotionVO> getPromotedCrews() {
		return crewDAO.getAllPromotionCrew();
	}

	 // 전체 크루 리스트
    public List<AllCrewVO> getAllCrews() {
        return crewDAO.getAllCrew();
    }

    // 필터 적용 크루 리스트
    public List<AllCrewVO> getCrewsByFilter(Map<String, String> filter) {
        return crewDAO.getAllCrewByFilter(filter);
    }

	//특정 크루 상세 조회
	public AllCrewVO getCrewDetail(int crewNumber) {
		return crewDAO.getCrewDetail(crewNumber);
	}

	//크루장의 정보 조회
	public CrewLeaderVO getCrewLeaderInfo(int crewNumber) {
		return crewDAO.getCrewLeader(crewNumber);
	}

	//크루 등록
	public int addCrew(CrewVO crewVO) {
		return crewDAO.addCrew(crewVO);
	}

	//크루 수정
	public int updateCrew(CrewVO crewVO) {
		return crewDAO.updateCrew(crewVO);
	}

	//크루 댓글 수 조회
	public int getCommentCountByCrew(int crewNumber) {
		return crewDAO.getCommentCount(crewNumber);
	}

	//크루 댓글 상세 조회
	public List<CrewCommentVO> getCrewCommentDetail(int crewNumber) {
		return crewDAO.getCrewCommentDetail(crewNumber);
	}

	//크루 가입 신청
	public int applyToCrew(CrewApplicationVO applicant) {
		return crewDAO.applyToCrew(applicant);
	}

	//크루 가입 신청자 목록 조회
	public List<CrewManagePageVO> getCrewApplicants(int crewNumber) {
		return crewDAO.getCrewApplicants(crewNumber);
	}

	//크루 멤버 목록 조회
	public List<CrewManagePageVO> getCrewMember(int crewNumber) {
		return crewDAO.getCrewMember(crewNumber);
	}


	public boolean isCrewLeaderService(int crewNumber, String crewLeaderId){
		return crewDAO.isCrewLeader(crewNumber, crewLeaderId);
	}

	public boolean isCrewMeetingHostService(CrewMeetingVO cm){
		return crewDAO.isCrewMeetingHost(cm);
	}

	public boolean setCrewMeetingService(CrewMeetingVO cm){
		return crewDAO.addCrewMeeting(cm);
	}

	public boolean applyCrewMeetingService(ApplyCrewMeetingVO acm){
		return crewDAO.applyCrewMeeting(acm);
	}

	public Collection<CrewMeetingParticipantVO> getCrewMeetingParticipantsService(int crewMeetingNumber){
		return crewDAO.getCrewMeetingParticipants(crewMeetingNumber);
	}

	public CrewMeetingParticipantVO getCrewMeetingHostService(int crewMeetingNumber){
		return crewDAO.getCrewMeetingHost(crewMeetingNumber);
	}

	public boolean addCrewMeetingService(CrewMeetingVO cm) {
	    return crewDAO.addCrewMeeting(cm);
	}
	
	public CrewMeetingVO getCrewMeetingService(int crewMeetingNumber){
		return crewDAO.getCrewMeeting(crewMeetingNumber);
	}

	public Collection<CrewMeetingVO> getCrewMeetingsInfoService(int crewNumber){
		return crewDAO.getCrewMeetingsInfo(crewNumber);
	}

	public boolean removeCrewApplesService(CrewAppliesVO ca){
		return crewDAO.removeCrewApplies(ca);
	}

	public boolean addCrewMemberService(CrewMemberVO cm){
		return crewDAO.addCrewMember(cm);
	}

	public boolean removeCrewMemberService(CrewMemberVO cm){
		return crewDAO.removeCrewMember(cm);
	}
}
