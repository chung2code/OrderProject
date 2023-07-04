package Controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Domain.Service.ResService.OrderService;

public class ResController2 {


	
	    private Map<Integer, String> menuMap;

	    public ResController2() {
	        menuMap = new HashMap<>();
	    }

	    public void addMenu(int menuNumber, String menuName) {
	        menuMap.put(menuNumber, menuName);
	    }

	    public void showMenu() {
	        System.out.println("======== 메뉴 목록 ========");
	        for (Map.Entry<Integer, String> entry : menuMap.entrySet()) {
	            System.out.println(entry.getKey() + ". " + entry.getValue());
	        }
	        System.out.println("==========================");
	    }

	    public void processMenuSelection(int menuNumber) {
	        String selectedMenu = menuMap.get(menuNumber);
	        if (selectedMenu != null) {
	            System.out.println("선택된 메뉴: " + selectedMenu);
	            // 선택된 메뉴에 따른 처리 로직을 추가하세요.
	        } else {
	            System.out.println("유효하지 않은 메뉴 번호입니다.");
	        }
	    }

	    
	}

