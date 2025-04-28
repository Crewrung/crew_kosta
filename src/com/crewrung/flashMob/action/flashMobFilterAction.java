package com.crewrung.flashMob.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;
import com.crewrung.flashMob.vo.FlashMobMainViewVO;
import com.crewrung.servlet.Action;
import com.google.gson.Gson;

public class flashMobFilterAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
        FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(session));
        Gson gson = new Gson();
		
		
		String interestCategory = request.getParameter("interestCategory");
		String ageRange = request.getParameter("ageRange");
		String guName = request.getParameter("guName");
		String maxMember = request.getParameter("maxMember");
		String minMember = request.getParameter("minMember");
		
		Map<String ,String> filter = new HashMap<>();
		filter.put("interestCategory", interestCategory);
		filter.put("ageRange", ageRange);
		filter.put("guName", guName);
		filter.put("maxMember", maxMember);
		filter.put("minMember", minMember);
		
		List<FlashMobMainViewVO> flashMobs = flashMobService.getAllFlashMobsByFilter(filter);
		
		return gson.toJson(flashMobs);
	}

}
