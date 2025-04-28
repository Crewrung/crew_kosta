package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crewrung.servlet.Action;

public class MypageUIAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		if(session == null || userId == null){
			request.setAttribute("errorMsg", "로그인 후 마이페이지에 접근 가능합니다.");
			return "/account/login.jsp";
		}
		return "/account/mypage.jsp";
	}
}
