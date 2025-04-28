package com.crewrung.crew.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;

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

public class CrewDAO {
   SqlSession con; 

	public CrewDAO(SqlSession sqlSession) {
		
		this.con = sqlSession;
	}

	public List<PromotionVO> getAllPromotionCrew() {
		List<PromotionVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getAllPromotionCrew");
		con.close();
		return result;
	}

	  // 전체 크루 조회
    public List<AllCrewVO> getAllCrew() {
        List<AllCrewVO> result = con.selectList("crewMapper.getAllCrew");
        con.close();
        return result;
    }

    // 필터 적용된 크루 조회
    public List<AllCrewVO> getAllCrewByFilter(Map<String, String> filter) {
        List<AllCrewVO> result = con.selectList("crewMapper.getAllCrewByFilter", filter);
        con.close();
        return result;
    }

	public AllCrewVO getCrewDetail(int crewNumber) {
		AllCrewVO result = new AllCrewVO();
		result = con.selectOne("crewMapper.getCrewDetail", crewNumber);
		con.close();
		return result;
	}

	public CrewLeaderVO getCrewLeader(int crewNumber) {
		CrewLeaderVO result = new CrewLeaderVO();
		result = con.selectOne("crewMapper.getCrewLeader", crewNumber);
		con.close();
		return result;
	}

	public int addCrew(CrewVO crewVO) {
		int result = 0;
		result = con.insert("crewMapper.addCrew", crewVO);
		con.close();
		return result;
	}

	public int updateCrew(CrewVO crewVO) {
		int result = 0;
		result = con.update("crewMapper.updateCrew", crewVO);
		con.close();
		return result;
	}

	public int getCommentCount(int crewNumber) {
		int result = 0;
		result = con.selectOne("crewMapper.getCommentCount", crewNumber);
		con.close();
		return result;
	}

	public List<CrewCommentVO> getCrewCommentDetail(int crewNumber) {
		List<CrewCommentVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getCrewCommentDetail", crewNumber);
		con.close();
		return result;
	}

	public int applyToCrew(CrewApplicationVO crewApplicantVO) {
		int result = con.insert("crewMapper.applyToCrew", crewApplicantVO);
		con.close();
		return result;
	}

	public List<CrewManagePageVO> getCrewApplicants(int crewNumber) {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getCrewApplicants", crewNumber);
		con.close();
		return result;
	}

	public List<CrewManagePageVO> getCrewMember(int crewNumber) {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getCrewMember", crewNumber);
		con.close();
		return result;
	}

	public boolean isMemberOfCrew(int crewNumber, String userId) {
		Map<String, Object> param = new HashMap<>();
		param.put("crewNumber", crewNumber);
		param.put("userId", userId);
		boolean result = con.selectOne("crewMapper.isMemberOfCrew", param);
		con.close();
		return result;
	}


	//여기까지 정능혁 작성

	public boolean setCrewMeeting(CrewMeetingVO cm) {
		boolean result = false;
		if(con.update("crewMapper.setCrewMeeting",cm)==1) result = true;
		con.close();
		return result;
	}

	public boolean applyCrewMeeting(ApplyCrewMeetingVO acm){
		boolean result = false;
		if(con.insert("crewMapper.applyCrewMeeting",acm)==1) result = true;
		con.close();
		return result;
	}

	public Collection<CrewMeetingParticipantVO> getCrewMeetingParticipants(int crewMeetingNumber){
		Collection<CrewMeetingParticipantVO> list = new ArrayList<>();
		list = con.selectList("crewMapper.getCrewMeetingParticipants",crewMeetingNumber);
		con.close();
		return list;
	}

	public CrewMeetingParticipantVO getCrewMeetingHost(int crewMeetingNumber){
		CrewMeetingParticipantVO cmpHost = con.selectOne("crewMapper.getCrewMeetingHost",crewMeetingNumber);  
		con.close();
		return cmpHost;
	}

	public boolean addCrewMeeting(CrewMeetingVO cm) {
		boolean result = false;
		if (con.insert("crewMapper.addCrewMeeting", cm) == 1) {
			result = true;
		}
		con.close();
		return result;
	}

	public CrewMeetingVO getCrewMeeting(int crewMeetingNumber){
		CrewMeetingVO cm = con.selectOne("crewMapper.getCrewMeeting",crewMeetingNumber);  
		con.close();
		return cm;
	}

	public Collection<CrewMeetingVO> getCrewMeetingsInfo(int crewNumber){
		Collection<CrewMeetingVO> list = new ArrayList<>();
		list = con.selectList("crewMapper.getCrewMeetingsInfo",crewNumber);;
		con.close();
		return list;
	}

	public boolean removeCrewApplies(CrewAppliesVO ca){
		boolean result = false;
		if(con.delete("crewMapper.removeCrewApplies", ca)==1) return true;
		con.close();
		return result;
	}

	public boolean addCrewMember(CrewMemberVO cm){
		boolean result = false;
		if(con.insert("crewMapper.addCrewMember", cm)==1) return true;
		con.close();
		return result;
	}

	public boolean removeCrewMember(CrewMemberVO cm){
		boolean result = false;
		if(con.delete("crewMapper.removeCrewMember", cm)==1) return true;
		con.close();
		return result;
	}

	public boolean isCrewLeader(int crewNumber, String crewLeaderId){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("crewNumber", crewNumber);
		m.put("crewLeaderId", crewLeaderId);
		boolean result = false;
		if(con.selectList("crewMapper.isCrewLeader", m) != null){
			result = true;
		}
		return result;
	}

	public boolean isCrewMeetingHost(CrewMeetingVO cm){
		boolean result = false;
		if(con.selectList("crewMapper.isCrewMeetingHost", cm) != null){
			result = true;
		}
		return result;
	}
	//여기까지 이상혁 작성
}
