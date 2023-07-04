package Domain.Dto;

import java.util.Date;

public class OrderDto {
	
	private String order_id;
	private String addr;
	private String res_id;
	private int price;
	private int menu;
	private String date;
	
	public OrderDto() {
		super();
	}

	public OrderDto(String order_id, String addr, String res_id, int price, int menu, String date) {
		super();
		this.order_id = order_id;
		this.addr = addr;
		this.res_id = res_id;
		this.price = price;
		this.menu = menu;
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderDto [order_id=" + order_id + ", addr=" + addr + ", res_id=" + res_id + ", price=" + price
				+ ", menu=" + menu + ", date=" + date + "]";
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRes_id() {
		return res_id;
	}

	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}