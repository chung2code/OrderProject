package Domain.Dto;

import java.util.List;

public class ResDto {

	private String res_id;
	private String res_pw;
	private String res_name;
	private String res_addr;
	private String res_phone;
	private List<MenuDto> menus;
	
	public ResDto() {
		super();
	}

	
	
	public ResDto(String res_id, String res_pw, String res_name, String res_addr, String res_phone,
			List<MenuDto> menus) {
		super();
		this.res_id = res_id;
		this.res_pw = res_pw;
		this.res_name = res_name;
		this.res_addr = res_addr;
		this.res_phone = res_phone;
		this.menus = menus;
	}
	
	public ResDto(String  res_id, String res_pw, String res_name, String res_addr, String res_phone) {
		super();
		this.res_id = res_id;
		this.res_pw = res_pw;
		this.res_name = res_name;
		this.res_addr = res_addr;
		this.res_phone = res_phone;
		
	}



	



	@Override
	public String toString() {
		return "ResDto [res_id=" + res_id + ", res_pw=" + res_pw + ", res_name=" + res_name + ", res_addr=" + res_addr
				+ ", res_phone=" + res_phone + ", menus=" + menus + "]";}

	public String getRes_id() {
		return res_id;
	}

	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}



	public String getRes_pw() {
		return res_pw;
	}



	public void setRes_pw(String res_pw) {
		this.res_pw = res_pw;
	}



	public String getRes_name() {
		return res_name;
	}



	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}



	public String getRes_addr() {
		return res_addr;
	}



	public void setRes_addr(String res_addr) {
		this.res_addr = res_addr;
	}



	public String getRes_phone() {
		return res_phone;
	}



	public void setRes_phone(String res_phone) {
		this.res_phone = res_phone;
	}



	public List<MenuDto> getMenus() {
		return menus;
	}



	public void setMenus(List<MenuDto> menus) {
		this.menus = menus;
	}
}