package com.crewrung.flashMob.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;
import com.crewrung.servlet.Action;

public class addFlashMobUIAction implements Action {

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
        
        request.setAttribute("userId", userId);
        session.close();
          
		return "flashmob/flashMobAddPage.jsp";
	}

}
