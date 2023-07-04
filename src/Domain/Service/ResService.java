package Domain.Service;


import java.awt.Menu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import Domain.Service.Auth.Session;

import Domain.Dao.OrderDao;
import Domain.Dto.MenuDto;
import Domain.Dto.OrderDto;
import Domain.Dao.ResDao;
import Domain.Dto.ResDto;

public class ResService {
	
	//매장서비스
	//세션 서비스저장
	public Map<String,Session> sessionMap;
	
	private ResDao dao;
	
	public ResService() {
		dao=new ResDao();
		sessionMap=new HashMap();
	}
	
	
	//매장 조회하기(전체)
	public List<ResDto> ResSearch(String role) throws Exception{
		if(role.equals("Res_id")) {
		 return dao.select();
		}
	}
	//매장 수정하기
	public boolean ResUpdate(ResDto dto,String sid) throws Exception{
		
		Session session = sessionMap.get(sid);
				if (session!=null && session.getId().equals(dto.getRes_id())) {
					
		int result = dao.update(dto);
		if(result>0)
			return true;
	}
		return false;
	}	
	private Object session() {
		
		return null;
	}

	
	//매장 삭제하기
		public boolean ResDelete(int id) throws Exception{
			Session session = sessionMap.get(id);
			if (session!=null && session.getId().equals(id)) {
				
			int result = dao.delete(id);
			if(result>0)
				return true;
			}
			return false;
		}
	
	
	
	
	
	
	
	
	//메뉴서비스
	private ResDao dao;

	private static ResService instanece;
	public static ResService getInstance() {
	  if(instanece == null)
		  instance = new ResService();
	  return intance;
	 
	  
	}
	

	// 메뉴조회하기
	public List<MenuDto> getAllMenu() throws Exception {
		System.out.println("MenuService's getAllMenu()");
		return dao.select();
	}

	// 메뉴등록하기
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
	public boolean updateMenu(MenuDto dto, String role) throws Exception {
        System.out.println("ResService의 updateMenu()");
        if (role.equals("ROLE_RES")) {
            int result = ResDao.update((m) dto);
            return result > 0;
        }
        return false;
    }
	

	// 메뉴삭제하기
	public void deleteMenu(int menu_id, String role) throws Exception {
        System.out.println("ResService의 deleteMenu()");
        if (role.equals("ROLE_RES")) {
            // menuDao.delete(menu_id);를 사용하여 삭제 기능을 구현하세요.
        }
    }
	
	//Order
	
	public class OrderService {
	    private UserService userService;
	    private ResDao resDao;
	    private OrderDao orderdao;

	    // 싱글톤
	    private static OrderService instance;
	    public static OrderService getInstance() {
	        if (instance == null) {
	            instance = new OrderService();
	        }
	        return instance;
	    }

	    public OrderService(){
	        userService = UserService.getInstance();
	        resDao = ResDao.getInstance();
	        orderdao = OrderDao.getInstance();
	    }

	    
	}
		//외부로부터 Service받기
		
	public void setUserService(UserService userService) {
        this.setUserService(userService); 
    }
		
		
		
	//로그인
		public String login(String id, String pw) throws Exception{
			//1 ID/PW 체크 ->Dao 전달받은 id와 일치하는 정보를 가져와서 Pw일치 확인
			ResDto dbDto = dao.select(id);
		    if (dbDto == null) {
		        System.out.println("[ERROR] Login Fail... 아이디가 일치하지 않습니다");
		        return null;
		    }
		    if (!pw.equals(dbDto.getRes_pw())) {
		        System.out.println("[ERROR] Login Fail... 패스워드가 일치하지 않습니다");
		        return null;
		    }
			//2 사용자에대한 정보(Session)을 ResService에 저장
			String sessionId = generateSessionId();
		    session session = new session(sessionId, dbDto.getRes_id(), dbDto.getMenus());
		    session.put(sessionId, session);

			//3 세션에 대한정보를 클라이언트가 접근할수 있도록하는 세션구별Id(Session Cookie) 전달
		    return sessionId;
		}
		

}
	

