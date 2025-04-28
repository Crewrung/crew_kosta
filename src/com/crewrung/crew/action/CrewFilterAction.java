package com.crewrung.crew.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action; // Action 인터페이스
import com.crewrung.crew.service.CrewService; // CrewService 경로 확인
import com.crewrung.crew.vo.AllCrewVO; // VO 경로 확인
import com.google.gson.Gson;

public class CrewFilterAction implements Action {

    private CrewService crewService = new CrewService();

    @Override
    public String execute(HttpServletRequest request) {
        String interestCategory = request.getParameter("interestCategory");
        String guName = request.getParameter("guName");
        String ageRange = request.getParameter("ageRange");
        String sortOption = request.getParameter("sortOption"); // ✅ sortOption 추가

        HashMap<String, Object> filters = new HashMap<>();
        filters.put("interestCategory", interestCategory);
        filters.put("guName", guName);
        filters.put("ageRange", ageRange);
        filters.put("sortOption", sortOption); // ✅ filters에 추가

        List<AllCrewVO> crewList = crewService.getCrewsByFilter(filters);

        Gson gson = new Gson();
        String json = gson.toJson(crewList);

        return json; // FrontController가 이 JSON 문자열을 그대로 응답
    }
}
