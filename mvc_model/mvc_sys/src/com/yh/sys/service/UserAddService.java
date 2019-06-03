package com.yh.sys.service;


import com.yh.sys.dao.UserDao;
import com.yh.sys.domain.Role_info;
import com.yh.sys.utils.Mark;

/**
 * 业务逻辑层
 * 
 * @author Administrator
 *
 */

public class UserAddService {
	//
	private UserDao dao = new UserDao();

	/**
	 * 添加角色信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean add(Role_info info) {
		if (info != null && info.getRole_name() != null) {
			info.setRole_mark(Mark.DB_YES);
			return dao.add(info);
		}
		return false;
	}


}
