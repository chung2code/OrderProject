package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
		private Map<String,Object> map = new HashMap();
		
		
		// 초기값 설정
		private void init()
		{
			// 매장 정보 요구 사항 - > 컨트롤러 맵핑
			map.put("/res",new ResController());
			
			// 회원 정보 요구 사항 - > 컨트롤러 맵핑
			map.put("/user",new UserController());
			
		} 
		
		public FrontController()
		{
			init();
		}  
		
		// 각 컨트롤러에 맞게 다운캐스팅 해주면서 어떠한 서비스를 사용할건지 지정
		public Map<String,Object> execute(String request,int serviceNo,Map<String,Object> param)
		{
			Object controller = map.get(request);
			Map<String,Object> result = new HashMap();
			
			if(controller instanceof UserController)
			{
				UserController down = (UserController) controller;
				result = down.execute(serviceNo,param);
				System.out.println("UserController !");
			}
			else if(controller instanceof ResController)
			{
				ResController down = (ResController) controller;
				result = down.execute(serviceNo,param);
				System.out.println("ResController !");
			}
			else
			{
				System.out.println("System ERROR please try again");
			}
			
			return result;	
		}
}


