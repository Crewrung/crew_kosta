package com.crewrung.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;

public class MainActionUI implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		
        FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));
        CrewService crewService = new CrewService(new CrewDAO(session));
		
        request.setAttribute("flashMobList", flashMobService.getAllFlashMobs());
        request.setAttribute("crewList", crewService.getAllCrews());
      
        session.close();
		
		return "index.jsp";
	}

}
