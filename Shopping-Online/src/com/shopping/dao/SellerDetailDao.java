package com.shopping.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.model.Product;
import com.shopping.model.SellerDetail;
import com.shopping.util.DBHelper;

public class SellerDetailDao {

	private DBHelper db = null;
	private PreparedStatement preparedStatement;
	private StringBuilder sql;

	public SellerDetailDao() {
		db = new DBHelper();
		sql = new StringBuilder("select seller_detailId as seller_id ,seller_realName,"
				+ "store_name,seller_IdCard,seller_phone,seller_address from sellerdetail;");
	}

	public List<SellerDetail> selectSeller() {
		List<SellerDetail> seller = new ArrayList<SellerDetail>();
		try {
			preparedStatement = db.open().prepareStatement(sql.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SellerDetail s = new SellerDetail();
				s.setSeller_id(rs.getInt("seller_id"));
				s.setSeller_realName(rs.getString("seller_realName"));
				s.setSeller_IdCard(rs.getString("seller_IdCard"));
				s.setSeller_phone(rs.getString("seller_phone"));
				s.setSeller_address(rs.getString("seller_address"));
				s.setStore_name(rs.getString("store_name"));
				seller.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return seller;
	}
}
