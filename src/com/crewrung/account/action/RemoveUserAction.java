package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.RemoveUserService;
import com.crewrung.account.vo.UserUpdateInfoVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class RemoveUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {


		HttpSession session = request.getSession(false);
		if(session == null){
			request.setAttribute("errorMsg", "로그인 후 회원탈퇴에 접근 가능합니다.");
			return "/account/login.jsp";
		}
		
		String userId = (String) session.getAttribute("userId");
		if(userId == null){
			request.setAttribute("errorMsg", "로그인 후 회원탈퇴에 접근 가능합니다.");
			return "/account/login.jsp";
		}
		String userPw = request.getParameter("userPw");
		
		if (userPw == null || userPw.trim().isEmpty()) {
		    request.setAttribute("errorMsg", "비밀번호를 입력해 주세요.");
		    return "/account/deleteAccount.jsp";
		    
		}

		SqlSession sqlsession = DBCP.getSqlSessionFactory().openSession(false);
		AccountDAO dao = new AccountDAO(sqlsession);
		RemoveUserService service = new RemoveUserService(dao);


		UserUpdateInfoVO vo = new UserUpdateInfoVO();
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		
		int result = service.removeUser(vo);
		if(result == 1){
			sqlsession.commit();
			session.invalidate();
			return "/account/goodbye.jsp";
		}else{
			request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
            return "/account/deleteAccount.jsp";
		}
	}
}
