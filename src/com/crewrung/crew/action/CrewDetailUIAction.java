package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class CrewDetailUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		//crewNumber 갖고옴
		int crewNumber = Integer.parseInt(request.getParameter("crewNumber"));
		CrewService service = new CrewService(new CrewDAO(session));
		//크루에 관한 정보 담기
		request.setAttribute("crew", service.getCrewDetail(crewNumber));
		//크루 멤버들의 정보
		request.setAttribute("crewMembers", service.getCrewMember(crewNumber));
		//크루 모임들의 정보
		request.setAttribute("crewMeetings", service.getCrewMeetingsInfoService(crewNumber));
		//댓글 갯수
		request.setAttribute("crewCommentCount", service.getCommentCountByCrew(crewNumber));
		//댓글 정보
		request.setAttribute("crewComments", service.getCrewCommentDetail(crewNumber));
		return "crewDetailPage.jsp";
	}
}
