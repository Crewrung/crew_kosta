package test.com.crewrung.account.service;

import static org.junit.Assert.*;

import org.apache.ibatis.annotations.TypeDiscriminator;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.service.FindUserIdService;
import com.crewrung.account.service.FindUserPwService;
import com.crewrung.account.service.JoinService;
import com.crewrung.account.service.LoginService;
import com.crewrung.account.service.MypageInfoService;
import com.crewrung.account.service.MypageInfoUpdateService;
import com.crewrung.account.service.RemoveUserService;
import com.crewrung.account.service.UserInfoUpdateService;
import com.crewrung.account.vo.FindUserIdVO;
import com.crewrung.account.vo.FindUserPwVO;
import com.crewrung.account.vo.JoinVO;
import com.crewrung.account.vo.LoginVO;
import com.crewrung.account.vo.MypageVO;
import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.db.DBCP;

public class AccountServiceTest {
	
	private SqlSession session;
	private AccountDAO accountDAO;

	@Before
	public void setUp() throws Exception {
		session = DBCP.getSqlSessionFactory().openSession(false);
		accountDAO = new AccountDAO(session);
	}


	@After
	public void tearDown() throws Exception {
		if (session != null) {
			session.rollback();
			session.close();
		}
	}
	
	// 회원가입 성공 테스트
	@Test
	public void testSuccussJoin(){
		JoinService service = new JoinService(accountDAO);
		JoinVO joinVO = new JoinVO();
		joinVO.setUserId("testId");
		joinVO.setUserPw("Ek9EfRyM2G");
		joinVO.setName("김상목");
		joinVO.setEmail("gkskekfk@email.com");
		joinVO.setPhoneNumber("010-1234-1234");
		joinVO.setNickname("상목일");
		joinVO.setGender("남성");
		joinVO.setGuName("금천구");
		joinVO.setQuestion("졸업한 초등학교는?");
		joinVO.setAnswer("진명초등학교");
		joinVO.setBirthDate("1998-09-15");
		joinVO.setIntroduction(null);
		joinVO.setProfileImage(null);
		
		int result = service.joinUser(joinVO);
		assertEquals(1, result);
	}
	
	// 회원가입 아이디 중복 테스트 (아이디, 이메일, 닉네임 셋중 하나라도 중복이라면 0을 리턴 셋다 중복이 아니라면 1리턴
//	@Test
//	public void testFailIdJoin(){
//		JoinService service = new JoinService(accountDAO);
//		JoinVO joinVO = new JoinVO();
//		joinVO.setUserId("gyeonghyii18");
//		joinVO.setUserPw("Ek9EfRyM2G");
//		joinVO.setName("김상목");
//		joinVO.setEmail("asdfad@email.com");
//		joinVO.setPhoneNumber("010-1234-1234");
//		joinVO.setNickname("상목일");
//		joinVO.setGender("남성");
//		joinVO.setGuNumber(1144000000);
//		joinVO.setQuestion("졸업한 초등학교는?");
//		joinVO.setAnswer("진명초등학교");
//		joinVO.setBirthDate("1998-09-15");
//		joinVO.setIntroduction(null);
//		joinVO.setProfileImage(null);
//		
//		int result = service.joinUser(joinVO);
//		assertEquals(1, result);
//	}
	
	// 로그인 성공 테스트
//	@Test
//	public void testSuccessLogin(){
//		LoginService service = new LoginService(accountDAO);
//		LoginVO loginVO = new LoginVO();
//		loginVO.setUserId("gyeonghyii18");
//		loginVO.setUserPw("Xx4GNd1UnawlZWFNFdbI");
//		int result = service.Login(loginVO);
//		assertEquals(1, result);
//	}
	
	// 로그인 실패 테스트
//	@Test
//	public void testFailLogin(){
//		LoginService service = new LoginService(accountDAO);
//		LoginVO loginVO = new LoginVO();
//		loginVO.setUserId("FakeId");
//		loginVO.setUserPw("FakePw");
//		int result = service.Login(loginVO);
//		assertEquals(1, result);
//	}
	
	// 아이디찾기 성공 테스트
//	@Test
//	public void testSuccessFindUserId(){
//		FindUserIdService service = new FindUserIdService(accountDAO);
//		FindUserIdVO vo = new FindUserIdVO();
//		vo.setEmail("test@email.com");
//		vo.setQuestion("졸업한 초등학교는?");
//		vo.setAnswer("별빛초등학교");
//		String result = service.getUserId(vo);
//		assertNotNull(result);
//		assertEquals("gimsubin94", result);
//	}
	
	// 아이디찾기 실패 테스트
//	@Test
//	public void testFailFindUserId(){
//		FindUserIdService service = new FindUserIdService(accountDAO);
//		FindUserIdVO vo = new FindUserIdVO();
//		vo.setEmail("Fail@email.com");
//		vo.setQuestion("실패용질문");
//		vo.setAnswer("실패용답변");
//		String result = service.getUserId(vo);
//		assertNotNull(result);
//		assertEquals("gimsubin94", result);
//	}
	
	// 비밀번호 찾기 성공 테스트
//	@Test
//	public void testSuccessFindUserPw(){
//		FindUserPwService service = new FindUserPwService(accountDAO);
//		FindUserPwVO vo = new FindUserPwVO();
//		vo.setUserId("gimsubin94");
//		vo.setEmail("test@email.com");
//		String result = service.getUserPw(vo);
//		assertNotNull(result);
//		assertEquals("Ek9EfRyM2G", result);
//	}
	
	// 비밀번호 찾기 실패 테스트
//	@Test
//	public void testFailFindUserPw(){
//		FindUserPwService service = new FindUserPwService(accountDAO);
//		FindUserPwVO vo = new FindUserPwVO();
//		vo.setUserId("FailId");
//		vo.setEmail("Fail@email.com");
//		String result = service.getUserPw(vo);
//		assertNotNull(result);
//		assertEquals("Ek9EfRyM2G", result);
//	}
	
	// 마이페이지 조회
	@Test
	public void testGetMypageInfo(){
		MypageInfoService service = new MypageInfoService(accountDAO);
		String userId = "chungyun22";
		MypageVO result = service.getMypageInfo(userId);
		assertNotNull(result);
		System.out.println("이미지 : " + result.getProfileImage());
		System.out.println(result.getUserId());
		System.out.println(result.getNickname());
		System.out.println(result.getPhoneNumber());
		System.out.println(result.getEmail());
		System.out.println(result.getIntroduction());
		System.out.println(result.getCrewNames());
		System.out.println(result.getFlashMobTitles());
	}
	
	// 마이페이지 이미지, 자기소개 수정
	@Test
	public void testSetMypageInfo(){
		MypageInfoUpdateService service = new MypageInfoUpdateService(accountDAO);
		MypageVO vo = new MypageVO();
		vo.setUserId("gimsubin94");
		vo.setProfileImage("update.jpg");
		vo.setIntroduction("자기소개할게요");
		int result = service.setMypageInfo(vo);
		assertEquals(1, result);
	}
	
	// 회원탈퇴
	@Test
	public void testRemoveUser(){
		RemoveUserService service = new RemoveUserService(accountDAO);
		MypageVO vo = new MypageVO();
		vo.setUserId("gimsubin94");
		
		try {
			System.out.println("삭제전");
			int result = accountDAO.removeUser(vo);
			System.out.println("삭제 결과 : " + result);
			assertEquals(1, result);
		} catch (Exception e) {
			System.out.println("예외");
			e.printStackTrace();
			fail("예외발생 : " + e.getMessage());
		}
	}
	
	// 개인정보 수정
	@Test
	public void testUserInfoUpdate(){
		UserInfoUpdateService service = new UserInfoUpdateService(accountDAO);
		String userId = "jia1294";
		UserInfoVO vo = new UserInfoVO(userId);
		vo.setUserPw("tmp1234");
		vo.setEmail("tmp@email.com");
		vo.setPhoneNumber("010-1234-1232");
		vo.setNickname("업데이트");
		vo.setGuNumber(1159000000);
		
		int result = service.setUserInfoUpdate(vo);
		
		assertEquals(1, result);
		
		
		
	}

	
}
