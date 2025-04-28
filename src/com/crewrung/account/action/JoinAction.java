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
		System.out.println("비밀번호 확인" + userPwCheck);
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
		vo.setUserPw(userPw);
		vo.setUserPwCheck(userPwCheck);
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
		
		
		try {
			System.out.println("아이디: " + vo.getUserId());
			System.out.println("비밀번호: " + vo.getUserPw());
			System.out.println("비밀번호 확인: " + vo.getUserPwCheck());
			System.out.println("이름: " + vo.getName());
			System.out.println("이메일: " + vo.getEmail());
			System.out.println("전화번호: " + vo.getPhoneNumber());
			System.out.println("닉네임: " + vo.getNickname());
			System.out.println("성별: " + vo.getGender());
			System.out.println("구 이름: " + vo.getGuName());
			System.out.println("질문: " + vo.getQuestion());
			System.out.println("답변: " + vo.getAnswer());
			System.out.println("생년월일: " + vo.getBirthDate());
			
			int result = service.joinUser(vo);
			System.out.println("회원가입 결과: " + result);  // 디버깅용 로그 출력
			
			if(result == 1){
				sqlsession.commit();
				return "/account/login.jsp";
			}else{
				request.setAttribute("errorMsg", "회원가입에 실패하였습니다. 정보를 다시 확인해주세요");
				return "/account/join.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/account/join.jsp";
	}

}
