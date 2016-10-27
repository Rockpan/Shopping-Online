package com.shopping.dao;

import com.shopping.model.Product;
import com.shopping.util.DBHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ShowProductDao {

	private DBHelper db = null;
	private PreparedStatement preparedStatement;
	private StringBuilder sql;

	public ShowProductDao() {
		db = new DBHelper();
		sql = new StringBuilder("select p.product_id,p.product_name,p.product_now_price as product_price,"
				+ "p.product_category,p.product_description,s.store_name " + "from product p left join sellerDetail s "
				+ "on p.seller_id = (select seller_id from sellerLogin where seller_detailId = s.seller_detailId) "
				+ "where 1=1 ");
	}

	public List<Product> selectProdut(String category) {
		List<Product> product = new ArrayList<Product>();
		if (category.equals("shoes")) {
			sql.append(" and p.product_category like '%鞋%'");
		}
		if (category.equals("clothes")) {
			sql.append(" and p.product_category like '%衣%'");
		}
		if (category.equals("pants")) {
			sql.append(" and p.product_category like '%裤%'");
		}

		try {
			preparedStatement = db.open().prepareStatement(sql.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProduct_id(rs.getInt("product_id"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_price(rs.getInt("product_price"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_description(rs.getString("product_description"));
				p.setStore_name(rs.getString("store_name"));
				product.add(p);
			}
		} catch (SQLException ex) {
			Logger.getLogger(ShowProductDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			db.close();
		}
		return product;
	}
}
