package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.Dto.UserDto;
import Domain.Service.UserService;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = UserService.getInstance();
	}

	public Map<String, Object> execute(int serviceNo, Map<String, Object> param) {
		switch (serviceNo) {
		case 1:
			return login(param);
		// 다른 서비스 번호에 대한 처리를 추가하도록 안내하는 역할

		default:
			System.out.println("Invalid ServiceNo!");
			return new HashMap<>();
		}
	}

	private Map<String, Object> login(Map<String, Object> param) {

		String id = (String) param.get("id");
		String pw = (String) param.get("pw");

		if (id == null || pw == null) {
			System.out.println("입력창이 비었습니다. 아이디 혹은 비밀번호를 채워주세요");
			return new HashMap<>();
		}

		// 아이디는 정수
		int idInt;
		try {
			idInt = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			System.out.println("지원하는 아이디형식이 아닙니다. 확인해주세요");
			return new HashMap<>();
		}

		Map<String, Object> result = null;
		try {
			result = userService.login(idInt, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
