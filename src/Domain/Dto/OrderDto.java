package Domain.Dto;

public class OrderDto {
	
	private String order_id;
	private String order_date;
	private int menu_id;
	private int price;
	private String addr;
	
	
	public OrderDto() {
		super();
	}
	

	
	public OrderDto(String order_id, String order_date, int menu_id, int price, String addr) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.menu_id = menu_id;
		this.price = price;
		this.addr = addr;
	}


	//toString
	@Override
	public String toString() {
		return "OrderDto [order_id=" + order_id + ", order_date=" + order_date + ", menu_id=" + menu_id + ", price="
				+ price + ", addr=" + addr + "]";
	}
	
	
	//getter-setter
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int i) {
		this.menu_id = i;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}




}
