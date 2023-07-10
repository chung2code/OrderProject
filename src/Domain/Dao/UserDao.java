package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Dto.UserDto;

public class UserDao {

    private String id;
    private String pw;
    private String url;
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement pstmt;

    // 싱글톤 패턴
    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null)
            instance = new UserDao();
        return instance;
    }

    public UserDao() {
        id = "root";
        pw = "1234";
        url = "jdbc:mysql://localhost:3306/projectdb";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(UserDto dto) throws Exception {
        pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?,?,?)");
        pstmt.setString(1, dto.getId());
        pstmt.setString(2, dto.getPw());
        pstmt.setString(3, dto.getName());
        pstmt.setString(4, dto.getPhone());
        pstmt.setString(5, dto.getAddr());
        pstmt.setString(6, dto.getRole());
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    public List<UserDto> selectAll() throws Exception {
        List<UserDto> list = new ArrayList<>();
        pstmt = conn.prepareStatement("select * from tbl_user");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            UserDto dto = new UserDto();
            dto.setId(rs.getString(1));
            dto.setPw(rs.getString(2));
            dto.setName(rs.getString(3));
            dto.setPhone(rs.getString(4));
            dto.setAddr(rs.getString(5));
            dto.setRole(rs.getString(6));
            list.add(dto);
        }
        rs.close();
        pstmt.close();
        return list;
    }

    public UserDto select(int id) throws Exception {
        UserDto dto = null;
        pstmt = conn.prepareStatement("select * from tbl_user where id = ?");
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if (rs != null && rs.next()) {
            dto = new UserDto();
            dto.setId(rs.getString(1));
            dto.setPw(rs.getString(2));
            dto.setName(rs.getString(3));
            dto.setPhone(rs.getString(4));
            dto.setAddr(rs.getString(5));
            dto.setRole(rs.getString(6));
        }
        rs.close();
        pstmt.close();
        return dto;
    }

    public int update(UserDto dto) throws Exception {
        pstmt = conn.prepareStatement("update tbl_user set pw=?,name=?, addr=?,phone=?, role=? where id=?");
        pstmt.setString(1, dto.getPw());
        pstmt.setString(2, dto.getName());
        pstmt.setString(3, dto.getPhone());
        pstmt.setString(4, dto.getAddr());
        pstmt.setString(5, dto.getRole());
        pstmt.setString(6, dto.getId());
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    public int delete(int id) throws Exception {
        pstmt = conn.prepareStatement("delete from tbl_user where id=?");
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }
}
