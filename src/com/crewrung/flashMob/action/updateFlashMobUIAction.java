package com.crewrung.flashMob.action;

import java.io.IOException;
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

public class updateFlashMobUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
        FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));
        
        int flashMobNumber = Integer.parseInt(request.getParameter("flashMobNumber"));
        
        //번개모임 제목, 컨텐츠, 이미지
        FlashMobVO flashMob = flashMobService.getFlashMobDetail(flashMobNumber);
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(flashMob.getMeetingDate());
        
        request.setAttribute("ageRange", flashMob.getAgeRange());
        request.setAttribute("content", flashMob.getContent());
        request.setAttribute("userId", flashMob.getFlashMobHostId());
        request.setAttribute("flashMobNumber", flashMobNumber);
        request.setAttribute("guNumber", flashMob.getGuNumber());
        request.setAttribute("image", flashMob.getImage());
        request.setAttribute("interestCategory", flashMob.getInterestCategory());
        request.setAttribute("maxMember", flashMob.getMaxMember());
        request.setAttribute("meetingDate", flashMob.getMeetingDate());
        request.setAttribute("title", flashMob.getTitle());
        request.setAttribute("time", time);
        
        session.close();
		
		return "flashmob/flashMobUpdatePage.jsp";
	}

}
