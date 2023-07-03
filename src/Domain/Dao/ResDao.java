package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Domain.Dto.ResDto;

public class ResDao {
	private String id;
	private String pw;
	private String url;
	private ResultSet rs;

	private Connection conn;
	private PreparedStatement pstmt;
	
	//싱글톤패턴
	private static ResDao instance; 
	public static ResDao getInstance() {
		if(instance==null)
			instance=new ResDao();
		return instance;
	}

public ResDao(){
		
		id="root";
		pw="1234";
		url="jdbc:mysql://localhost:3306/projectdb";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,id,pw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	 
}

public int insert(ResDto dto) throws Exception{
	
	pstmt = conn.prepareStatement("insert into tbl_res values(?,?,?,?,?,?  )");
	pstmt.setString(1, dto.getRes_id());
	pstmt.setString(2, dto.getRes_addr());
	pstmt.setString(3, dto.getRes_phone());
	pstmt.setString(4,dto.getRes_name());
	pstmt.setString(5,dto.getRes_pw());
	
	//List를 JSON으로 변환
	Gson gson = new Gson();
	String json = gson.toJson(dto.getMenus());
	System.out.println(json);
	
	pstmt.setString(6, json);
	int result=pstmt.executeUpdate();
	pstmt.close();
	
	return result;
	
}

public List<ResDto> select() throws Exception{
List<ResDto> list = new ArrayList();
ResDto dto=null;
pstmt=conn.prepareStatement("select * from tbl_res");
rs=pstmt.executeQuery();
if(rs!=null)
{
	while(rs.next()) {
		dto= new ResDto();
		pstmt.setString(1, dto.getRes_id());
		pstmt.setString(2, dto.getRes_addr());
		pstmt.setString(3, dto.getRes_phone());
		pstmt.setString(4,dto.getRes_name());
		pstmt.setString(5,dto.getRes_pw());
		list.add(dto);
	}
	rs.close();
}
pstmt.close();
	
return list;
}

public ResDto select(int res_id) throws Exception{
 
ResDto dto=null;
pstmt=conn.prepareStatement("select * from tbl_res where res_id=?");
pstmt.setInt(1,res_id);
rs=pstmt.executeQuery();
if(rs!=null&& rs.isBeforeFirst())
{
		rs.next();
		dto=new ResDto();
		dto.setRes_id(rs.getString("res_id"));
		dto.setRes_pw(rs.getString("addr_date"));
		dto.setRes_name(rs.getString("menu_id"));
		dto.setRes_addr(rs.getString("price"));
		dto.setRes_phone(rs.getString("addr"));
		 		
		rs.close();
}
pstmt.close();
return dto;
}	

public int update(ResDto dto) throws Exception {
pstmt = conn.prepareStatement("update tbl_res set res_addr=?,res_phone=?, res_name=?,res_pw=? where res_id=?");
pstmt.setString(1, dto.getRes_id());
pstmt.setString(2, dto.getRes_addr());
pstmt.setString(3, dto.getRes_phone());
pstmt.setString(4,dto.getRes_name());
pstmt.setString(5,dto.getRes_pw());
int result = pstmt.executeUpdate();
pstmt.close();
return result;
}

public int delete(int res_id)  throws Exception{
pstmt=conn.prepareStatement("delete from tbl_res where res_id=?");
pstmt.setInt(1, res_id);
int result=pstmt.executeUpdate();
pstmt.close();
return result;
}

}


