package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.CrewAppliesVO;
import com.crewrung.crew.vo.CrewMemberVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class ApproveCrewJoinRequestAction implements Action {
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		CrewService service = new CrewService(new CrewDAO(session));
		int crewNumber = Integer.parseInt(request.getParameter("crewNumber"));
		String userId = request.getParameter("userId");
		int crewApplyNumber = Integer.parseInt(request.getParameter("crewApplyNumber"));
		service.addCrewMemberService(new CrewMemberVO(crewNumber, userId));
		service.removeCrewApplicantService(new CrewAppliesVO(crewApplyNumber, crewNumber));
		return "controller?cmd=updateCrewUI&crewNumber=" + crewNumber;  
	}
}
