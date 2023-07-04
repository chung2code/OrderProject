package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import Domain.Dto.UserDto;
import Domain.Service.UserService;

public class UserController {

	private UserService service;
	
	
	public UserController(){
		service = UserService.getInstance();
	}
	

	
	//[CRUD]
	//[ 1 Select , 2 Insert , 3 Update , 4 Delete] 5 로그인, 6 로그아웃
	public Map<String,Object> execute(int serviceNo, Map<String, Object> param) {

		if (serviceNo == 1) {
			// 1 파라미터 추출(생략)
			String sid = (String)param.get("sid");
			// 2 입력값 검증(생략)
			
			// 3 서비스 실행(서비스모듈작업 이후 처리)
			List<UserDto> list=null;
			try {
				list =  service.UserSearch(sid);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			// 4 View로 전달
			System.out.println("Member_Select Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
		} else if (serviceNo == 2) {
			// 1 파라미터 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String name = (String) param.get("name");
			String addr = (String) param.get("addr");
			String phone = (String) param.get("phone");
			
			// 2 입력값 검증
			if (id == null || pw == null || name == null ||addr == null||phone == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 3 서비스 실행
			UserDto dto = new UserDto(id, pw, name, addr,phone);
			System.out.println("Dto : " + dto);
			Boolean rValue=false;
			try {
				rValue =  service.Join(dto);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// 4 View로 전달
			System.out.println("Member_Insert Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
			
		} else if (serviceNo == 3) {
			// 1 파라미터 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String name = (String) param.get("name");
			String addr = (String) param.get("addr");
			String phone = (String) param.get("phone");
			String sid = (String)param.get("sid");
			// 2 입력값 검증
			if (id == null || pw == null || name == null ||addr == null||phone == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 3 서비스 실행
			UserDto dto = new UserDto (id, pw, name, addr,phone);
			System.out.println("Dto : " + dto);
			
			Boolean rValue=false;
			try {
				rValue = service.UserUpdate(dto, sid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 4 View로 전달
			System.out.println("Member_Update Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
			
			
		} else if (serviceNo == 4) {
			// 1 파라미터 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			String sid = (String)param.get("sid");
			
			// 2 입력값 검증
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			// 3 서비스 실행
			
			Boolean rValue=false;
			try {
				rValue = service.UserDelete(id, sid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 4 View로 전달
			System.out.println("Member_Delete Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", rValue);
			return result;
		
		}else if(serviceNo == 5) {
			//1 파라미터 추출
			String id = (String) param.get("id");
			String pw = (String) param.get("pw");
			//2 입력값 검증
			if (id == null || pw == null) {
				System.out.println("[ERROR] Data Validation Check Error!");
				return null;
			}
			//3 서비스 실행
			//MemberDto dto = new MemberDto(id,pw,null,null);
			Map<String,Object> result = new HashMap();
			try {
				result = service.login(id, pw);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//4 View로 전달 
			return result;		
			
			
		}else if(serviceNo == 6) {
			//1 파라미터 추출
			//2 입력값 검증
			//3 서비스 실행
			//4 View로 전달
		}
		
		return null;

	}
	    
	    
	    
	    
	    
			

}
