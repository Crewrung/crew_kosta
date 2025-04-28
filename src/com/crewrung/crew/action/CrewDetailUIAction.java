package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.db.DBCP;
import com.crewrung.mybatis.MyBatisUtil;
import com.crewrung.servlet.Action;

public class CrewDetailUIAction implements Action {

	  @Override
	    public String execute(HttpServletRequest request) throws ServletException, IOException {
	        SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
	        CrewService crewService = new CrewService(new CrewDAO(session)); // crewService 생성

        int crewNumber = Integer.parseInt(request.getParameter("crewNumber"));
        AllCrewVO crewDetail = service.getCrewDetail(crewNumber);

        request.setAttribute("crewDetail", crewDetail);

        return "crew/crewDetail.jsp";  // 크루 상세보기 페이지로 이동
    }
}
