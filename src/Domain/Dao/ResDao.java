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
	
	//ressevice 건들다 생긴것들
	public List<OrderDto> select() {
		// TODO Auto-generated method stub
		return null;
	}
	public int delete(int menu_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
