package com.crewrung.crew.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.db.DBCP;
import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.servlet.Action;
import com.google.gson.Gson;

public class CrewFilterAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // MyBatis 세션 열기
        SqlSession session = DBCP.getSqlSessionFactory().openSession(true);
        
        // CrewService 객체 생성 (DAO와 세션 연결)
        CrewService crewService = new CrewService(new CrewDAO(session));

        // 요청 파라미터 받아오기
        String interestCategory = request.getParameter("interestCategory");
        String guName = request.getParameter("guName");
        String ageRange = request.getParameter("ageRange");

        // 필터링에 사용할 파라미터들을 Map에 넣기
        Map<String, String> filter = new HashMap<>();
        filter.put("interestCategory", interestCategory);
        filter.put("guName", guName);
        filter.put("ageRange", ageRange);

        // 필터를 이용해 크루 목록 조회
        List<AllCrewVO> crewList = crewService.getCrewsByFilter(filter);
        
        System.out.println(crewList);

        // Gson을 사용하여 List를 JSON 형태로 변환
        Gson gson = new Gson();
        String json = gson.toJson(crewList);

        // 세션 종료
        session.close();

        // JSON 결과 반환
        return json;
    }
}
