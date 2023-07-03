package Domain.Service;

import java.util.List;

import Domain.Dao.ResDao;
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
		//회원 조회하기(전체) - 사서
		public List<OrderDto> OrderSearch(String sid) throws Exception{
			
			String role = this.getRole(sid);
			
			if(role.equals("ROLE_MEMBER"))		
				return dao.select();
			return null;
		}
//		//회원 조회하기(한명) - 사서
//		public UserDto memberSearchOne(String role,String id) throws Exception{
//			if(role.equals("ROLE_MEMBER"))		
//				return dao.select(id);
//			return null;
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
	
	
	

	
	
	
	
}
