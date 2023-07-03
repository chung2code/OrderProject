package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.OrderDto;

public class OrderDao {
	private String id;
	private String pw;
	private String url;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private static OrderDao instance;
	public static OrderDao getInstance() {
		if(instance==null)
			instance=new OrderDao();
		return instance;
}
public OrderDao(){
		
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

public int insert(OrderDto dto) throws Exception{
	
	pstmt = conn.prepareStatement("insert into tbl_order values(?,?,?,?,?)");
	pstmt.setString(1, dto.getOrder_id());
	pstmt.setString(2, dto.getOrder_date());
	pstmt.setInt(3, dto.getMenu_id());
	pstmt.setInt(4,dto.getPrice());
	pstmt.setString(5,dto. getAddr());
	int result=pstmt.executeUpdate();
	pstmt.close();
	
	return result;
	
}

public List<OrderDto> select() throws Exception{
List<OrderDto> list = new ArrayList();
OrderDto dto=null;
pstmt=conn.prepareStatement("select * from tbl_order");
rs=pstmt.executeQuery();
if(rs!=null)
{
	while(rs.next()) {
		dto= new OrderDto();
		pstmt.setString(1, dto.getOrder_id());
		pstmt.setString(2, dto.getOrder_date());
		pstmt.setInt(3, dto.getMenu_id());
		pstmt.setInt(4,dto.getPrice());
		pstmt.setString(5,dto. getAddr());
		list.add(dto);
	}
	rs.close();
}
pstmt.close();
	
return list;
}

public OrderDto select(int order_id) throws Exception{
 
OrderDto dto=null;
pstmt=conn.prepareStatement("select * from tbl_order where order_id=?");
pstmt.setInt(1, order_id);
rs=pstmt.executeQuery();
if(rs!=null&& rs.isBeforeFirst())
{
		rs.next();
		dto=new OrderDto();
		dto.setOrder_id(rs.getString("order_id"));
		dto.setOrder_date(rs.getString("order_date"));
		dto.setMenu_id(rs.getInt("menu_id"));
		dto.setPrice(rs.getInt("price"));
		dto.setAddr(rs.getString("addr"));
		 		
		rs.close();
}
pstmt.close();
return dto;
}	

public int update(OrderDto dto) throws Exception {
pstmt = conn.prepareStatement("update tbl_order set order_date=?,menu_id=?, price=?,addr=? where order_id=?");
pstmt.setString(1, dto.getOrder_id());
pstmt.setString(2, dto.getOrder_date());
pstmt.setInt(3, dto.getMenu_id());
pstmt.setInt(4,dto.getPrice());
pstmt.setString(5,dto. getAddr());
int result = pstmt.executeUpdate();
pstmt.close();
return result;
}

public int delete(int order_id)  throws Exception{
pstmt=conn.prepareStatement("delete from tbl_order where order_id=?");
pstmt.setInt(1, order_id);
int result=pstmt.executeUpdate();
pstmt.close();
return result;
}

}
