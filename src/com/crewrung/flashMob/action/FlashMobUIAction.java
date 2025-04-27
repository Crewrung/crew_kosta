package com.crewrung.flashMob.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;
import com.crewrung.flashMob.vo.FlashMobMainViewVO;
import com.crewrung.servlet.Action;

public class FlashMobUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
        FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));
		
        request.setAttribute("flashMobList", flashMobService.getAllFlashMobs());
		
		return "flashmob/flashMobMain.jsp";
	}

}
