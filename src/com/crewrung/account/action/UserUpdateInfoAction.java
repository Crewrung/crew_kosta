package com.crewrung.account.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.UserUpdateInfoService;
import com.crewrung.account.vo.UserUpdateInfoVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class UserUpdateInfoAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		if(userId == null){
			return "/account/login.jsp";
		}
		
		String userPw = request.getParameter("userPw");
		String userPwCheck = request.getParameter("userPwCheck");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String nickname = request.getParameter("nickname");
		String guName = request.getParameter("guName");
		String introduction = request.getParameter("introduction");
		
		if(!userPw.equals(userPwCheck)){
			request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
			return "/account/editProfile.jsp";
		}

		UserUpdateInfoVO vo = new UserUpdateInfoVO();
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		vo.setUserPwCheck(userPwCheck);
		vo.setEmail(email);
		vo.setPhoneNumber(phoneNumber);
		vo.setNickname(nickname);
		vo.setGuName(guName);
		vo.setIntroduction(introduction);
		
		
		SqlSession sqlsession = DBCP.getSqlSessionFactory().openSession(false);
		AccountDAO dao = new AccountDAO(sqlsession);
		UserUpdateInfoService service = new UserUpdateInfoService(dao); 
		
		int result = service.setUserInfo(vo);
		
		if(result == 1){
			sqlsession.commit();
			return "/account/mypage.jsp";
		}else{
			request.setAttribute("errorMessage", "정보 수정에 실패했습니다");
			return "/account/editProfile.jsp";
		}
	}
}
