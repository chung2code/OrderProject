package Domain.Service;


import Domain.Dao.UserDao;

public class UserService {
	
	private UserDao Dao;
	
	public UserService() {
		Dao = new UserDao();
	}


}
