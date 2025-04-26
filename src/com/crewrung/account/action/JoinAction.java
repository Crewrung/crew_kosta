package com.crewrung.account.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.JoinService;
import com.crewrung.account.vo.JoinVO;
import com.crewrung.db.DBCP;
import com.crewrung.servlet.Action;

public class JoinAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userPwCheck = request.getParameter("userPwCheck");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String nickname = request.getParameter("nickname");
		String gender = request.getParameter("gender");
		String guName = request.getParameter("guName");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String birthDate = request.getParameter("birthDate");
		
		JoinVO vo = new JoinVO();
		vo.setUserId(userId);
		vo.setUserPw(userPwCheck);
		vo.setName(name);
		vo.setEmail(email);
		vo.setPhoneNumber(phoneNumber);
		vo.setNickname(nickname);
		vo.setGender(gender);
		vo.setGuName(guName);
		vo.setQuestion(question);
		vo.setAnswer(answer);
		vo.setBirthDate(birthDate);
		
		SqlSession sqlsession = DBCP.getSqlSessionFactory().openSession(false);
		AccountDAO dao = new AccountDAO(sqlsession);
		JoinService service = new JoinService(dao);
		
		int result = service.joinUser(vo);
		System.out.println("회원가입 결과: " + result);  // 디버깅용 로그 출력
		if(result == 1){
			return "redirect:/login.jsp";
		}else{
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다. 정보를 다시 확인해주세요");
			return "join.jsp";
		}
	}

}
