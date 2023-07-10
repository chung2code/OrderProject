package Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Domain.Dto.MenuDto;
import Domain.Dto.ResDto;

public class ResDao {
    private String id;
    private String pw;
    private String url;
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement pstmt;

    // 싱글톤패턴
    private static ResDao instance;

    public static ResDao getInstance() {
        if (instance == null)
            instance = new ResDao();
        return instance;
    }

    public ResDao() {
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

    public int updateMenu(MenuDto dto) throws Exception {
        String query = "UPDATE tbl_menu SET menu_name=?, menu_price=? WHERE menu_id=?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, dto.getMenu_name());
        pstmt.setInt(2, dto.getPrice());
        pstmt.setString(3, dto.getMenu_id());

        int result = pstmt.executeUpdate();
        pstmt.close();

        return result;
    }

    public int insert(ResDto dto) throws Exception {
        pstmt = conn.prepareStatement("insert into tbl_res values(?,?,?,?,?,?)");
        pstmt.setString(1, dto.getRes_id());
        pstmt.setString(2, dto.getRes_addr());
        pstmt.setString(3, dto.getRes_phone());
        pstmt.setString(4, dto.getRes_name());
        pstmt.setString(5, dto.getRes_pw());

        // List를 JSON으로 변환
        Gson gson = new Gson();
        String json = gson.toJson(dto.getMenus());
        System.out.println(json);

        pstmt.setString(6, json);
        int result = pstmt.executeUpdate();
        pstmt.close();

        return result;
    }

    public List<ResDto> select() throws Exception {
        List<ResDto> list = new ArrayList<>();
        ResDto dto = null;
        pstmt = conn.prepareStatement("select * from tbl_res");
        rs = pstmt.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                dto = new ResDto();
                dto.setRes_id(rs.getString("res_id"));
                dto.setRes_addr(rs.getString("res_addr"));
                dto.setRes_phone(rs.getString("res_phone"));
                dto.setRes_name(rs.getString("res_name"));
                dto.setRes_pw(rs.getString("res_pw"));
                list.add(dto);
            }
            System.out.println();
            rs.close();
        }
        pstmt.close();

        return list;
    }

    public ResDto select(String res_id) throws Exception {
        ResDto dto = null;
        pstmt = conn.prepareStatement("select * from tbl_res where res_id=?");
        pstmt.setString(1, res_id);
        rs = pstmt.executeQuery();
        if (rs != null && rs.isBeforeFirst()) {
            rs.next();
            dto = new ResDto();
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

    public List<MenuDto> selectMenu() throws Exception {
        List<MenuDto> menuList = new ArrayList<>();
        String query = "SELECT * FROM tbl_menu";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            MenuDto menuDto = new MenuDto();
            menuDto.setMenu_id(rs.getString("menu_id"));
            menuDto.setMenu_name(rs.getString("menu_name"));
            menuDto.setPrice(rs.getInt("menu_price"));
            // 테이블에서 사용 가능한 경우 menuDto의 다른 속성을 설정합니다.
            menuList.add(menuDto);
        }

        rs.close();
        pstmt.close();

        return menuList;
    }

    public int update(ResDto dto) throws Exception {
        pstmt = conn.prepareStatement("update tbl_res set res_addr=?,res_phone=?, res_name=?,res_pw=? where res_id=?");
        pstmt.setString(1, dto.getRes_addr());
        pstmt.setString(2, dto.getRes_phone());
        pstmt.setString(3, dto.getRes_name());
        pstmt.setString(4, dto.getRes_pw());
        pstmt.setString(5, dto.getRes_id());
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    public int delete(String resId) throws Exception {
        pstmt = conn.prepareStatement("delete from tbl_res where res_id=?");
        pstmt.setString(1, resId);
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    public int deleteMenu(int menuId) throws Exception {
        pstmt = conn.prepareStatement("DELETE FROM tbl_menu WHERE menu_id=?");
        pstmt.setInt(1, menuId);
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

    public int insertMenu(MenuDto dto) throws Exception {
        pstmt = conn.prepareStatement("INSERT INTO tbl_menu (menu_name, menu_price) VALUES (?, ?)");
        pstmt.setString(1, dto.getMenu_name());
        pstmt.setInt(2, dto.getPrice());
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }
}
