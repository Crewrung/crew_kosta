package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.CrewMeetingVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class AddCrewMeetingAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
        CrewService crewService = new CrewService(new CrewDAO(session)); // crewService 생성

        CrewMeetingVO meetingVO = new CrewMeetingVO();
        meetingVO.setTitle(request.getParameter("title"));
        meetingVO.setContent(request.getParameter("content"));
        meetingVO.setMeetingDate(request.getParameter("meetingDate")); // 모임 날짜 설정
        meetingVO.setMaxMember(Integer.parseInt(request.getParameter("maxMember")));
        meetingVO.setCrewNumber(Integer.parseInt(request.getParameter("crewNumber")));
        meetingVO.setCrewMeetingHostNumber(Integer.parseInt(request.getParameter("crewMeetingHostNumber")));
        meetingVO.setGuNumber(Integer.parseInt(request.getParameter("guNumber")));

        boolean result = crewService.addCrewMeetingService(meetingVO);  // 수정된 부분

        if (result) {
            return "crew/crewAddMeetingResult.jsp?message=크루 모임이 성공적으로 생성되었습니다.&redirectUrl=/controller?cmd=crewUI";
        } else {
            return "crew/crewAddMeetingResult.jsp?message=크루 모임 생성에 실패했습니다.&redirectUrl=/crew/crewMeetingAddPage.html";
        }
    }
}
