package test.com.crewrung.crew.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.vo.ApplyCrewMeetingVO;
import com.crewrung.crew.vo.CrewAppliesVO;
import com.crewrung.crew.vo.CrewMeetingVO;
import com.crewrung.crew.vo.CrewMemberVO;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.vo.FlashMobMainViewVO;
import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.crew.vo.CrewApplicationVO;
import com.crewrung.crew.vo.CrewCommentVO;
import com.crewrung.crew.vo.CrewLeaderVO;
import com.crewrung.crew.vo.CrewManagePageVO;
import com.crewrung.crew.vo.CrewVO;
import com.crewrung.crew.vo.PromotionVO;
import com.crewrung.db.DBCP;

public class CrewDAOTest {
	private SqlSession session;
	private CrewDAO dao;

	@Before
	public void setUp() throws Exception {
		session = DBCP.getSqlSessionFactory().openSession(true);
		dao = new CrewDAO(session);
	}

	@After
	public void tearDown() throws Exception {
		if (session != null) {
			session.rollback(); // 테스트 끝나면 롤백
			session.close();
		}
	}

//	@Test
//	public void successSetCrewMeeting() {
//		assertTrue(dao.setCrewMeeting(new CrewMeetingVO("", "새 제목", "새 내용", "2025-01-11", 6, 1111000000, 2)));
//	}
//
//	@Test
//	public void failSetCrewMeeting() {
//		try {
//			dao.setCrewMeeting(new CrewMeetingVO("", "새 제목", "새 내용", "2025-12-11", 6, 1000000, 2));
//		} catch (Exception e) {
//			assertTrue(e.getClass() == PersistenceException.class);
//		}
//	}
//
//	@Test
//	public void successApplyCrewMeeting() {
//		assertTrue(dao.applyCrewMeeting(new ApplyCrewMeetingVO(11, 31)));
//	}
//
//	@Test
//	public void failApplyCrewMeeting() {
//		try {
//			dao.applyCrewMeeting(new ApplyCrewMeetingVO(1, 2));
//		} catch (Exception e) {
//			assertTrue(e.getClass() == PersistenceException.class);
//		}
//	}
//	
//	@Test
//	public void successGetCrewMeetingParticipants() {
//		assertNotNull(dao.getCrewMeetingParticipants(4));
//	}
//	
//	@Test
//	public void failGetCrewMeetingParticipants() {
//		assertEquals(dao.getCrewMeetingParticipants(343243).size(),0);
//	}
//	
//	@Test
//	public void successGetCrewMeetingHost() {
//		assertNotNull(dao.getCrewMeetingHost(1));
//	}
//	
//	@Test
//	public void failGetCrewMeetingHost() {
//		assertNull(dao.getCrewMeetingHost(23323));
//	}
	
//	@Test
//	public void successAddCrewMeeting() {
//		assertTrue(dao.addCrewMeeting(new CrewMeetingVO("축구 경기 보러가실분", "잠실 고고혓", "2025-04-30", 4, 1, 11, 1171000000)));
//	}
//	
//	@Test
//	public void failAddCrewMeeting() {
//		try {
//			dao.addCrewMeeting(new CrewMeetingVO("축구 경기 보러가실분", "잠실 고고혓", "2025-04-30", 4, 1, 11, 232332));
//		} catch (Exception e) {
//			assertTrue(e.getClass() == PersistenceException.class);
//		}
//	}
	
//	@Test
//	public void successGetCrewMeeting() {
//		assertNotNull(dao.getCrewMeeting(50));
//	}
	
//	@Test
//	public void failGetCrewMeeting() {
//		assertNull(dao.getCrewMeeting(3232233));
//	}
	
//	@Test
//	public void successGetCrewMeetingInfo() {
//		assertNotNull(dao.getCrewMeetingsInfo(1));
//	}
	
//	@Test
//	public void failGetCrewMeetingInfo() {
//		assertEquals(dao.getCrewMeetingsInfo(12234).size(), 0);
//	}
	
//	@Test
//	public void successRemoveCrewApplies() {
//		assertTrue(dao.removeCrewApplies(new CrewAppliesVO(301, 1)));
//	}
//	
//	@Test
//	public void failRemoveCrewApplies() {
//		assertFalse(dao.removeCrewApplies(new CrewAppliesVO(301, 3213121)));
//	}
	
//	@Test
//	public void successAddCrewMember() {
//		assertTrue(dao.addCrewMember(new CrewMemberVO(1, "gaerin01")));
//	}
//	
//	@Test
//	public void failAddCrewMember() {
//		try{
//			dao.addCrewMember(new CrewMemberVO(1, "gaerin01"));
//		}catch(Exception e){
//			assertTrue(e.getClass() == PersistenceException.class);
//		}
//		
//	}
	
//	@Test
//	public void successRemoveCrewMember() {
//		assertTrue(dao.removeCrewMember(new CrewMemberVO(1, 3)));
//	}
//	
//	@Test
//	public void failRemoveCrewMember() {
//		assertFalse(dao.removeCrewMember(new CrewMemberVO(30231, 3213121)));
//	}
	
	@Test //홍보하는 크루정보 조회(기댓값이 옳지 않은 경우)
	public void 홍보크루정보조회테스트실패() {
		List<PromotionVO> result = dao.getAllPromotionCrew();
		assertNotEquals(7, result.size());
	}

	@Test //홍보하는 크루정보 조회(기댓값이 옳은 경우)
	public void 홍보크루정보조회테스트성공() {
		List<PromotionVO> result = dao.getAllPromotionCrew();
		assertEquals(6, result.size());
	}

	@Test //모든 크루정보 조회(기댓값이 옳지 않은 경우)
	public void 모든크루정보조회테스트실패() {
		List<AllCrewVO> result = dao.getAllCrew();
		assertNotEquals(9, result.size());
	}

	@Test //모든 크루정보 조회(기댓값이 옳은 경우)
	public void 모든크루정보조회테스트성공() {
		List<AllCrewVO> result = dao.getAllCrew();
		assertNotEquals(10, result.size());
	}

	@Test //필터 적용된 모든 크루정보 조회(기댓값이 옳지 않은 경우)
	public void 필터적용된모든크루정보조회테스트실패() {
		Map<String, String> filter = new HashMap<>();
		filter.put("interestCategory", null);
		filter.put("guName", "마포구");
		filter.put("ageRange", null);
		List<AllCrewVO> result = dao.getAllCrewByFilter(filter);
		boolean found = result.stream()
				.anyMatch(crew -> "용산구".equals(crew.getGuName()));
		assertFalse(found);
	}

	@Test //필터 적용된 모든 크루정보 조회(기댓값이 옳은 경우)
	public void 필터적용된모든크루정보조회테스트성공() {
		Map<String, String> filter = new HashMap<>();
		filter.put("interestCategory", "운동");
		filter.put("guName", "송파구");
		List<AllCrewVO> result = dao.getAllCrewByFilter(filter);
		boolean found = result.stream()
				.anyMatch(crew -> "슬램덩크".equals(crew.getCrewName()));
		assertTrue(found);
	}

	@Test //크루 상세정보 조회(기댓값이 옳지 않은 경우)
	public void 크루상세정보조회테스트실패() {
		AllCrewVO result = dao.getCrewDetail(7);
		assertNotEquals("슬램덩크", result.getCrewName());
	}

	@Test //크루 상세정보 조회(기댓값이 옳은 경우)
	public void 크루상세정보조회테스트성공() {
		AllCrewVO result = dao.getCrewDetail(7);
		assertEquals("북적북적", result.getCrewName());
	}

	@Test //크루장 정보 조회(기댓값이 옳지 않은 경우)
	public void 크루장정보조회테스트실패() {
		CrewLeaderVO result = dao.getCrewLeader(7);
		assertNotEquals("이상혁", result.getName());
	}

	@Test //크루장 정보 조회(기댓값이 옳은 경우)
	public void 크루장정보조회테스트성공() {
		CrewLeaderVO result = dao.getCrewLeader(7);
		assertEquals("이우진", result.getName());
	}

	@Test //크루 생성하기(기댓값이 옳지 않은 경우)
	public void 크루생성테스트실패() {
		int result = 0;
		result = dao.addCrew(new CrewVO("북적북적", "kyeongmin56", "함께 모여 북적북적 활동해요!", "운동", "20대-30대", "crew1.jpg", "지금 바로 참여하세요!", 'Y', 1111000000));
		assertNotEquals(result, 1);
	}

	@Test //크루 생성하기(기댓값이 옳은 경우)
	public void 크루생성테스트성공() {
		int result = 0;
		result = dao.addCrew(new CrewVO("북적북작", "kyeongmin56", "함께 모여 북적북적 활동해요!", "운동", "20대-30대", "crew11jpg", "지금 바로 참여하세요!", 'Y', 1111000000));
		assertEquals(result, 1);
	}

	@Test //크루 수정하기(기댓값이 옳지 않은 경우)
	public void 크루수정테스트실패() {
		int result = 0;
		result = dao.updateCrew(new CrewVO(11, "북적북적", "kyeongmin56", "함께 모여 북적북적 활동해요!", "운동", "20대-30대", "crew1.jpg", "지금 바로 참여하세요!", 'Y', 1111000000));
		assertNotEquals(result, 0);
	}

	@Test //크루 수정하기(기댓값이 옳은 경우)
	public void 크루수정테스트성공() {
		int result = 0;
		result = dao.updateCrew(new CrewVO(7, "북적북적", "kyeongmin56", "함께 모여 북적북적 활동해요!", "운동", "20대-30대", "crew1.jpg", "지금 바로 참여하세요!", 'Y', 1111000000));
		assertEquals(result, 1);
	}

	@Test //크루 전체 댓글 개수 조회(기댓값이 옳지 않은 경우)
	public void 크루댓글개수조회테스트실패() {
		int result = 0;
		result = dao.getCommentCount(5);
		assertNotEquals(result, 1);
	}

	@Test //크루 전체 댓글 개수 조회(기댓값이 옳은 경우)
	public void 크루댓글개수조회테스트성공() {
		int result = 0;
		result = dao.getCommentCount(5);
		assertEquals(result, 2);
	}

	@Test //크루 댓글 작성자정보 및 댓글 내용 조회(기댓값이 옳지 않은 경우)
	public void 크루댓글내용조회테스트실패() {
		List<CrewCommentVO> result = new ArrayList<>();
		result = dao.getCrewCommentDetail(9);
		boolean found = result.stream()
				.anyMatch(crew -> "leesanghyeok".equals(crew.getNickname()));
		assertTrue(found);
	}

	@Test //크루 댓글 작성자정보 및 댓글 내용 조회(기댓값이 옳은 경우)
	public void 크루댓글내용조회테스트성공() {
		List<CrewCommentVO> result = new ArrayList<>();
		result = dao.getCrewCommentDetail(9);
		boolean found = result.stream()
				.anyMatch(crew -> "sgim".equals(crew.getNickname()));
		assertTrue(found);
	}

	@Test //크루 가입 신청(기댓값이 옳지 않은 경우)
	public void 크루가입신청테스트실패() {
		int result = 0;
		result = dao.applyToCrew(new CrewApplicationVO(8, "cunjabag4556", "운동 좋아요. 함께 해요!"));
		assertNotEquals(result, 1);
	}

	@Test //크루 가입 신청(기댓값이 옳은 경우)
	public void 크루가입신청테스트성공() {
		int result = 0;
		result = dao.applyToCrew(new CrewApplicationVO(8, "cunjabag45", "운동 좋아요. 함께 해요!"));
		assertEquals(result, 1);
	}

	@Test //크루 관리페이지 조회(크루가입신청자)(기댓값이 옳지 않은 경우)
	public void 크루관리페이지의크루가입신청자조회테스트실패() {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = dao.getCrewApplicants(1);
		boolean found = result.stream()
				.anyMatch(crew -> "jseo1".equals(crew.getNickname()));
		assertFalse(found);
	}

	@Test //크루 관리페이지 조회(크루가입신청자)(기댓값이 옳은 경우)
	public void 크루관리페이지의크루가입신청자조회테스트성공() {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = dao.getCrewApplicants(1);
		boolean found = result.stream()
				.anyMatch(crew -> "jseo".equals(crew.getNickname()));
		assertTrue(found);
	}

	@Test //크루 관리페이지 조회(크루원)(기댓값이 옳지 않은 경우)
	public void 크루관리페이지의크루원조회테스트실패() {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = dao.getCrewMember(2);
		boolean found = result.stream()
				.anyMatch(crew -> "ygim1".equals(crew.getNickname()));
		assertFalse(found);
	}

	@Test //크루 관리페이지 조회(크루원)(기댓값이 옳은 경우)
	public void 크루관리페이지의크루원조회테스트성공() {
		List<CrewManagePageVO> result = new ArrayList<>();
		result = dao.getCrewMember(2);
		boolean found = result.stream()
				.anyMatch(crew -> "ygim".equals(crew.getNickname()));
		assertTrue(found);
	}
}
