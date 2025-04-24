package test.com.crewrung.account.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import com.crewrung.db.DBCP;
import com.crewrung.flashMob.dao.FlashMobDAO;

public class AccountDAOTest {
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
			session.rollback();
			session.close();
		}
	}
	
	

}
