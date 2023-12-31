package Domain.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mysql.cj.Session;

import Domain.Dao.UserDao;
import Domain.Dto.MenuDto;
import Domain.Dto.UserDto;

public class UserService {
		
	
	//세션정보저장
		public Map<String,Session> sessionMap;
		
		private UserDao dao;
		
	
		
		//싱글톤
		private static UserService instance;
		public static UserService getInstance() {
			if(instance==null)
				instance = new UserService();
			return instance;
		}
		//
		
		private UserService() {
			dao=UserDao.getInstance();
			sessionMap=new HashMap();
		}
		
		//회원 가입하기
		public boolean UserJoin(UserDto dto) throws Exception {
			int result = dao.insert(dto);
			if(result>0)
				return true;
			return false;
		}
		
//		메뉴 조회하기(전체) - 사서
		public List<MenuDto> MenuSearch(String sid) throws Exception{
			
			String menu_id = this.getRole(sid);
			
			
			if(role.equals("ROLE_MEMBER"))		
				return dao.select();
			return null;
		}
		public List<MenuDto> MenuSearch1(String sid) throws Exception{
			
			String menu_name = this.getRole(sid);
			
			
			if(role.equals("ROLE_MEMBER"))		
				return dao.select();
			return null;
		}

		
		
		//회원 조회하기(한 회원) - 로그인한 회원만 
		public UserDto UserSearch(String id,String sid) throws Exception {
			Session session = sessionMap.get(sid);
			
			if(session!=null && session.getid().equals(id))
				return dao.select(id);
			
			return null;
		}
		
		
		//회원 수정하기 -- 본인확인
		public boolean UserUpdate(UserDto dto,String sid) throws Exception{
			
			Session session = sessionMap.get(sid);
			if(session!=null && session.getId().equals(dto.getId()))
			{
				int result = dao.update(dto);
				if(result>0)
					return true;
			}
			
			
			return false;
		}	
		
		//회원 삭제하기
		public boolean UserDelete(String id,String sid) throws Exception{
			
			Session session = sessionMap.get(sid);
			if(session!=null && session.getId().equals(id))
			{
				int result = dao.delete(id);
				if(result>0)
					return true;
			}

			return false;
		}
		
		
		//로그인
		public Map<String,Object> login(String id, String pw) throws Exception{
			//1 ID/PW 체크 ->Dao 전달받은 id와 일치하는 정보를 가져와서 Pw일치 확인
			UserDto dbDto = dao.select(id);
			if(dbDto==null) {
				System.out.println("[ERROR] Login Fail... 아이디가 일치하지 않습니다");
				return null;
			}
			if(!pw.equals(dbDto.getPw())) {
				System.out.println("[ERROR] Login Fail... 패스워드가 일치하지 않습니다");
				return null;
			}
			//2 사용자에대한 정보(Session)을 MemberService에 저장
			String sid=UUID.randomUUID().toString();
			Session session = new Session(sid,dbDto.getId(),dbDto.getRole());
			sessionMap.put(sid, session);
			
			//3 세션에 대한정보를 클라이언트가 접근할수 있도록하는 세션구별Id(Session Cookie) 전달
			Map<String,Object> result = new HashMap();
			result.put("sid", sid);
			result.put("role", dbDto.getRole());
			return result;
		}
		
		//로그아웃
		public boolean logout(String id,String sid) {
			Session session =  sessionMap.get(sid);
			
			if( ! session.getId().equals(id) ) {
				System.out.println("[ERROR] ID가 일치하지 않습니다.");
				return false;
			}
			sessionMap.remove(sid);
			return true;
		}
		
		//역할반환함수임
		public String getRole(String sid) {
			Session session = sessionMap.get(sid);
			System.out.println("getRole's Session : " + session);
			if(session!=null)
				return session.getRole();
			
			return null;
		}





}
