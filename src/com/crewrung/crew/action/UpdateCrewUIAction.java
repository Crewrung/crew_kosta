package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class UpdateCrewUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		int crewNumber = Integer.parseInt(request.getParameter("crewNumber"));
	
		CrewService service = new CrewService(new CrewDAO(session));
		// 신청자들 정보
		request.setAttribute("crewApplicants", service.getCrewApplicants(crewNumber));
		// 멤버 정보
		request.setAttribute("crewMembers", service.getCrewMember(crewNumber));
		return "crew/updateCrewPage.jsp";
	}

}
