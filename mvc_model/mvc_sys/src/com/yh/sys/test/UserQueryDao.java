//package com.yh.sys.test;
//
//import java.util.List;
//
//import org.junit.Test;
//
//import com.yh.sys.dao.UserDao;
//import com.yh.sys.service.UserQueryService;
//
//public class UserQueryDao {
//
//	@Test
//	public void query() {
//		UserQueryService service = new UserQueryService();
//
//		List<User> list = service.getList(null);
//		for (User u : list) {
//			System.out.println(u);
//		}
//	}
//	@Test
//	public void update() {
//		UserQueryService service = new UserQueryService();
//		
//		User user = new User();
//		user.setName("jisuan");
//		user.setDesc("°´¹æ·¶");
//		
//		UserDao dao = new UserDao();
//		System.out.println(dao.update(user));
//		//System.out.println(service.update(user));
//	
//	}
//	
//	
//	
//
//}
