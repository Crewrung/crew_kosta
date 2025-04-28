package com.crewrung.crew.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.CrewVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class AddCrewAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        try (SqlSession session = DBCP.getSqlSessionFactory().openSession(true)) {
            CrewService crewService = new CrewService(new CrewDAO(session));
            CrewVO crewVO = new CrewVO();

            // 필수 파라미터 확인
            String crewName = getRequiredParam(request, "crewName");
            if (crewName == null) return "crew/crewAddResult.jsp";
            crewVO.setCrewName(crewName);

            String crewLeaderId = getRequiredParam(request, "crewLeaderId");
            if (crewLeaderId == null) return "crew/crewAddResult.jsp";
            crewVO.setCrewLeaderId(crewLeaderId);

            crewVO.setIntroduction(request.getParameter("introduction"));
            crewVO.setInterestCategory(request.getParameter("interestCategory"));
            crewVO.setAgeRange(request.getParameter("ageRange"));
            crewVO.setImage(request.getParameter("image"));

            String isPromotionParam = request.getParameter("isPromotion");
            crewVO.setIsPromotion((isPromotionParam != null && !isPromotionParam.isEmpty()) ? isPromotionParam.charAt(0) : 'N');

            String guNumberParam = request.getParameter("guNumber");
            if (guNumberParam == null || guNumberParam.isEmpty()) {
                request.setAttribute("errorMessage", "모임 지역(구 번호)을 선택해 주세요.");
                request.setAttribute("redirectUrl", request.getContextPath() + "/crew/crewAddPage.html");
                return "crew/crewAddResult.jsp";
            }
            crewVO.setGuNumber(Integer.parseInt(guNumberParam));

            int result = crewService.addCrew(crewVO);

            if (result > 0) {
                request.setAttribute("successMessage", "크루가 정상적으로 생성되었습니다.");
                request.setAttribute("redirectUrl", request.getContextPath() + "/controller?cmd=crewUI");
            } else {
                request.setAttribute("errorMessage", "크루 생성에 실패했습니다.");
                request.setAttribute("redirectUrl", request.getContextPath() + "/crew/crewAddPage.html");
            }

            return "crew/crewAddResult.jsp";
        }
    }

    private String getRequiredParam(HttpServletRequest request, String paramName) {
        String value = request.getParameter(paramName);
        if (value == null || value.trim().isEmpty()) {
            request.setAttribute("errorMessage", paramName + " 파라미터가 누락되었습니다.");
            request.setAttribute("redirectUrl", request.getContextPath() + "/crew/crewAddPage.html");
            return null;
        }
        return value;
    }
}
