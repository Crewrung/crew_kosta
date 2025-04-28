package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.CrewMeetingVO;
import com.crewrung.db.DBCP;
import com.crewrung.mybatis.MyBatisUtil;
import com.crewrung.servlet.Action;

public class AddCrewMeetingAction implements Action {

    public AddCrewMeetingAction() {} // 湲곕낯 �깮�꽦�옄
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
        CrewService crewService = new CrewService(new CrewDAO(session)); // crewService 생성

        CrewMeetingVO meetingVO = new CrewMeetingVO();
        meetingVO.setTitle(request.getParameter("title"));
        meetingVO.setContent(request.getParameter("content"));
        meetingVO.setMeetingDate(request.getParameter("meetingDate")); // �궇吏쒖� �떆媛� �넻�빀
        meetingVO.setMaxMember(Integer.parseInt(request.getParameter("maxMember")));
        meetingVO.setCrewNumber(Integer.parseInt(request.getParameter("crewNumber")));
        meetingVO.setCrewMeetingHostNumber(Integer.parseInt(request.getParameter("crewMeetingHostNumber")));
        meetingVO.setGuNumber(Integer.parseInt(request.getParameter("guNumber")));

        boolean result = service.addCrewMeetingService(meetingVO);

        if (result > 0) {
            return "crew/crewAddMeetingResult.jsp?message=�겕猷� 紐⑥엫�씠 �꽦怨듭쟻�쑝濡� �깮�꽦�릺�뿀�뒿�땲�떎.&redirectUrl=/controller?cmd=crewUI";
        } else {
            return "crew/crewAddMeetingResult.jsp?message=�겕猷� 紐⑥엫 �깮�꽦�뿉 �떎�뙣�뻽�뒿�땲�떎.&redirectUrl=/crew/crewMeetingAddPage.html";
        }
    }
}
