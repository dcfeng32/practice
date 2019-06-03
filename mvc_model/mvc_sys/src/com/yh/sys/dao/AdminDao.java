package com.yh.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yh.sys.domain.Admin;
import com.yh.sys.utils.DBUtils;

public class AdminDao {

	public Admin longin(String username, String password) {
		// 定义连接
		Connection conn = null;
		// 预编译对象
		PreparedStatement stmt = null;
		// 结果集
		ResultSet rs = null;
		// 定义User对象
		Admin admin = null;
		try {
			// 获取连接
			conn = DBUtils.getConnection();
			// 编写登录的SQL语句
			String sql = "select * from admin where username = ? and password = ?";
			// 预编译SQL语句
			stmt = conn.prepareStatement(sql);
			// 设置值
			stmt.setString(1, username);
			stmt.setString(2, password);
			// 执行查询
			rs = stmt.executeQuery();
			// 从结果集中获取到查询的数据，封装到User对象中，返回。
			if (rs.next()) {
				// 封装数据
				admin = new Admin();
				// 设置值
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			DBUtils.close(conn, stmt, rs);
		}
		return admin;
	}

}
