package com.crewrung.account.dao;

import java.time.LocalDate;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.crewrung.account.service.FindUserIdService;
import com.crewrung.account.service.FindUserPwService;
import com.crewrung.account.service.JoinService;
import com.crewrung.account.service.LoginService;
import com.crewrung.account.vo.JoinVO;
import com.crewrung.account.vo.LoginVO;
import com.crewrung.account.vo.MypageVO;
import com.crewrung.account.vo.FindUserIdVO;
import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.account.vo.FindUserPwVO;
import com.crewrung.db.DBCP;

public class TestMain {
	public static void main(String[] args) {

		SqlSessionFactory sqlfactory = DBCP.getSqlSessionFactory();
		SqlSession session = sqlfactory.openSession(false);

		AccountDAO dao = new AccountDAO(session);
		
		
//		JoinService service = new JoinService(dao);
//		JoinVO joinVO = new JoinVO("gimsubin94","1234","김소유","kik@gmail.com","010-1234-1234","소유야","여성",
//		5,"당신의 초등학교 이름은?","초초초","2025-04-12",null,null);
//		
//		int result = service.JoinUser(joinVO);
//		if(result == 1){
//			System.out.println("회원가입 성공!");
//		}else{
//			System.out.println("회원가입 실패");
//		}
		
//		LoginService service = new LoginService(dao);
//		
//		LoginVO loginVO = new LoginVO("user01","1234");
//		
//		int result = service.Login(loginVO);
//		if (result ==1){
//			System.out.println(loginVO.getNickname());
//			System.out.println("로그인 성공!");
//		}else{
//			System.out.println("로그인 실패!");
//		}
		
//		FindUserIdService service = new FindUserIdService(dao);
//		
//		FindUserIdVO findUserIdVO = new FindUserIdVO("test@email.com","졸업한 초등학교는?","별빛초등학교");
//		
//		String result = service.getUserId(findUserIdVO);
//		
//		if(result != null){
//			System.out.println("아이디 :" + result);
//		}else{
//			System.out.println("일치하는 정보가 없습니다.");
//		}
		
//		FindUserPwService service = new FindUserPwService(dao);
//		FindUserPwVO findUserPwVO = new FindUserPwVO("gimsubin94","test@email.com");
//		String result = service.getUserPw(findUserPwVO);
//		if(result != null){
//			System.out.println("비밀번호 : " + result);
//		}else{
//			System.out.println("일치하는 정보가 없습니다.");
//		}
	
		// 로그인
//		LoginVO loginVO = new LoginVO("donghyeok981", "FUtDrL6Cv8mZdZ5");
//
//		boolean result = dao.login(loginVO);
//
//		if(result == true){
//			System.out.println("로그인 성공: " + result);
//		}else{
//			System.out.println("로그인 실패");
//		}
//	마이페이지 조회
//		MypageVO mypageVO = new MypageVO("kyeongmin56");
//		MypageVO mypage = dao.getMypage(mypageVO.getUserId());
//		if(mypage != null){
//			if(mypage.getProfileImage() != null){
//				System.out.println(mypage.getProfileImage());
//			}else{
//				System.out.println("이미지가 없습니다.");
//			}
//			if(mypage != null){
//				System.out.println(mypage.getNickname());
//				System.out.println(mypage.getEmail());
//				System.out.println(mypage.getPhoneNumber());
//			}
//			if(mypage.getIntroduction() != null){
//				System.out.println(mypage.getIntroduction());
//			}else{
//				System.out.println("자기소개를 작성하세요");
//			}
//			if(mypage.getCrewNames() != null){
//				System.out.println(mypage.getCrewNames());
//			}
//			if(mypage.getFlashMobTitles() != null){
//				System.out.println(mypage.getFlashMobTitles());
//			}
//		}
//		회원가입
//		JoinVO joinVO = new JoinVO("user12","1234","김소유","kik@gmail.com","010-1234-1234","소유야","여성",
//				1144000000,"당신의 초등학교 이름은?","초초초","2025-04-12",null,null);
		
		// 아이디 삭제 외래키 제약조건 확인 필요 
//		MypageVO mypageVO = new MypageVO("gimsubin94");
//		int removeResult = dao.removeUser(mypageVO);
//		if(removeResult > 0){
//			System.out.println("회원 탈퇴 성공");
//		}else{
//			System.out.println("회원 탈퇴 실패");
//		}

// 마이페이지 이미지, 자기소개 변경		
//		MypageVO setMypage = new MypageVO();
//		setMypage.setUserId("gyeonghyii18");
//		setMypage.setProfileImage("newimage");
//		int setMypageResult = dao.setMypage(setMypage);
//		if(setMypageResult > 0){
//			System.out.println("변경완료");
//		}else{
//			System.out.println("변경실패");
//		}
//	아이디 찾기	
//		UserIdFindVO userIdFindVO = new UserIdFindVO();
//		userIdFindVO.setEmail("yeongilgim@gmail.com");
//		userIdFindVO.setQuestion("졸업한 초등학교는?");
//		userIdFindVO.setAnswer("별빛초등학교");
//		
//		String userId = dao.getUserId(userIdFindVO);
//		if(userId != null){
//			System.out.println("아이디 : " + userId);
//		}else{
//			System.out.println("일치하는 정보가 없습니다.");
//		}
// 비밀번호 찾기
//		UserPwFindVO userPwFindVO = new UserPwFindVO();
//		userPwFindVO.setUserId("gimsubin94");
//		userPwFindVO.setEmail("yeongilgim@gmail.com");
//		
//		String userPw = dao.getUserPw(userPwFindVO);
//		if(userPw != null){
//			System.out.println("비밀번호 : " + userPw);
//		}else{
//			System.out.println("일치하는 아이디나 이메일이 없습니다.");
//		}
		// 구넘버 확인필요
//		UserInfoVO userInfo = new UserInfoVO();
//		userInfo.setUserId("gyeonghyii18");
//		userInfo.setEmail("update@naver.com");
//		userInfo.setGuNumber(1154500000);
//		int setuserInfoResult = dao.setUserInfo(userInfo);
//		if(setuserInfoResult > 0){
//			System.out.println("변경 완료");
//		}else{
//			System.out.println("변경 실패");
//		}
	}
}