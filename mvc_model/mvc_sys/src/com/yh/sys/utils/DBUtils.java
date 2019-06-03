package com.yh.sys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cqsys";
			String user = "root";
			String password = "123456";
			try {
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// public static void main(String[] args) {
	// System.out.print(DBUtils.getConnection());
	// }

	public static boolean saveOrUpdate(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement pre = null;

		conn = DBUtils.getConnection();
		try {
			pre = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (params != null && params.length != 0) {
			for (int i = 0; i < params.length; i++) {
				try {
					pre.setObject(i + 1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				int i = pre.executeUpdate();
				if (i > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pre.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return false;
	}
	public static void close(Connection conn, PreparedStatement pre) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pre != null) {
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void close(Connection conn, PreparedStatement pre, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pre != null) {
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
