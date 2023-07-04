package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Domain.Common.Dao.BookDao;
import Domain.Common.Dto.BookDto;
import Domain.Dao.OrderDao;
import Domain.Dao.ResDao;
import Domain.Dto.MenuDto;import Domain.Dto.OrderDto;
import Domain.Dto.ResDto;

class DaoTests {

	@Test
	public void OrderDaoTest1() {
		OrderDao dao = new OrderDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
	
	@Test
	public void ResDaoTest1_insert() throws Exception {
		ResDao dao = new ResDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
		List<MenuDto> mlist = new ArrayList();
		mlist.add(new MenuDto("1","뚝불1",10000));
		mlist.add(new MenuDto("2","뚝불2",12000));
		
		ResDto dto = new ResDto();
		dto.setRes_id("4");
		dto.setRes_addr("서울");
		dto.setRes_name("세인이네");
		dto.setRes_phone("053-11");
		dto.setRes_pw("1244");
		dto.setMenus(mlist);
		int result = dao.insert(dto);
		
		assertEquals(1,result);
		
	}
	
	@Test
	public void ResDaoTest2_select() throws Exception{
		ResDao dao = new ResDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
		List<ResDto>list = dao.select();
		assertNotNull(list);
		list.stream().forEach((dto)->{
			System.out.println(dto);
		});
	}

	@Test
	public void UserDaoTest1() {
		ResDao dao = new ResDao();
		//객체연결 여부 확인 Test함수
		assertNotNull(dao);
	}
	
	//Order Test
	
	

	@Test
	public void OrderDaoTest2_insert() throws Exception {
		OrderDao dao = new OrderDao();
		assertNotNull(dao);
		int result=dao.insert(new OrderDto(1,"2012-02-12",1,12000,"대구"));
		assertEquals(1,result); //기대값,실제값
	}
	
	@Test
	public void OrederDaoTest3_select() throws Exception {
		OrderDao dao = new OrderDao();
		assertNotNull(dao);
 
		List<OrederDto> list = dao.select();
		assertNotNull(list);
		
		list.stream().forEach((dto)->{
			System.out.println(dto);
		} );
	}
	
	@Test
	public void BookDaoTest5_select_bookcode() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);
 
		BookDto dto = dao.select(10);
		assertNotNull(dto);
		
		System.out.println(dto);
		 
	}	
}

