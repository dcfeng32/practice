package com.yh.sys.service;

import com.yh.sys.dao.AdminDao;
import com.yh.sys.domain.Admin;

public class LoginServiceImpl implements LoginService {

	@Override
	public Admin login(String username, String password) {
		AdminDao admin = new AdminDao();

		return admin.longin(username, password);
	}

}
