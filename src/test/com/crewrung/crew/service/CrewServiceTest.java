package test.com.crewrung.crew.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.crewrung.crew.dao.CrewDAO;
import com.crewrung.crew.service.CrewService;
import com.crewrung.crew.vo.AllCrewVO;
import com.crewrung.crew.vo.PromotionVO;
import com.crewrung.db.DBCP;

public class CrewServiceTest {

	private SqlSession session;
	private CrewService service;
	private CrewDAO dao;

	@Before
	public void setUp() throws Exception {
		session = DBCP.getSqlSessionFactory().openSession(false); // 수동 커밋
		dao = new CrewDAO(session);
		service = new CrewService(dao);
	}


	@After
	public void tearDown() throws Exception {
		if (session != null) {
			session.rollback(); // 테스트 이후 롤백
			session.close();
		}
	}

	//@Test //홍보 중인 크루 목록 조회(성공)
	public void successGetPromotedCrews() {
		List<PromotionVO> result = new ArrayList<>();
		result = service.getPromotedCrews();
		if(result.isEmpty()==false) {
			System.out.println(result);
		}
	}

	//@Test //모든 크루 목록 조회(성공)
	public void successGetAllCrews() {
		List<AllCrewVO> result = new ArrayList<>();
		result = service.getAllCrews();
		if(result.isEmpty()==false) {
			System.out.println(result);
		}
	}

	//@Test //필터 조건에 따른 크루 조회(실패)
	public void failGetAllCrewByFilter() {
		List<AllCrewVO> result = new ArrayList<>();
		Map<String, String> filter = new HashMap<>();
		filter.put("interestCategory", "운동운동");
		filter.put("guName", "송파구");
		filter.put("ageRange", null); //null값의 포함 여부는 선택임
		result = service.getAllCrewByFilter(filter);
		assertFalse(result.isEmpty());
		if(result.isEmpty()==false) {
			System.out.println(result);
		}
	}

	//@Test //필터 조건에 따른 크루 조회(성공)
	public void successGetAllCrewByFilter() {
		List<AllCrewVO> result = new ArrayList<>();
		Map<String, String> filter = new HashMap<>();
		filter.put("interestCategory", "운동");
		filter.put("guName", "송파구");
		filter.put("ageRange", null);
		result = service.getAllCrewByFilter(filter);
		if(result.isEmpty()==false) {
			System.out.println(result);
		}
	}

	//@Test
	public void testgetCrewDetail() {
		AllCrewVO result = new AllCrewVO(){};
		result = service.getCrewDetail(10);
		System.out.println(result);
	}
	
	@Test
	public void testcheckCrewMembership() {
		boolean result = false;
		result = service.checkCrewMembership(5, "sujin898");
		assertTrue(result);
	}





}
