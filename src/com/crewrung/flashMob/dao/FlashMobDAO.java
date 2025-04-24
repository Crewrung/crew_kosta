package com.crewrung.flashMob.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.flashMob.vo.FlashMobCommentVO;
import com.crewrung.flashMob.vo.FlashMobMainViewVO;
import com.crewrung.flashMob.vo.FlashMobParticipantVO;
import com.crewrung.flashMob.vo.FlashMobVO;

public class FlashMobDAO {
	SqlSession con;
	
	public FlashMobDAO(SqlSession sqlSession) {
		
		this.con = sqlSession;

	}
	
	public List<FlashMobMainViewVO> getAllFlashMobs() {
		List<FlashMobMainViewVO> result = new ArrayList<>();
		result = con.selectList("flashMobMapper.getAllFlashMobs");
		con.close();
		return result;
	}
	
	public List<FlashMobMainViewVO> getAllFlashMobsByFilter(Map<String, String> filter) {
		List<FlashMobMainViewVO> result = new ArrayList<>();
		result = con.selectList("flashMobMapper.getAllFlashMobsByFilter", filter);
		con.close();
		return result;
	}
	
	public int addFlashMob(FlashMobVO flashMobVO) {
		int result = 0;
		result = con.insert("flashMobMapper.addFlashMob", flashMobVO);
		con.close();
		return result;
	}
	
	public FlashMobVO getFlashMobDetail(int flashMobNumber) {
		FlashMobVO result = null;
		result = con.selectOne("flashMobMapper.getFlashMobDetail", flashMobNumber);
		con.close();
		return result;
	}
	
	//번개 모임 신청하기 add
	public int addFlashMobParticipant(FlashMobParticipantVO flashMobParticipantVO) {
		int result = 0;
		result = con.insert("flashMobMapper.addFlashMobParticipant", flashMobParticipantVO);
		con.close();
		return result;
	}
	
	//번개모임 주최자(host) 조회
	public UserInfoVO getFlashMobHost(int flashMobNumber) {
		UserInfoVO result = null;
		result = con.selectOne("flashMobMapper.getFlashMobHost", flashMobNumber);
		con.close();
		return result;
	}
	
	//번개모임 신청자 조회
	public List<UserInfoVO> getFlashMobParticipants(int flashMobNumber) {
		List<UserInfoVO> result = new ArrayList<>();
		result = con.selectList("flashMobMapper.getFlashMobParticipants", flashMobNumber);
		con.close();
		return result;
	}
	
	//번개 모임 수정하기 set
	public int setFlashMobDetail(FlashMobVO flashMobVO) {
		int result = 0;
		result = con.update("flashMobMapper.setFlashMobDetail", flashMobVO);
		con.close();
		return result;
	}
	//번개 모임 댓글 조회 get
	public List<FlashMobCommentVO> getAllFlashMobComments(int flashMobNumber) {
		List<FlashMobCommentVO> result = new ArrayList<>();
		result = con.selectList("flashMobMapper.getAllFlashMobComments", flashMobNumber);
		con.close();
		return result;
	}
	
	//번개 모임 댓글 등록 add
	public int addFlashMobComment(FlashMobCommentVO flashMobCommentVO) {
		int result = 0;
		result = con.insert("flashMobMapper.addFlashMobComment", flashMobCommentVO);
		con.close();
		return result;
	}
}
