package cn.tx.dao;

import cn.tx.domain.Emp;
import cn.tx.domain.User;
import cn.tx.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    @Override
    public int selCount() {
        // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        // 结果集
        ResultSet rs = null;
        // 获取到数量
        int count = 0;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "select count(*) from t_emp";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 执行
            rs = stmt.executeQuery();
            // 获取值
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return count;
    }


    @Override
    public List<Emp> selPage(int pageCode, int pageSize) {
        // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        // 结果集
        ResultSet rs = null;
        // 创建List集合，存储员工对象
        List<Emp> list = new ArrayList<>();
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "select * from t_emp order by edate asc limit ?,?";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setInt(1,(pageCode-1)*pageSize);
            stmt.setInt(2,pageSize);
            // 执行
            rs = stmt.executeQuery();
            // 获取值
            while (rs.next()){
                // 创建员工对象，封装数据
                Emp emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setAge(rs.getInt("age"));
                emp.setSex(rs.getString("sex"));
                emp.setSal(rs.getDouble("sal"));
                emp.setBirthday(rs.getString("birthday"));
                emp.setEdate(rs.getString("edate"));
                // 存入到list集合
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return list;
    }

    /**
     * 保存员工
     * @param emp
     */
    @Override
    public void save(Emp emp) {
        // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "INSERT INTO `t_emp` (`ename`, `age`, `sex`, `sal`, `birthday`, `edate`) "
            		+ "VALUES (?,?,?,?,?,?);";
            // 预编译
            stmt = conn.prepareStatement(sql);

            // 预编译
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setString(1,emp.getEname());
            stmt.setInt(2,emp.getAge());
            stmt.setString(3,emp.getSex());
            stmt.setDouble(4,emp.getSal());
            stmt.setString(5,emp.getBirthday());
            stmt.setString(6,emp.getEdate());
            // 执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt);
        }
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Emp selEmpById(int id) {
        // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        // 结果集
        ResultSet rs = null;
        Emp emp = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "select * from t_emp where id = ?";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setInt(1,id);
            // 执行
            rs = stmt.executeQuery();
            // 获取值
            if (rs.next()){
                // 创建员工对象，封装数据
                emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setAge(rs.getInt("age"));
                emp.setSex(rs.getString("sex"));
                emp.setSal(rs.getDouble("sal"));
                emp.setBirthday(rs.getString("birthday"));
                emp.setEdate(rs.getString("edate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return emp;
    }

    /**
     * 修改
     * @param emp
     */
    @Override
    public void update(Emp emp) {
        // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "update t_emp set ename = ?,age = ?,sex = ?,sal = ?,birthday = ?,edate = ? where id = ?";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setString(1,emp.getEname());
            stmt.setInt(2,emp.getAge());
            stmt.setString(3,emp.getSex());
            stmt.setDouble(4,emp.getSal());
            stmt.setString(5,emp.getBirthday());
            stmt.setString(6,emp.getEdate());
            stmt.setInt(7,emp.getId());
            // 执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt);
        }
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(int id) {
        // 连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写sql
            String sql = "delete from t_emp where id = ?";
            // 预编译
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setInt(1,id);
            // 执行
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn,stmt);
        }
    }


	@Override
	public int getAllmoney() {
		 Connection conn = null;
		 int result = 0 ;
	        // 预编译对象
	        PreparedStatement stmt = null;
	        try {
	            // 获取连接
	            conn = JdbcUtils.getConnection();
	            // 编写sql
	            String sql = "select sum(sal) as sal from t_emp";
	            // 预编译
	            stmt = conn.prepareStatement(sql);
	            // 设置值
	            // 执行
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	            	result = rs.getInt("sal");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            JdbcUtils.close(conn,stmt);
	        }
		return result;
	}


	@Override
	public Emp login(Emp emp) {
		 // 思路：通过用户名和密码查询数据库
        // 定义连接
        Connection conn = null;
        // 预编译对象
        PreparedStatement stmt = null;
        // 结果集
        ResultSet rs = null;
        // 定义User对象
        Emp emp1 = new Emp();
        try {
            // 获取连接
            conn = JdbcUtils.getConnection();
            // 编写登录的SQL语句
            String sql = "select * from t_emp where account = ? and password = ?";
            // 预编译SQL语句
            stmt = conn.prepareStatement(sql);
            // 设置值
            stmt.setString(1,emp.getAccount());
            stmt.setString(2,emp.getPassword());
            // 执行查询
            rs = stmt.executeQuery();
            // 从结果集中获取到查询的数据，封装到User对象中，返回。
            if (rs.next()){
                // 封装数据
            	
                // 设置值
            	emp1.setId(rs.getInt("id"));
            	emp1.setAge(rs.getInt("age"));
            	emp1.setBirthday(rs.getString("birthday"));
            	emp1.setEdate(rs.getString("edate"));
            	emp1.setEname(rs.getString("ename"));
            	emp1.setSex(rs.getString("sex"));
            	emp1.setSal(rs.getDouble("sal"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.close(conn,stmt,rs);
        }
        return emp1;
	}

}
