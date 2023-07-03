package Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Domain.Dto.UserDto;



public class UserDao {

	private String id;
	private String pw;
	private String url;


	private Connection conn;
	private PreparedStatement pstmt;
	
	//싱글톤 패턴
	private static UserDao instance; 
	public static UserDao getInstance() {
		if(instance==null)
			instance=new UserDao();
		return instance;
	}
	public int insert(UserDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	public UserDto select(String id2) {
		// TODO Auto-generated method stub
		return null;
	}
	public int update(UserDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
