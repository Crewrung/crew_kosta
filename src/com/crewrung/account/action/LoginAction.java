package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.LoginService;
import com.crewrung.account.vo.LoginVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		SqlSession sqlsession = DBCP.getSqlSessionFactory().openSession(false);
		LoginVO vo = new LoginVO(userId, userPw);
		AccountDAO dao = new AccountDAO(sqlsession);
		LoginService service = new LoginService(dao);
		
		int result = service.Login(vo);
		
		if(result == 1){
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", userId);
			session.setAttribute("nickname", vo.getNickname());
			return "/index.jsp";
		}else{
			request.setAttribute("errorMsg", "로그인 실패");
			return "/account/login.jsp";
		}
	}
}
