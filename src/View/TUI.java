package View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;

public class TUI {
    private Scanner sc = new Scanner(System.in);

    private FrontController controller;

    public TUI() {
        controller = new FrontController();
    }

    public void loginMenu() {
        System.out.println("--------------------------");
        System.out.println("로그인");
        System.out.println("--------------------------");
        System.out.print("ID : ");
        String id = sc.next();
        System.out.print("PW : ");
        String pw = sc.next();

     // 로그인 성공!!
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        param.put("pw", pw);

        Map<String, Object> result = controller.execute("/Member", 1, param);
        if (result != null) {
            String sid = (String) result.get("sid");
            String role = (String) result.get("role");
            if (sid != null) {
                // 로그인 성공 메시지 출력
                System.out.println("로그인 성공");
//                System.out.println("SID: " + sid);
//                System.out.println("Role: " + role);
            } else {
                System.out.println("로그인 실패");
            }
        } else {
            System.out.println("로그인 실패");
        }
    }}