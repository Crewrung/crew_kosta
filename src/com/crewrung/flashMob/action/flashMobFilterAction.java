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
		SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
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
		System.out.println(flashMobs);
		session.close();
		
		// flashMobs의 size가 0이면 빈 값 보내기
	    if (flashMobs.size() == 0) {
	        return "{}"; // 빈 값으로 반환
	    }
	    
	    // flashMobs 리스트가 비어있지 않다면 JSON 형태로 반환
	    return gson.toJson(flashMobs);
	}

}
