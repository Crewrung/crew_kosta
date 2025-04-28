package com.crewrung.crew.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.CrewVO;
import com.crewrung.mybatis.MyBatisUtil;
import com.crewrung.servlet.Action;

public class AddCrewAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        CrewService service = new CrewService(new CrewDAO(MyBatisUtil.getSqlSession()));

        CrewVO crewVO = new CrewVO();
        crewVO.setCrewName(request.getParameter("crewName"));
        crewVO.setCrewLeaderId(request.getParameter("crewLeaderId"));
        crewVO.setIntroduction(request.getParameter("introduction"));
        crewVO.setInterestCategory(request.getParameter("interestCategory"));
        crewVO.setAgeRange(request.getParameter("ageRange"));
        crewVO.setImage(request.getParameter("image")); // 파일 이름만 넘어온다고 가정

        String isPromotionParam = request.getParameter("isPromotion");
        if (isPromotionParam != null && !isPromotionParam.isEmpty()) {
            crewVO.setIsPromotion(isPromotionParam.charAt(0));
        } else {
            crewVO.setIsPromotion('N');
        }

        crewVO.setGuNumber(Integer.parseInt(request.getParameter("guNumber")));

        int result = service.addCrew(crewVO);

        if (result > 0) {
            return "crew/crewAddResult.jsp?message=크루가 성공적으로 생성되었습니다.&redirectUrl=/crew/crewMainUI.jsp";
        } else {
            return "crew/crewAddResult.jsp?message=크루 생성에 실패했습니다.&redirectUrl=/crew/crewAddPage.html";
        }
    }
}
