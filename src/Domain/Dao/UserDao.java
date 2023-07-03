package Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;



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
	
}
