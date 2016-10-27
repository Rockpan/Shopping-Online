package com.shopping.model;

public class OrderDetail {

	private int order_id;
	private String user_name;
	private String product_name;
	private int total_price;
	private String order_card;// 订单号
	private int product_state;// 订单状态，1代表未发货，2表示发货

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getOrder_card() {
		return order_card;
	}

	public void setOrder_card(String order_card) {
		this.order_card = order_card;
	}

	public int getProduct_state() {
		return product_state;
	}

	public void setProduct_state(int product_state) {
		this.product_state = product_state;
	}
}
