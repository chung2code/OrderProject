package Domain.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Domain.Service.Auth.Session;
import Domain.Dao.ResDao;
import Domain.Dto.MenuDto;
import Domain.Dto.ResDto;

public class ResService {
    private Map<String, Session> sessionMap;
    private ResDao dao;

    private static ResService instance;

    public static ResService getInstance() {
        if (instance == null)
            instance = new ResService();
        return instance;
    }

    private ResService() {
        dao = ResDao.getInstance();
        sessionMap = new HashMap<>();
    }

    // 매장 조회하기(전체)
    public List<ResDto> resSearch(String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null) {
            return dao.select();
        }
        return null;
    }

    // 매장 수정하기
    public boolean resUpdate(ResDto dto, String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null && session.getId().equals(dto.getRes_id())) {
            int result = dao.update(dto);
            return result > 0;
        }
        return false;
    }

    // 매장 삭제하기
    public boolean resDelete(String resId, String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null && session.getId().equals(resId)) {
            int result = dao.delete(resId);
            return result > 0;
        }
        return false;
    }

    // 메뉴 조회하기
    public List<MenuDto> getAllMenu() throws Exception {
        return dao.selectMenu();
    }

    // 메뉴 등록하기
    public boolean addMenu(MenuDto dto, String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null && session.getRole().equals("ROLE_RES")) {
            int result = dao.insertMenu(dto);
            return result > 0;
        }
        return false;
    }

    // 메뉴 수정하기
    public boolean updateMenu(MenuDto dto, String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null && session.getRole().equals("ROLE_RES")) {
            int result = dao.updateMenu(dto);
            return result > 0;
        }
        return false;
    }

    // 메뉴 삭제하기
    public boolean deleteMenu(int menuId, String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null && session.getRole().equals("ROLE_RES")) {
            int result = dao.deleteMenu(menuId);
            return result > 0;
        }
        return false;
    }

    // 로그인
    public String login(String id, String pw) throws Exception {
        ResDto dbDto = dao.select(id);
        if (dbDto == null || !pw.equals(dbDto.getRes_pw())) {
            return null;
        }

        String sessionId = generateSessionId();
        Session session = new Session(sessionId, dbDto.getRes_id(), "ROLE_RES");
        sessionMap.put(sessionId, session);

        return sessionId;
    }

    private String generateSessionId() {
        return UUID.randomUUID().toString();
    }
}
