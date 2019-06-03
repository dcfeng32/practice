package com.yh.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yh.sys.domain.Role_info;
import com.yh.sys.utils.DBUtils;

public class UserDao {

	public boolean add(Role_info info) {     
		String sql = "insert into role_info (role_name, role_desc, role_mark)" + "value (?,?,?)";

		List<Object> list = new ArrayList<>();
		list.add(info.getRole_name());
		list.add(info.getRole_desc());
		list.add(info.getRole_mark());

		return DBUtils.saveOrUpdate(sql, list.toArray());
	}

	/**
	 * 查询角色信息，操作数据库(连接、预编译、带参数执行、返回结果集、关闭资源）
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Role_info> getList(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;

		try {
			con = DBUtils.getConnection();
			pre = con.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					pre.setObject(i + 1, params[i]);
				}
			}
			res = pre.executeQuery();
			List<Role_info> list = new ArrayList<Role_info>();
			while (res.next()) {
				Role_info user = new Role_info();
				user.setRole_id(res.getInt("role_id"));
				user.setRole_name(res.getString("role_name"));
				user.setRole_desc(res.getString("role_desc"));
				user.setRole_mark(res.getString("role_mark"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pre, res);
		}
		return null;
	}

	/**
	 * 修改页面
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(Role_info info) {
		String sql = "update role_info set role_name=?,role_desc=?,role_mark=? where role_id=? ";
		List<Object> list = new ArrayList<Object>();
		list.add(info.getRole_name());
		list.add(info.getRole_desc());
		list.add(info.getRole_mark());
		list.add(info.getRole_id());
		return DBUtils.saveOrUpdate(sql, list.toArray());
	}



}
