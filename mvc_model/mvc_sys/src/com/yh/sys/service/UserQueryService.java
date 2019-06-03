package com.yh.sys.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.yh.sys.dao.UserDao;
import com.yh.sys.domain.Role_info;
import com.yh.sys.utils.DBUtils;
import com.yh.sys.utils.Mark;

public class UserQueryService {

	private UserDao dao = new UserDao();

	/**
	 * 查询角色信息
	 * @param user
	 * @return
	 */
	public List<Role_info> getList(Role_info info) {
		// sql操作数据库
		StringBuffer sb = new StringBuffer("select * from role_info where role_mark = ?");
		List<Object> list = new ArrayList<Object>();

		list.add(Mark.DB_YES);

		if (info != null) {
			if (info.getRole_name() != null && !info.getRole_name().equals("")) {
				sb.append("  and role_name like ? ");
				list.add("%" + info.getRole_name() + "%");
			}
		}
		// 添加用户顺序按照降序
		sb.append(" order by role_id desc ");

		return dao.getList(sb.toString(), list.toArray());
	}

	/**
	 * （假删除）删除用户(修改标识Mark==0不显示在浏览器,数据库没删除)
	 * 
	 * @param user
	 * @return
	 */
	public boolean delete(Role_info info) {
		if (info != null && info.getRole_id() != null) {
			// 先查询 在修改
			Role_info prole = getUserId(info.getRole_id());

			if (prole != null) {
				// 修改具体的字段
				prole.setRole_mark(Mark.DB_NO);
			}
			return dao.update(prole);
		}
		return false;
	}

	/**
	 * 通过id删除
	 * 
	 * @param id
	 */
	public void delete1(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			// 3.创建语句
			String sql = "delete from role_info where role_id = ? ";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			// 4.执行语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ts是父类，ps是子类可以直接继承
			DBUtils.close(conn, ps, null);
		}
	}

	/**
	 * 修改（update）数据
	 * 
	 * @param info
	 * @return
	 */
	public boolean update(Role_info info) {

		if (info != null && info.getRole_id() != null) {
			// 先查询 在修改
			Role_info prole = getUserId(info.getRole_id());

			if (prole != null) {
				// 修改具体的字段
				prole.setRole_name(info.getRole_name());
				prole.setRole_desc(info.getRole_desc());
			}
			return dao.update(prole);
		}
		return false;
	}

	/**
	 * 拿到需要修改信息的id,将ID的整条数据返回
	 * 
	 * @param infoId
	 * @return
	 */
	public Role_info getUserId(Integer infoId) {
		if (infoId != null) {

			StringBuffer sb = new StringBuffer("select * from role_info where role_mark = ? and role_id = ?");
			List<Object> list = new ArrayList<Object>();

			list.add(Mark.DB_YES);
			list.add(infoId);

			List<Role_info> plist = dao.getList(sb.toString(), list.toArray());
			if (plist != null && plist.size() == 1) {
				return plist.get(0);
			}
		}
		return null;
	}

}
