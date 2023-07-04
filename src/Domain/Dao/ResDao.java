package Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Domain.Dto.OrderDto;



public class ResDao {
	private String id;
	private String pw;
	private String url;


	private Connection conn;
	private PreparedStatement pstmt;
	
	//싱글톤패턴
	private static ResDao instance; 
	public static ResDao getInstance() {
		if(instance==null)
			instance=new ResDao();
		return instance;
	}
	
	

}
