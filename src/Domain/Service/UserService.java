package Domain.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import Domain.Dao.UserDao;
import Domain.Dto.UserDto;
import Domain.Service.Auth.Session;

public class UserService {
    private UserDao dao;
    private Map<String, Session> sessionMap;

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }

    private UserService() {
        dao = UserDao.getInstance();
        sessionMap = new HashMap<>();
    }

    public boolean UserJoin(UserDto dto) throws Exception {
        int result = dao.insert(dto);
        return result > 0;
    }

    public UserDto UserSearch(int id, String sid) throws Exception {
        Session session = sessionMap.get(sid);

        if (session != null && session.getId().equals(id))
            return dao.select(id);

        return null;
    }
    public boolean UserUpdate(UserDto dto, String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null && session.getId().equals(dto.getId())) {
            int result = dao.update(dto);
            return result > 0;
        }
        return false;
    }

    public boolean UserDelete(int id, String sid) throws Exception {
        Session session = sessionMap.get(sid);
        if (session != null && session.getId().equals(id)) {
            int result = dao.delete(id);
            return result > 0;
        }
        return false;
    }
    
    public Map<String, Object> login(int id, String pw) throws Exception {
        UserDto dbDto = dao.select(id);
        if (dbDto == null) {
            System.out.println("[ERROR]아이디가 일치하지 않습니다");
            return null;
        }
        if (!pw.equals(dbDto.getPw())) {
            System.out.println("[ERROR]패스워드가 일치하지 않습니다");
            return null;
        }
        String sid = UUID.randomUUID().toString();
        Session session = new Session(sid, dbDto.getId(), dbDto.getRole());
        sessionMap.put(sid, session);

        Map<String, Object> result = new HashMap<>();
        result.put("sid", sid);
        result.put("role", session.getRole());
        return result;
    }

      
    
    
    
//    public boolean logout(String id, String sid) {
//        Session session = sessionMap.get(sid);
//        if (session != null && session.getId().equals(id)) {
//            sessionMap.remove(sid);
//            return true;
//        }
//        System.out.println("[ERROR] ID가 일치하지 않습니다.");
//        return false;
//    }
//
//    public String getRole(String sid) {
//        Session session = sessionMap.get(sid);
//        if (session != null)
//            return session.getRole();
//			return null;
//		}

}
