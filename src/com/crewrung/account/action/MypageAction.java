package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.MypageInfoService;
import com.crewrung.account.vo.MypageVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class MypageAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("userId");
		if(session == null || userId == null){
			request.setAttribute("errorMsg", "로그인 후 마이페이지에 접근 가능합니다.");
			return "/account/login.jsp";
		}
		
		SqlSession sqlsession = DBCP.getSqlSessionFactory().openSession(false);
		AccountDAO dao = new AccountDAO(sqlsession);
		MypageInfoService service = new MypageInfoService(dao);
		
		MypageVO vo = service.getMypageInfo(userId);
		
		request.setAttribute("mypage", vo);

		return "/account/mypage.jsp";
	}

}
