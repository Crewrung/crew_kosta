package com.crewrung.crew.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import java.util.Collection;
import java.util.HashMap;

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
		return result;
	}
	public int getCrewMeetingHostNumber(String userId){
		int result = con.selectOne("crewMapper.getCrewMeeintgHostNumber",userId);
		return result;
	}
	public List<AllCrewVO> getAllCrew() {
		List<AllCrewVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getAllCrew");
		return result;
	}
	
	public List<AllCrewVO> getAllCrewByFilter(Map<String, String> filter) {
		List<AllCrewVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getAllCrewByFilter", filter);
		return result;
	}
	
	public AllCrewVO getCrewDetail(int crewNumber) {
		AllCrewVO result = new AllCrewVO();
		result = con.selectOne("crewMapper.getCrewDetail", crewNumber);
		return result;
	}

	public CrewLeaderVO getCrewLeader(int crewNumber) {
		CrewLeaderVO result = new CrewLeaderVO();
		result = con.selectOne("crewMapper.getCrewLeader", crewNumber);
		return result;
	}

	public int addCrew(CrewVO crewVO) {
		int result = 0;
		result = con.insert("crewMapper.addCrew", crewVO);
		con.commit();
		return result;
	}

	public int updateCrew(CrewVO crewVO) {
		int result = 0;
		result = con.update("crewMapper.updateCrew", crewVO);
		con.commit();
		return result;
	}

	public int getCommentCount(int crewNumber) {
		int result = 0;
		result = con.selectOne("crewMapper.getCommentCount", crewNumber);
		return result;
	}

	public List<CrewCommentVO> getCrewCommentDetail(int crewNumber) {
		List<CrewCommentVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getCrewCommentDetail", crewNumber);
		return result;
	}

	public int applyToCrew(CrewApplicationVO crewApplicantVO) {
		int result = 0;
		result = con.insert("crewMapper.applyToCrew", crewApplicantVO);
		con.commit();
		return result;
	}

	public List<CrewManagePageVO> getCrewApplicants(int crewNumber) {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getCrewApplicants", crewNumber);
		return result;
	}

	public List<CrewManagePageVO> getCrewMember(int crewNumber) {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = con.selectList("crewMapper.getCrewMember", crewNumber);
		return result;
	}

	public boolean isMemberOfCrew(int crewNumber, String userId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crewNumber", crewNumber);
	    param.put("userId", userId);
	    boolean result = con.selectOne("crewMapper.isMemberOfCrew", param);
	    return result;
	}


	//여기까지 정능혁 작성

	public boolean setCrewMeeting(CrewMeetingVO cm) {
		boolean result = false;
		if(con.update("crewMapper.setCrewMeeting",cm)==1) result = true;
		con.commit();
		return result;
	}

	public boolean applyCrewMeeting(ApplyCrewMeetingVO acm){
		boolean result = false;
		if(con.insert("crewMapper.applyCrewMeeting",acm)==1) result = true;
		con.commit();
		return result;
	}

	public Collection<CrewMeetingParticipantVO> getCrewMeetingParticipants(int crewMeetingNumber){
		Collection<CrewMeetingParticipantVO> list = new ArrayList<>();
		list = con.selectList("crewMapper.getCrewMeetingParticipants",crewMeetingNumber);
		return list;
	}

	public CrewMeetingParticipantVO getCrewMeetingHost(int crewMeetingNumber){
		CrewMeetingParticipantVO cmpHost = con.selectOne("crewMapper.getCrewMeetingHost",crewMeetingNumber);  
		return cmpHost;
	}

	public boolean addCrewMeeting(CrewMeetingVO cm) {
		boolean result = false;
		if(con.insert("crewMapper.addCrewMeeting", cm)==1) result = true;
		con.commit();
		return result;
	}

	public CrewMeetingVO getCrewMeeting(int crewMeetingNumber){
		CrewMeetingVO cm = con.selectOne("crewMapper.getCrewMeeting",crewMeetingNumber);  
		return cm;
	}

	public Collection<CrewMeetingVO> getCrewMeetingsInfo(int crewNumber){
		Collection<CrewMeetingVO> list = new ArrayList<>();
		list = con.selectList("crewMapper.getCrewMeetingsInfo",crewNumber);;
		return list;
	}
	public boolean removeCrewApplicant(CrewAppliesVO ca){
		boolean result = false;
		if(con.delete("crewMapper.removeCrewApplicant", ca)==1) result=true;
		con.commit();
		return result;
	}

	public boolean addCrewMember(CrewMemberVO cm){
		boolean result = false;
		if(con.insert("crewMapper.addCrewMember", cm)==1) result= true;
		con.commit(); 
		return result;
	}

	public boolean removeCrewMember(CrewMemberVO cm){
		boolean result = false;
		if(con.delete("crewMapper.removeCrewMember", cm)==1)result= true;
		con.commit();
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
