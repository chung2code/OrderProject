package Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import Domain.Dao.MenuDao;
import Domain.Dao.OrderDao;
import Domain.Dao.ResDao;

class DaoTests {


	@Test
	public void MenuDaoTest1() {
		MenuDao dao = new MenuDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
	
	@Test
	public void OrderDaoTest1() {
		OrderDao dao = new OrderDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
	
	@Test
	public void ResDaoTest1() {
		ResDao dao = new ResDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
	
	
	@Test
	public void UserDaoTest1() {
		ResDao dao = new ResDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
}
