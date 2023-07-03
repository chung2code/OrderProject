package Domain.Service;

import java.util.List;

import Domain.Dao.MenuDao;
import Domain.Dto.MenuDto;

public class ResService {
	
	//메뉴서비스
	private MenuDao dao;

	public ResService() {
	        dao = new MenuDao();
	}

	// 메뉴조회하기(비회원/회원/사서)
	public List<MenuDto> getAllMenu() throws Exception {
		System.out.println("MenuService's getAllMenu()");
		return dao.select();
	}

	// 메뉴등록하기(사서)
	public boolean addMenu(MenuDto dto,String role) throws Exception {
		System.out.println("MenuService's addMenu()");
		if(role.equals("ROLE_RES")) {
		int result = dao.insert(dto);
		if (result > 0)
			return true;
		}
		return false;
	}

	// 메뉴수정하기
	public boolean updateBook(MenuDto dto,String role) throws Exception {
		System.out.println("BookService's updateBook()");
		if(role.equals("ROLE_RES")) {

		int result=dao.update(dto);
		if (result > 0)
			return true;
		}
		return false;
	}

	// 메뉴삭제하기
	public boolean removeBook(int menu_id,String role) throws Exception {
		System.out.println("MenuService's removeMenu()");
		if(role.equals("ROLE_RES")) {

		int result=dao.delete(menu_id);
		if (result > 0)
			return true;
		}
		return false;
	}
}
