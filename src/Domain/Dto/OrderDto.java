package Domain.Dto;

public class OrderDto {
	
	private String order_id;
	private String User_id;
	private String res_id;
	private String menu;
	private String order_date;
	private int price;
	
	//<필드>
	public OrderDto(String order_id, String user_id, String res_id, String menu, String order_date, int price) {
		super();
		this.order_id = order_id;
		User_id = user_id;
		this.res_id = res_id;
		this.menu = menu;
		this.order_date = order_date;
		this.price = price;
	}
	//toString
	@Override
	public String toString() {
		return "OrderDto [order_id=" + order_id + ", User_id=" + User_id + ", res_id=" + res_id + ", menu=" + menu
				+ ", order_date=" + order_date + ", price=" + price + "]";
	}
	
	
	
	//getter-setter
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
	

}
