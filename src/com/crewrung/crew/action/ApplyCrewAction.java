package com.crewrung.crew.action;

import javax.servlet.http.HttpServletRequest;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.CrewApplicationVO;
import com.crewrung.servlet.Action;

public class ApplyCrewAction implements Action {
	private CrewService crewService;

	public ApplyCrewAction(CrewService crewService) {
		this.crewService = crewService;
	}

	public ApplyCrewAction() {}

	@Override
	public String execute(HttpServletRequest request) {
		CrewApplicationVO vo = new CrewApplicationVO();
		vo.setCrewNumber(Integer.parseInt(request.getParameter("crewNumber")));
		vo.setUserId(request.getParameter("userId"));
		vo.setIntroduction(request.getParameter("introduction"));

		int result = crewService.applyToCrew(vo);

		if (result > 0) {
			return "crewApplyResult.jsp?message=크루 가입 신청이 완료되었습니다.&redirectUrl=crewDetail.jsp";
		} else {
			return "crewApplyResult.jsp?message=크루 가입 신청에 실패했습니다.&redirectUrl=joinCrewForm.jsp";
		}
	}
}
