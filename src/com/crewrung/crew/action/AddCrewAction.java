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

            CrewVO crewVO = createCrewVOFromRequest(request);
            if (crewVO == null) {
                // 필수값 누락 오류가 발생하면 crewAddResult.jsp로 포워딩됨
                return "crew/crewAddResult.jsp";
            }

            int result = crewService.addCrew(crewVO);

            if (result > 0) {
                setSuccessMessage(request, "크루가 정상적으로 생성되었습니다.", request.getContextPath() + "/controller?cmd=crewUI");
            } else {
                setErrorMessage(request, "크루 생성에 실패했습니다.", request.getContextPath() + "/crew/crewAddPage.html");
            }

            return "crew/crewAddResult.jsp";
        }
    }

    private CrewVO createCrewVOFromRequest(HttpServletRequest request) {
        CrewVO crewVO = new CrewVO();

        String crewName = getRequiredParam(request, "crewName");
        String crewLeaderId = getRequiredParam(request, "crewLeaderId");
        String guNumberParam = getRequiredParam(request, "guNumber");

        if (crewName == null || crewLeaderId == null || guNumberParam == null) {
            return null;
        }

        crewVO.setCrewName(crewName);
        crewVO.setCrewLeaderId(crewLeaderId);
        crewVO.setIntroduction(getOptionalParam(request, "introduction"));
        crewVO.setInterestCategory(getOptionalParam(request, "interestCategory"));
        crewVO.setAgeRange(getOptionalParam(request, "ageRange"));
        crewVO.setImage(getOptionalParam(request, "image"));
        crewVO.setPromotionMessage(getOptionalParam(request, "promotionMessage"));
        crewVO.setIsPromotion(parsePromotionFlag(request.getParameter("isPromotion")));
        crewVO.setGuNumber(Integer.parseInt(guNumberParam));
        System.out.println(crewVO);
        return crewVO;
    }

    private String getRequiredParam(HttpServletRequest request, String paramName) {
        String value = request.getParameter(paramName);
        if (value == null || value.trim().isEmpty()) {
            setErrorMessage(request, paramName + " 파라미터가 누락되었습니다.", request.getContextPath() + "/crew/crewAddPage.html");
            return null;
        }
        return value.trim();
    }

    private String getOptionalParam(HttpServletRequest request, String paramName) {
        String value = request.getParameter(paramName);
        return (value != null && !value.trim().isEmpty()) ? value.trim() : null;
    }

    private char parsePromotionFlag(String isPromotionParam) {
        return (isPromotionParam != null && isPromotionParam.equalsIgnoreCase("Y")) ? 'Y' : 'N';
    }

    private void setErrorMessage(HttpServletRequest request, String message, String redirectUrl) {
        request.setAttribute("errorMessage", message);
        request.setAttribute("redirectUrl", redirectUrl);
    }

    private void setSuccessMessage(HttpServletRequest request, String message, String redirectUrl) {
        request.setAttribute("successMessage", message);
        request.setAttribute("redirectUrl", redirectUrl);
    }
}
