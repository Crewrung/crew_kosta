package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.FindUserPwService;
import com.crewrung.account.vo.FindUserPwVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class FindUserPwAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		SqlSession sqlsession = DBCP.getSqlSessionFactory().openSession(false);
		AccountDAO dao = new AccountDAO(sqlsession);
		FindUserPwService service = new FindUserPwService(dao);
		FindUserPwVO vo = new FindUserPwVO();
		
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		
		vo.setUserId(userId);
		vo.setEmail(email);
		
		String userPw = service.getUserPw(vo);
		
		if(userPw != null){
			request.setAttribute("userPw", userPw);
			sqlsession.commit();
			return "/account/findUserPwSuccess.jsp";
		}else{
			request.setAttribute("errorMsg", "입력한 정보가 올바르지 않습니다.");
			return "/account/findUserPw.jsp";
		}
	}

}
