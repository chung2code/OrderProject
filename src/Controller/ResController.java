package Controller;

import java.security.Provider.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.ResDao;
import Domain.Dto.ResDto;
import Domain.Service.ResService;




public class ResController {
	private ResService resService;
	public ResController() {
		resService = ResService.getInstance();
	}
	//[CRUD]
	
	public Map<String,Object> execute(int serviceNo, Map<String, Object> param) {

		if (serviceNo == 1) {
			// 1 파라미터 추출(생략)
			String sid = (String)param.get("sid");
			// 2 입력값 검증(생략)
			
			// 3 서비스 실행(서비스모듈작업 이후 처리)
			List<ResDto> list=null;
			try {
				list = resService.ResSearch(sid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 4 View로 전달
			System.out.println("Res_Select Block!");
			Map<String,Object> result = new HashMap();
			result.put("result", list);
			return result;
			
	
		}
		return param;
	}
}

