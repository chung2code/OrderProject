package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.MenuDto;

public class MenuDao {
	private String id;
	private String pw;
	private String url;


	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	private static MenuDao instance;
	public static MenuDao getInstance() {
		if(instance==null)
			instance=new MenuDao();
		return instance;
	}
	 
	public MenuDao(){
		
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
	
public int insert(MenuDto dto) throws Exception{
		
		pstmt=conn.prepareStatement("insert into tbl_menu values(?,?,?)");
		pstmt.setString(1, dto.getMenu_id());
		pstmt.setString(2, dto.getMenu_name());
		pstmt.setInt(3,dto.getPrice());
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
		
	}

public List<MenuDto> select() throws Exception{
	List<MenuDto> list = new ArrayList();
	MenuDto dto=null;
	pstmt=conn.prepareStatement("select * from tbl_menu");
	rs=pstmt.executeQuery();
	if(rs!=null)
	{
		while(rs.next()) {
			dto=new MenuDto();
			dto.setMenu_id(rs.getString("id"));
			dto.setMenu_name("username");
			dto.setPrice(rs.getInt("price"));
			list.add(dto);
		}
		rs.close();
	}
	pstmt.close();
		
	return list;
}

public MenuDto select(int menu_id) throws Exception{
	 
	MenuDto dto=null;
	pstmt=conn.prepareStatement("select * from tbl_menu where menu_id=?");
	pstmt.setInt(1, menu_id);
	rs=pstmt.executeQuery();
	if(rs!=null&& rs.isBeforeFirst())
	{
			rs.next();
			dto=new MenuDto();
			dto.setMenu_id(rs.getString("id"));
			dto.setMenu_name(rs.getString("username"));
			dto.setPrice(rs.getInt("pirce"));
			 		
			rs.close();
	}
	pstmt.close();
	return dto;
}	

public int update(MenuDto dto) throws Exception {
    pstmt = conn.prepareStatement("update tbl_menu set menu_name=?, price=? where menu_id=?");
    pstmt.setString(1, dto.getMenu_name());
    pstmt.setInt(2, dto.getPrice());
    pstmt.setString(3, dto.getMenu_id());
    int result = pstmt.executeUpdate();
    pstmt.close();
    return result;
}

public int delete(int menu_id)  throws Exception{
	pstmt=conn.prepareStatement("delete from tbl_menu where menu_id=?");
	pstmt.setInt(1, menu_id);
	int result=pstmt.executeUpdate();
	pstmt.close();
	return result;
}
}
