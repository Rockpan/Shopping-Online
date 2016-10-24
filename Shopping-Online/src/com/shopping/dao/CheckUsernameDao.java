package com.shopping.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.util.DBHelper;

/**
 * 用于查询是否有此用户
 * 
 * @author 潘希城
 *
 */
public class CheckUsernameDao {

	private DBHelper db = null;
	private PreparedStatement preparedStatement;
	private String sql;
	private int isChecked = -1;// -1表示不存在此用户,0表示密码或用户名不匹配，1表示密码或用户名匹配

	public CheckUsernameDao() {
		db = new DBHelper();
		sql = "select password from login where username = ?";
	}

	public int checkExist(String username,String password) {
		try {
			preparedStatement = db.open().prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				if(password.equals(rs.getString("password"))){
					isChecked = 1;
				}else{
					isChecked = 0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return isChecked;
	}
	
	public int checkExist(String username) {
		try {
			preparedStatement = db.open().prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return 1;//这里只要返回大于-1的值就可以
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return isChecked;
	}

}
