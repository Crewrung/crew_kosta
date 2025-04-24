package test.com.crewrung.flashMob.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.service.FlashMobService;


public class FlashMobServiceTest {
	private SqlSession session;
	private FlashMobDAO dao;
	private FlashMobService service;

	@Before
	public void setUp() throws Exception {
		session = DBCP.getSqlSessionFactory().openSession(false);
		dao = new FlashMobDAO(session);
		service = new FlashMobService(dao);
	}

	@After
	public void tearDown() throws Exception {
		if (session != null) {
			session.rollback(); // 테스트 끝나면 롤백
			session.close();
		}
	}

	@Test
	public void successTest() {
	}

	@Test
	public void failTest() {
	}

}
