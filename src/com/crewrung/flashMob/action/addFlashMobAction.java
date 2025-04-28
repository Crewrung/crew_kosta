package com.crewrung.flashMob.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;
import com.crewrung.flashMob.vo.FlashMobVO;
import com.crewrung.servlet.Action;

public class addFlashMobAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));

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

		FlashMobVO flashMobVO = new FlashMobVO(hostId, title, content, interestCategory, ageRange, maxMember,
				meetingDateTime, guNumber);
		flashMobService.addFlashMob(flashMobVO);

		return "flashmob/flashMobMain.jsp";
	}

}
