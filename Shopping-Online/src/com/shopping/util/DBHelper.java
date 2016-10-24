package com.shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {

	public static final String url = "jdbc:mysql://localhost:3306/library";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "niit";

	public Connection conn = null;
	public PreparedStatement pst = null;
	public ResultSet rest = null;

	/**
	 * �����������ݿ�
	 * 
	 * @return Connection���͵�ֵ
	 */
	public Connection open() {
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				return conn;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * ���ڻ�ò�ѯ�õ���ResultSet
	 * 
	 * @param sql ��ѯ���
	 * @return rest 
	 */
	public ResultSet getResultSet(String sql) {
		try {
			
				pst = this.open().prepareStatement(sql);
				System.out.println(pst);
				rest = pst.executeQuery();
				System.out.println(rest);
				if (rest != null) {
					return rest;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rest;
	}

	/**
	 * ���ڹر����ݿ�
	 */
	public void close() {
		try {
			if (this.rest != null) {
				this.rest.close();
			}
			if (this.pst != null) {
				this.pst.close();
			}
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
