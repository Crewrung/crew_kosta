package com.crewrung.flashMob.action;

import java.io.IOException;
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

public class flashMobDetailUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
        FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));
        
        int flashMobNumber = Integer.parseInt(request.getParameter("flashMobNumber"));
        
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
        System.out.println(isHost);
        System.out.println(isParticipant);
        
        session.close();
		return "flashmob/flashMobDetailPage.jsp";
	}

}
