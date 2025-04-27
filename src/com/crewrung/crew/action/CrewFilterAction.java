package com.crewrung.crew.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.mybatis.MyBatisUtil;
import com.crewrung.servlet.Action;

public class CrewFilterAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        CrewService service = new CrewService(new CrewDAO(MyBatisUtil.getSqlSession()));

        // Ajax로 받은 필터값
        String interestCategory = request.getParameter("interestCategory");
        String guName = request.getParameter("guName");
        String ageRange = request.getParameter("ageRange");

        HashMap<String, Object> filters = new HashMap<>();
        filters.put("interestCategory", interestCategory);
        filters.put("guName", guName);
        filters.put("ageRange", ageRange);

        List<AllCrewVO> crewList = service.getCrewsByFilter(filters);

        request.setAttribute("crewList", crewList);

        return "crew/crewMainFilter.jsp"; // Ajax 결과로 줄 페이지
    }
}
