package Domain.Service;

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
