package Domain.Service;


import java.util.List;

import Domain.Dao.ResDao;
import Domain.Dto.MenuDto;
import Domain.Dto.OrderDto;

public class ResService {
	
	private ResDao dao;
	
	
	
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
		}
		
		//오더 넣?기(insert)
		public boolean insertOrder(int order_id, String sid) throws Exception {
			System.out.println("OrderService's insert()");
				int result = dao.insert(OrderDto);
				if(result>0)
					return true;
				return false;
		}
		
		//메뉴 서비스 만들기 도전(복붙)

		//메뉴 조회 select List<MenuDto>
		public List<MenuDto> MenuSearch(String sid) throws Exception{
		    return dao.select();
		}
		//메뉴 수정 update(MenuDto dto) int
		public boolean updateMenu(MenuDto dto, String sid) throws Exception {
			
			System.out.println("MenuService's update()");
			String role = MenuService.getRole(sid);
			
			if (role.equals("Res_id")) {
				int result = dao.update(dto);
				if (result > 0)
					return true;
			}

			return false;
		}
		//메뉴 삭제 delete(int menu_id) int
		public boolean removeMenu(int menu_id, String sid) throws Exception {
			System.out.println("MenuService's delete()");
			
			String role = menuervice.getRole(sid);
			
			if (role.equals("Res_id")) {
				int result = dao.delete(menu_id);
				if (result > 0)
					return true;
			}
			return false;
		}
		//메뉴 추가 insert(MenuDto dto) int






}