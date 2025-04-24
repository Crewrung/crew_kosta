package com.crewrung.flashMob.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.vo.FlashMobCommentVO;
import com.crewrung.flashMob.vo.FlashMobMainViewVO;
import com.crewrung.flashMob.vo.FlashMobParticipantVO;
import com.crewrung.flashMob.vo.FlashMobVO;;

public class FlashMobService {
private FlashMobDAO flashMobDAO;
	
	public FlashMobService(FlashMobDAO flashMobDAO) {
		this.flashMobDAO = flashMobDAO;
	}
	
	//메인페이지에 번개모임목록 전체조회
	public List<FlashMobMainViewVO> getAllFlashMobs() {
		return flashMobDAO.getAllFlashMobs();
	}
	
	//메인페이지에서 번개모임 필터링 조회
	public List<FlashMobMainViewVO> getAllFlashMobsByFilter(Map<String, String> filter) {
		return flashMobDAO.getAllFlashMobsByFilter(filter);
	}
	
	//번개 모임 생성
	public int addFlashMob(FlashMobVO flashMobVO) {
		return flashMobDAO.addFlashMob(flashMobVO);
	}
	
	//번개모임 상세페이지
	public FlashMobVO getFlashMobDetail(int flashMobNumber) {
		return flashMobDAO.getFlashMobDetail(flashMobNumber);
	}
	
	//번개모임 신청자인가
	public boolean isFlashParticipants(String userId, int flashMobNumber) {
		boolean result = false;
		List<UserInfoVO> flashMobParticipants = flashMobDAO.getFlashMobParticipants(flashMobNumber);
		
		for (UserInfoVO user: flashMobParticipants) {
			if (userId.equals(user.getUserId())) {
				result = true;
			}
		}
		
		return result;
	}
	
	//번개모임 주최자인가
	public boolean isFlashMobHost(String userId, int flashMobNumber) {
		UserInfoVO host = flashMobDAO.getFlashMobHost(flashMobNumber);
		return userId.equals(host.getUserId());
	}
	
	//번개모임 주최자조회(호스트)
	public UserInfoVO getFlashMobHost(int flashMobNumber) {
		return flashMobDAO.getFlashMobHost(flashMobNumber);
	}
	
	//번개모임 참석자조회
	public List<UserInfoVO> getFlashMobParticipants(String userId, int flashMobNumber) {
		return flashMobDAO.getFlashMobParticipants(flashMobNumber);
	}
	
	//번개모임 신청하기
	public int addFlashMobParticipant(String userId, int flashMobNumber) {
		return flashMobDAO.addFlashMobParticipant(new FlashMobParticipantVO(userId, flashMobNumber));
	}
	
	//번개모임 수정하기
	public int setFlashMobDetail(FlashMobVO flashMobVO) {
		return flashMobDAO.setFlashMobDetail(flashMobVO);
	}
	
	//번개모임 댓글 조회
	public List<FlashMobCommentVO> getAllFlashMobComments(int flashMobNumber) {
		return flashMobDAO.getAllFlashMobComments(flashMobNumber);
	}
	
	//번개모임댓글 등록
	public int addFlashMobComment(FlashMobCommentVO flashMobCommentVO) {
		return flashMobDAO.addFlashMobComment(flashMobCommentVO);
	}
	
}
