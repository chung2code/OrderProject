package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	private Map<String, Object> map = new HashMap();

	private void init() {
		//도서정보 요구사항-Controller Mapping()
		// /RequestUri ServiceNo Param
		map.put("/oder", new ResController());		
		map.put("/member", new ResController());
		
		//request에 맞는 Controller를 추출,해당컨트롤러 실행
		//request , ServiceNo(1 select,2 insert , 3 update , 4 delete) , param
	public Map<String, Object> execute(String request, int ServiceNo, Map<String, Object> param) {
		Object controller = map.get(request);

		Map<String, Object> result = new HashMap();

		if (controller instanceof ResController) {

			ResController down = (ResController) controller;
			result = down.execute(ServiceNo, param);
			System.out.println("BOOKCONTROLLER !");
		} else {
			System.out.println("Request ERROR");
		}

		return result;

	}

}
