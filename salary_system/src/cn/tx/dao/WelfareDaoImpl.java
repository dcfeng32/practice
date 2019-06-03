package cn.tx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.tx.domain.Emp;
import cn.tx.domain.Salary;
import cn.tx.utils.JdbcUtils;

public class WelfareDaoImpl implements WelfareDao{

	@Override
	public List<Salary> getAllSalary() {
		 // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        // 结果集
        ResultSet rs = null;
        // 创建List集合，存储员工对象
        List<Salary> list = new ArrayList<Salary>();
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "select * from t_salary";
            // 预编译
            stmt = conn.prepareStatement(sql);

            // 执行
            rs = stmt.executeQuery();
            // 获取值
            while (rs.next()){
                // 创建员工对象，封装数据
            	Salary salary = new Salary();
            	salary.setId(rs.getInt("id"));
            	salary.setName(rs.getString("ename"));
            	salary.setBase_salary(rs.getInt("base_salary"));
            	salary.setBase_welfare(rs.getInt("base_welfare"));
            	salary.setBase_award(rs.getInt("base_award"));
                // 存入到list集合
                list.add(salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return list;
	}

	@Override
	public void updateSalary(Salary salary) {
		 // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "UPDATE `t_salary` SET `base_salary`=?, "
            		+ "`base_welfare`=?, `base_award`=? WHERE  `id`=?;";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setInt(1,salary.getBase_salary());
            stmt.setInt(2,salary.getBase_welfare());
            stmt.setInt(3,salary.getBase_award());
            stmt.setInt(4,salary.getId());
            // 执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt);
        }
	}

	@Override
	public Salary getOneSalary(int id) {
		// 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        // 结果集
        ResultSet rs = null;
        Emp emp = null;
        Salary salary = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "select * from t_salary where id = ?";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setInt(1,id);
            // 执行
            rs = stmt.executeQuery();
            // 获取值
            if (rs.next()){
                // 创建员工对象，封装数据
            	salary = new Salary();
            	salary.setId(rs.getInt("id"));
            	salary.setName(rs.getString("ename"));
            	salary.setBase_salary(rs.getInt("base_salary"));
            	salary.setBase_welfare(rs.getInt("base_welfare"));
            	salary.setBase_award(rs.getInt("base_award"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return salary;
	}
	
}
