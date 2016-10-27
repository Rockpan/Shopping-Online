/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.util;

import java.util.List;

import com.shopping.model.OrderDetail;
import com.shopping.model.Product;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 娼樺笇鍩�
 */
public class Tools {

	/**
	 * Product's transform to JSONArray
	 * 
	 * @param data
	 */
	public static JSONArray ProducttoJsonArray(List<Product> data) {
		JSONArray array = new JSONArray();
		for (Product p : data) {
			JSONObject json = new JSONObject();
			json.put("product_id", p.getProduct_id());
			json.put("product_name", p.getProduct_name());
			json.put("product_price", p.getProduct_price());
			json.put("product_category", p.getProduct_category());
			json.put("product_description", p.getProduct_description());
			json.put("store_name", p.getStore_name());
			array.add(json);
		}
		// JSONArray array = JSONArray.fromObject(data);
		return array;
	}

	/**
	 * OrderDetail's transform to JSONArray
	 * 
	 * @param data
	 */
	public static JSONArray OrdertoJsonArray(List<OrderDetail> data) {
		JSONArray array = new JSONArray();
		for (OrderDetail o : data) {
			JSONObject json = new JSONObject();
			json.put("order_id", o.getOrder_id());
			json.put("user_name", o.getUser_name());
			json.put("product_name", o.getProduct_name());
			json.put("total_price", o.getTotal_price());
			json.put("order_card", o.getOrder_card());
			json.put("product_state", o.getProduct_state());
			array.add(json);
		}
		// JSONArray array = JSONArray.fromObject(data);
		return array;
	}
}
