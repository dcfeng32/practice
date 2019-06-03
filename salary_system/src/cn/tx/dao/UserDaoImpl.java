package cn.tx.dao;

import cn.tx.domain.Emp;
import cn.tx.domain.User;
import cn.tx.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User login(String username, String password) {
		// 思路：通过用户名和密码查询数据库
		// 定义连接
		Connection conn = null;
		// 预编译对象
		PreparedStatement stmt = null;
		// 结果集
		ResultSet rs = null;
		// 定义User对象
		User user = null;
		try {
			// 获取连接
			conn = JdbcUtils.getConnection();
			// 编写登录的SQL语句
			String sql = "select * from t_user where username = ? and password = ?";
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
				user = new User();
				// 设置值
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			JdbcUtils.close(conn, stmt, rs);
		}
		return user;
	}

	public void register(Emp emp) {
		// 思路：通过用户名和密码查询数据库
		// 定义连接
		Connection conn = null;
		// 预编译对象
		PreparedStatement stmt = null;
		// 结果集
		// 定义User对象
		User user = null;
		try {
			// 获取连接
			conn = JdbcUtils.getConnection();
			// 编写登录的SQL语句
			String sql = "INSERT INTO `t_emp` (`ename`, `age`, `sex`, `account`, `password`) "
					+ "VALUES (?, ?, ?, ?, ?);";
			// 预编译SQL语句
			stmt = conn.prepareStatement(sql);
			// 设置值
			stmt.setString(1, emp.getEname());
			stmt.setInt(2, emp.getAge());
			stmt.setString(3, emp.getSex());
			stmt.setString(4, emp.getAccount());
			stmt.setString(5, emp.getPassword());
			// 执行查询
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			JdbcUtils.close(conn, stmt);
		}
	}
}
