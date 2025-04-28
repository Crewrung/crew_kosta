package com.crewrung.crew.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.crew.vo.CrewVO;
import com.crewrung.db.DBCP;
import com.crewrung.mybatis.MyBatisUtil;
import com.crewrung.servlet.Action;

public class CrewUIAction implements Action {

	  @Override
	    public String execute(HttpServletRequest request) throws ServletException, IOException {
	        SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
	        CrewService crewService = new CrewService(new CrewDAO(session)); // crewService 생성
        
        List<AllCrewVO> crewList = service.getAllCrews(); // 전체 크루 리스트 가져오기
        
        request.setAttribute("crewList", crewList);
        
        return "crew/crewMain.jsp"; // 페이지 이동
    }
}
