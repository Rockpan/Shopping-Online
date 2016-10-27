package com.shopping.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.model.OrderDetail;
import com.shopping.util.DBHelper;

/**
 * 
 * @author Rock
 *
 */
public class OrderDetailDao {

	private DBHelper db = null;
	private PreparedStatement preparedStatement;
	private StringBuilder sql;

	public OrderDetailDao() {
		db = new DBHelper();
		sql = new StringBuilder(
				"select o.order_id,u.user_name,p.product_name,o.total_price,o.order_card, o.product_state "
						+ "from orderProduct o left join product p on o.product_id = p.product_id "
						+ "left join userLogin u on o.user_id = u.user_id where 1=1 ");
	}

	public List<OrderDetail> seletOrder(String state) {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		if (!(state.equals("all"))) {
			sql.append(" and o.product_state = ?");
		}

		try {
			preparedStatement = db.open().prepareStatement(sql.toString());
			if (!(state.equals("all"))) {
				preparedStatement.setInt(1, Integer.parseInt(state));
			}
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				OrderDetail order = new OrderDetail();
				order.setOrder_id(rs.getInt("order_id"));
				order.setUser_name(rs.getString("user_name"));
				order.setProduct_name(rs.getString("product_name"));
				order.setTotal_price(rs.getInt("total_price"));
				order.setOrder_card(rs.getString("order_card"));
				order.setProduct_state(rs.getInt("product_state"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}
}
