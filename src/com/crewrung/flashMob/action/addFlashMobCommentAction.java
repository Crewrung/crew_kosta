package com.crewrung.flashMob.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;
import com.crewrung.flashMob.vo.FlashMobCommentVO;
import com.crewrung.servlet.Action;

public class addFlashMobCommentAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
        FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));
        
        HttpSession ServerSession = request.getSession(false); // 기존 세션만 가져옴 (없으면 null)
        String userId = null;
        if (ServerSession != null && ServerSession.getAttribute("userId") != null) {
        	userId = (String) ServerSession.getAttribute("userId");
        }
        
        if (userId == null) {
        	return "account/login.jsp";
        }
        
        int flashMobNumber = Integer.parseInt(request.getParameter("flashMobNumber"));
        if (!flashMobService.isFlashParticipants(userId, flashMobNumber)){
        	return "controller?cmd=flashMobDetailUI&flashMobNumber=" + flashMobNumber;
        }
        
        String comment = request.getParameter("comment");
        
        FlashMobCommentVO commentVO = new FlashMobCommentVO();
        commentVO.setUserId(userId);
        commentVO.setFlashMobNumber(flashMobNumber);
        commentVO.setFlashMobComment(comment);
        
        flashMobService.addFlashMobComment(commentVO);
        
        session.close();
        
        return "controller?cmd=flashMobDetailUI&flashMobNumber=" + flashMobNumber;
        
	}

}
