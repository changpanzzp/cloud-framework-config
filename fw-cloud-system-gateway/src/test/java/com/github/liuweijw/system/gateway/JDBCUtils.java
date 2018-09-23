package com.github.liuweijw.system.gateway;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 * @author vanguard
 *
 */
public class JDBCUtils {
	private static Connection conn;
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/fw-cloud-wechat?useUnicode=true&amp;characterEncoding=utf-8";
	private static String username = "root";
	private static String password = "root";
	private static InputStream in;
	public static void main(String[] args) throws SQLException {
		conn = DriverManager.getConnection(url, username, password);
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection );
	}

	/**
	 * 获取连接的方法
	 * @return
	 */
	public static Connection getConnection() {
		return conn;
	}

	/**
	 * 关闭连接 释放资源
	 * @param conn
	 * @param sm
	 * @throws SQLException
	 */
	public static void close(Connection conn, PreparedStatement ps) throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(ps != null) {
			ps.close();
		}
	}

	/**
	 * 关闭所有连接
	 * @param conn
	 * @param st
	 * @param rs
	 * @throws SQLException
	 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(conn != null) {
			conn.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(rs != null) {
			rs.close();
		}
	} 



}