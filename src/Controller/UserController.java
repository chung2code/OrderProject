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
            // Add cases for other service numbers as needed

            default:
                System.out.println("Invalid ServiceNo!");
                return new HashMap<>();
        }
    }

    private Map<String, Object> login(Map<String, Object> param) {
        // Extract parameters from the param map
        String id = (String) param.get("id");
        String pw = (String) param.get("pw");

        // Perform input validation
        if (id == null || pw == null) {
            System.out.println("One or more input fields were null. Login failed!");
            return new HashMap<>();
        }

        // Convert id to integer
        int idInt;
        try {
            idInt = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Login failed!");
            return new HashMap<>();
        }

        // Call the UserService to perform the login operation
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
