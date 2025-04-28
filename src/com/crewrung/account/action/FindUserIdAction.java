package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.FindUserIdService;
import com.crewrung.account.service.MypageInfoService;
import com.crewrung.account.vo.FindUserIdVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class FindUserIdAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		SqlSession sqlsession = DBCP.getSqlSessionFactory().openSession(false);
		AccountDAO dao = new AccountDAO(sqlsession);
		FindUserIdService service = new FindUserIdService(dao);
		
		String email = request.getParameter("email");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		System.out.println(email);
		System.out.println(question);
		System.out.println(answer);
		
		FindUserIdVO vo = new FindUserIdVO();
		vo.setEmail(email);
		vo.setQuestion(question);
		vo.setAnswer(answer);
		
		
		String userId = service.getUserId(vo);
		
		System.out.println(userId);
		
		if(userId != null){
			request.setAttribute("userId", userId);
			sqlsession.commit();
			return "/account/findUserIdSuccess.jsp";
		}else{
			request.setAttribute("errorMsg", "입력하신 정보로 등록된 아이디를 찾을 수 없습니다");
			sqlsession.rollback();
			return "/account/findUserId.jsp";
		}
	}
}
