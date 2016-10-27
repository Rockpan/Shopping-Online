package com.shopping.service;

import java.util.List;

import com.shopping.dao.SellerDetailDao;
import com.shopping.model.SellerDetail;

public class SellerDetailService {

	public List<SellerDetail> selectSeller() {
		List<SellerDetail> seller = null;
		seller = new SellerDetailDao().selectSeller();
		return seller;
	}
}
