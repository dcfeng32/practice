package com.yh.sys.service;

import com.yh.sys.domain.Admin;

public interface LoginService {

	public Admin login(String username, String password);
}
