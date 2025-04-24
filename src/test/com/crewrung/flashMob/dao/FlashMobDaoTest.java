package test.com.crewrung.flashMob.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.vo.FlashMobCommentVO;
import com.crewrung.flashMob.vo.FlashMobMainViewVO;
import com.crewrung.flashMob.vo.FlashMobParticipantVO;
import com.crewrung.flashMob.vo.FlashMobVO;

public class FlashMobDaoTest {
	private SqlSession session;
	private FlashMobDAO dao;

	@Before
	public void setUp() throws Exception {
		session = DBCP.getSqlSessionFactory().openSession(false);
		dao = new FlashMobDAO(session);
	}


	 @After
	 public void tearDown() throws Exception {
		 if (session != null) {
	        session.rollback(); // �뀒�뒪�듃 �걹�굹硫� 濡ㅻ갚
	        session.close();
	       }
	 }

	 @Test
	 public void getAllBoardCommentCreate() {
	   List<FlashMobMainViewVO> result = dao.getAllFlashMobs();
	   assertTrue(result.size() == 30);
	 }
	 
	@After
	public void tearDown1() throws Exception {
		if (session != null) {
			session.rollback(); // 테스트 끝나면 롤백
			session.close();
		}
	}

	@Test
	public void successGetAllFlashMobs() {
		List<FlashMobMainViewVO> result = dao.getAllFlashMobs();
		assertTrue(result.size() == 30);
	}

	@Test
	public void successGetAllFlashMobsByFilter() {
		Map<String, String> filter = new HashMap<>();
		filter.put("interestCategory", "운동");
		filter.put("guName", null);
		filter.put("ageRange", null);
		filter.put("maxMember", null);
		filter.put("minMember", "6");

		List<FlashMobMainViewVO> result = dao.getAllFlashMobsByFilter(filter);

		assertTrue(result.size() == 7);
		assertTrue(result.get(6).getFlashMobNumber() == 4);
	}

	@Test
	public void failGetAllFlashMobsByFilter() {
		Map<String, String> filter = new HashMap<>();
		filter.put("interestCategory", "");
		filter.put("guName", "");
		filter.put("ageRange", "");
		filter.put("maxMember", "");
		filter.put("minMember", "");

		List<FlashMobMainViewVO> result = dao.getAllFlashMobsByFilter(filter);

		assertTrue(result.size() == 0);
	}

	@Test
	public void successAddFlashMob() {
		FlashMobVO flashMobVO = new FlashMobVO();
		flashMobVO.setFlashMobHostId("hyunjoo482");
		flashMobVO.setTitle("주말 러닝 번개");
		flashMobVO.setContent("같이 한강에서 러닝 하실 분 구해요!");
		flashMobVO.setInterestCategory("운동");
		flashMobVO.setAgeRange("20대");
		flashMobVO.setMaxMember(10);
		flashMobVO.setGuNumber(1144000000);

		int result = dao.addFlashMob(flashMobVO);
		assertTrue(result == 1);
	}

	@Test
	public void failAddFlashMob() {
		FlashMobVO flashMobVO = new FlashMobVO();
		flashMobVO.setFlashMobHostId("any user id");
		flashMobVO.setTitle("");
		flashMobVO.setContent("");
		flashMobVO.setInterestCategory("운동");
		flashMobVO.setAgeRange("20대");
		flashMobVO.setMaxMember(10);
		flashMobVO.setGuNumber(1144000000);

		try {
			dao.addFlashMob(flashMobVO);
		} catch (Exception e) {
			assertTrue(e.getClass() == PersistenceException.class);
		}
	}

	@Test
	public void successGetFlashMobDetail() {
		assertTrue(dao.getFlashMobDetail(1).getTitle().equals("래핑 플래시몹 모집"));
	}

	@Test
	public void failGetFlashMobDetail() {
		assertTrue(dao.getFlashMobDetail(11111111) == null);
	}
	
	@Test
	public void successAddFlashMobParticipant() {
		FlashMobParticipantVO flashMobParticipantVO = new FlashMobParticipantVO();
		flashMobParticipantVO.setUserId("sangho5053");
		flashMobParticipantVO.setFlashMobNumber(1);
		flashMobParticipantVO.setApplyDate(new Date(new java.util.Date().getTime()));
		
		int result = dao.addFlashMobParticipant(flashMobParticipantVO);
		assertTrue(result == 1);
	}
	
	@Test
	public void failAddFlashMobParticipant() {
		FlashMobParticipantVO flashMobParticipantVO = new FlashMobParticipantVO();
		flashMobParticipantVO.setUserId("hyunjoo482");
		flashMobParticipantVO.setFlashMobNumber(1);
		flashMobParticipantVO.setApplyDate(new Date(new java.util.Date().getTime()));
		
		try {
			dao.addFlashMobParticipant(flashMobParticipantVO);
		} catch (Exception e) {
			assertTrue(e.getClass() == PersistenceException.class);
		}
	}
	
	@Test
	public void successSetFlashMobDetail() {
		FlashMobVO flashMobVO = new FlashMobVO();
		flashMobVO.setFlashMobNumber(1);
		flashMobVO.setFlashMobHostId("hyunjoo482");
		flashMobVO.setTitle("테스트 제목");
		flashMobVO.setContent("테스트 내용");
		flashMobVO.setInterestCategory("운동");
		flashMobVO.setAgeRange("20대");
		flashMobVO.setMaxMember(10);
		flashMobVO.setGuNumber(1168000000);
		flashMobVO.setMeetingDate(new Date(new java.util.Date().getTime()));
		flashMobVO.setImage("");
		
		int result = dao.setFlashMobDetail(flashMobVO);
		assertTrue(result == 1);
	}
	
	@Test
	public void failSetFlashMobDetail() {
		FlashMobVO flashMobVO = new FlashMobVO();
		flashMobVO.setFlashMobNumber(1);
		flashMobVO.setFlashMobHostId("hyunjoo482");
		flashMobVO.setTitle("테스트 제목");
		flashMobVO.setContent("테스트 내용");
		flashMobVO.setInterestCategory("운동");
		flashMobVO.setAgeRange("20대");
		flashMobVO.setMaxMember(10);
		flashMobVO.setGuNumber(1168000000);
		flashMobVO.setImage("");

		try {
			dao.setFlashMobDetail(flashMobVO);
		} catch (Exception e) {
			assertTrue(e.getClass() == PersistenceException.class);
		};
	}

	@Test
	public void successGetAllFlashMobComments() {
		List<FlashMobCommentVO> result = dao.getAllFlashMobComments(1);

		assertTrue(result.size() == 2);
	}
	
	@Test
	public void successAddFlashMobComment() {
		FlashMobCommentVO flashMobCommentVO = new FlashMobCommentVO();
		flashMobCommentVO.setFlashMobComment("테스트 내용");
		flashMobCommentVO.setUserId("donggyu042");
		flashMobCommentVO.setFlashMobNumber(2);
		flashMobCommentVO.setCommentDate(new Date(new java.util.Date().getTime()));

		
		int result = dao.addFlashMobComment(flashMobCommentVO);
		assertTrue(result == 1);
	}
	
	@Test
	public void failAddFlashMobComment() {
		FlashMobCommentVO flashMobCommentVO = new FlashMobCommentVO();
		flashMobCommentVO.setFlashMobComment("테스트 내용");
		flashMobCommentVO.setUserId("hyunjoo482");
		flashMobCommentVO.setFlashMobNumber(2);
		flashMobCommentVO.setCommentDate(new Date(new java.util.Date().getTime()));

		
		try {
			dao.addFlashMobComment(flashMobCommentVO);
		} catch (Exception e) {
			assertTrue(e.getClass() == PersistenceException.class);
		};
	}
}


