package com.crewrung.flashMob.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;
import com.crewrung.flashMob.vo.FlashMobCommentVO;
import com.crewrung.flashMob.vo.FlashMobVO;
import com.crewrung.servlet.Action;

public class updateFlashMobAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
		FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));

		int flashMobNumber = Integer.parseInt(request.getParameter("flashMobNumber"));
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		String hostId = request.getParameter("hostId");
		String content = request.getParameter("content");
		String interestCategory = request.getParameter("interestCategory");
		String ageRange = request.getParameter("ageRange");
		String maxMemberStr = request.getParameter("maxMember");
		String meetingDate = request.getParameter("meetingDate");
		String time = request.getParameter("time");
		String guNumberStr = request.getParameter("guNumber");

		// 최대 인원수를 정수로 변환
		int maxMember = Integer.parseInt(maxMemberStr);

		// 구 번호를 정수로 변환
		int guNumber = Integer.parseInt(guNumberStr);

		// 날짜와 시간 합치기
		String dateTimeStr = meetingDate + " " + time + ":00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date parsedDate = null;
		java.sql.Date meetingDateTime = null;
		try {
			parsedDate = sdf.parse(dateTimeStr);
			meetingDateTime = new java.sql.Date(parsedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		FlashMobVO flashMobVO = new FlashMobVO(flashMobNumber, hostId, title, content, interestCategory, ageRange, maxMember,
				meetingDateTime, image,guNumber);
		System.out.println(flashMobVO);
		
		flashMobService.setFlashMobDetail(flashMobVO);
		
		//번개모임 제목, 컨텐츠, 이미지
        FlashMobVO flashmob = flashMobService.getFlashMobDetail(flashMobNumber);
        flashmob.setFlashMobNumber(flashMobNumber);
        
        //참가자
        List<UserInfoVO> participants = flashMobService.getFlashMobParticipants(flashMobNumber);
        
        //리더
        UserInfoVO leader = flashMobService.getFlashMobHost(flashMobNumber);
        

        //댓글
        List<FlashMobCommentVO> comments = flashMobService.getAllFlashMobComments(flashMobNumber);
        HttpSession ServerSession = request.getSession(false); // 기존 세션만 가져옴 (없으면 null)
        String userId = null;
        if (ServerSession != null && ServerSession.getAttribute("userId") != null) {
        	userId = (String) ServerSession.getAttribute("userId");
        }
        
        //호스트, 참가자 여부
        boolean isHost = flashMobService.isFlashMobHost(userId, flashMobNumber);
        boolean isParticipant = flashMobService.isFlashParticipants(userId, flashMobNumber);
        
        request.setAttribute("flashmob", flashmob);
        request.setAttribute("participants", participants);
        request.setAttribute("userId", userId);
        
        request.setAttribute("leader", leader);
        request.setAttribute("comments", comments);
        request.setAttribute("isHost", isHost);
        request.setAttribute("isParticipant", isParticipant);
        
        session.close();
		return "flashmob/flashMobDetailPage.jsp";

	}

}
