package com.yh.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yh.jdbc.daomain.Student;

public class CRUDTemplate {
	
	/*
	 * 代码重复度太高，要求代码优化
	 *  1.设计一个方法 
	 *  2.要求传入两个参数，一个sql语句，一个参数 第一个参数sql语句模板
	 * 第二个参数为可变参数，设置语句参数
	 *  3.返回值 返回值为int，受行数的影响 params可变参数，实质是一个数组
	 */
	public static int executeUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);
			// 遍历参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			//执行语句
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
		return 0;
	}
	
	public static List<Student> executeQuery(String sql,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建一个集合
		List<Student> list = new ArrayList<Student>();
		
		try {
			conn = JDBCUtil.getConn();
			ps = conn.prepareStatement(sql);
			//遍历参数
			for(int i = 0; i < params.length;i++) {
				ps.setObject(i+1, params[i]);
			}

			rs = ps.executeQuery();
			
			if (rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("name"));
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return list;	
	}
	
}
