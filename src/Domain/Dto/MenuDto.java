package Domain.Dto;

public class MenuDto {

	private String menu_id;
	private String menu_name;
	private int price;
	
	
	
	public MenuDto(String mene_id, String manu_name, int price) {
		super();
		this.menu_id = mene_id;
		this.menu_name = manu_name;
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "MenuDto [mene_id=" + menu_id + ", manu_name=" + menu_name + ", price=" + price + "]";
	}
	
	//getter-setter
	public String getMene_id() {
		return menu_id;
	}
	public void setMene_id(String mene_id) {
		this.menu_id = mene_id;
	}
	public String getManu_name() {
		return menu_name;
	}
	public void setManu_name(String manu_name) {
		this.menu_name = manu_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
