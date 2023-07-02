package Domain.Dto;

public class MenuDto {

	private String mene_id;
	private String manu_name;
	private int price;
	
	
	
	public MenuDto(String mene_id, String manu_name, int price) {
		super();
		this.mene_id = mene_id;
		this.manu_name = manu_name;
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "MenuDto [mene_id=" + mene_id + ", manu_name=" + manu_name + ", price=" + price + "]";
	}
	
	//getter-setter
	public String getMene_id() {
		return mene_id;
	}
	public void setMene_id(String mene_id) {
		this.mene_id = mene_id;
	}
	public String getManu_name() {
		return manu_name;
	}
	public void setManu_name(String manu_name) {
		this.manu_name = manu_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
