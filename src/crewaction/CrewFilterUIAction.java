package com.crewrung.crew.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.AllCrewVO;
import com.google.gson.Gson;

public class CrewFilterUIAction implements Action {

    private CrewService crewService = new CrewService();

    @Override
    public String execute(HttpServletRequest request) {
        String interestCategory = request.getParameter("interestCategory");
        String guName = request.getParameter("guName");
        String ageRange = request.getParameter("ageRange");

        HashMap<String, Object> filters = new HashMap<>();
        filters.put("interestCategory", interestCategory);
        filters.put("guName", guName);
        filters.put("ageRange", ageRange);

        List<AllCrewVO> crewList = crewService.getCrewsByFilter(filters);

        Gson gson = new Gson();
        String json = gson.toJson(crewList);

        return json; // 이 반환값이 FrontController에서 그대로 response로 전송된다
    }
}
