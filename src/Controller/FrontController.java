package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

    private Map<String, Object> map = new HashMap<>();

    public FrontController() {
        init();
    }
 
    private void init() {
        // Add mappings for different controllers
        map.put("/Member", new UserController());
    }

    public Map<String, Object> execute(String request, int serviceNo, Map<String, Object> param) {
        Object controller = map.get(request);
        Map<String, Object> result = new HashMap<>();

        if (controller instanceof UserController) {
            UserController userController = (UserController) controller;
            result = userController.execute(serviceNo, param);
        } else {
            System.out.println("Request ERROR!");
        }

        return result;
    }
}