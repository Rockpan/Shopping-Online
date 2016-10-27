package com.shopping.model;

public class SellerDetail {

	private int seller_id;
	private String store_name;
	private String seller_realName;
	private String seller_IdCard;
	private String seller_phone;
	private String seller_address;

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getSeller_realName() {
		return seller_realName;
	}

	public void setSeller_realName(String seller_realName) {
		this.seller_realName = seller_realName;
	}

	public String getSeller_IdCard() {
		return seller_IdCard;
	}

	public void setSeller_IdCard(String seller_IdCard) {
		this.seller_IdCard = seller_IdCard;
	}

	public String getSeller_phone() {
		return seller_phone;
	}

	public void setSeller_phone(String seller_phone) {
		this.seller_phone = seller_phone;
	}

	public String getSeller_address() {
		return seller_address;
	}

	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}
}
