package Domain.Dto;

public class MenuDto {

	private String menu_id;
	private String menu_name;
	private int price;
	
	public MenuDto() {
		super();
	}
	
	public MenuDto(String menu_id, String menu_name, int price) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "MenuDto [mene_id=" + menu_id + ", manu_name=" + menu_name + ", price=" + price + "]";
	}
	
	//getter-setter
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
