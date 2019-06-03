package com.yh.sys.test;

import org.junit.Test;

import com.yh.sys.service.UserQueryService;



public class UserDeleteTest {

	@Test
	public void delete() {
		UserQueryService service = new UserQueryService();
		
		service.delete1(69);
	
	}
	
	
	
}
