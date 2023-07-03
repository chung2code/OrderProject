package Domain.Service;


import java.util.List;


import Domain.Dto.MenuDto;
import Domain.Dto.OrderDto;

public class ResService {
	
	//메뉴서비스
	private MenuDao dao;

	public ResService() {
	        dao = new MenuDao();
	

	// 메뉴조회하기(비회원/회원/사서)
	public List<MenuDto> getAllMenu() throws Exception {
		System.out.println("MenuService's getAllMenu()");
		return dao.select();
	}

	// 메뉴등록하기(사서)
	public boolean addMenu(MenuDto dto,String role) throws Exception {
		System.out.println("MenuService's addMenu()");
		if(role.equals("ROLE_RES")) {
		int result = dao.insert(dto);
		if (result > 0)
			return true;
		}
		return false;
	}
	

	// 메뉴수정하기
	public boolean updateBook(MenuDto dto,String role) throws Exception {
		System.out.println("BookService's updateBook()");
		if(role.equals("ROLE_RES")) {

		int result=dao.update(dto);
		if (result > 0)
			return true;
		}
		return false;
	}
	

	// 메뉴삭제하기
	public boolean removeBook(int menu_id,String role) throws Exception {
		System.out.println("MenuService's removeMenu()");
		if(role.equals("ROLE_RES")) }


//오더 만들기 도전!
	//싱글톤
		private static ResService instance;
		public static ResService getInstance() {
			if(instance==null)
				instance = new ResService();
			return instance;
		}
	
		//오더 보기(select)
		//주문 조회하기(전체)
		public List<OrderDto> OrderSearch(String sid) throws Exception{
		    return dao.select();
		}
		
//		//주문 조회하기(한명) 
//		public OrderDto OrderSearch(String sid, String order_id) throws Exception{
//		    return dao.select(order_id);
//		}
		
		//
		//오더 수정(update)
		public boolean updateOrder(OrderDto dto, String sid) throws Exception {
			
			System.out.println("OrderService's update()");
			String role = orderService.getRole(sid);
			
			if (role.equals("Res_id")) {
				int result = dao.update(dto);
				if (result > 0)
					return true;
			}

			return false;
		}
		//오더 삭제(delete)
		public boolean removeOrder(int order_id, String sid) throws Exception {
			System.out.println("OrderService's delete()");
			
			String role = orderService.getRole(sid);
			
			if (role.equals("Res_id")) {
				int result = dao.delete(order_id);
				if (result > 0)
					return true;
			}
			return false;
		
		
		//오더 넣?기(insert)
	
	public class ResService {



		int result=dao.delete(menu_id);
		if (result > 0) 
			return true;
		{
		return false;
		}
	}

