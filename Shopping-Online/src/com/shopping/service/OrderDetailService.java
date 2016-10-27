package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.OrderDetailDao;
import com.shopping.model.OrderDetail;

/**
 * 
 * @author Rock
 *
 */
public class OrderDetailService {

	public List<OrderDetail> seletOrder(String state) {
		List<OrderDetail> list = null;
		list = new OrderDetailDao().seletOrder(state);
		return list;
	}
}
