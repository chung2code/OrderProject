package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import Domain.Dao.OrderDao;
import Domain.Dao.ResDao;
import Domain.Dto.MenuDto;
import Domain.Dto.ResDto;

class DaoTests {

	@Test
	public void OrderDaoTest1() {
		OrderDao dao = new OrderDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
	
	@Test
	public void ResDaoTest1() throws Exception {
		ResDao dao = new ResDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
		List<MenuDto> mlist = new ArrayList();
		mlist.add(new MenuDto("1","뚝불1",10000));
		mlist.add(new MenuDto("2","뚝불2",12000));
		
		ResDto dto = new ResDto();
		dto.setRes_id("3");
		dto.setRes_addr("서울");
		dto.setRes_name("세인이네");
		dto.setRes_phone("053-11");
		dto.setRes_pw("1244");
		dto.setMenus(mlist);
		int result = dao.insert(dto);
		
		assertEquals(1,result);
		 
	}
	
	@Test
	public void UserDaoTest1() {
		ResDao dao = new ResDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
}

