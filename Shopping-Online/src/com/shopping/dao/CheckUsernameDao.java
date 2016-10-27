package com.shopping.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.util.DBHelper;

/**
 *
 * 
 * @author Rock
 *
 */
public class CheckUsernameDao {

	private DBHelper db = null;
	private PreparedStatement preparedStatement;
	private String sql;
	private int isChecked = -1;

	public CheckUsernameDao() {
		db = new DBHelper();
		sql = "select password from managerLogin where username = ?";
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
				return 1;//����ֻҪ���ش���-1��ֵ�Ϳ���
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return isChecked;
	}

}
