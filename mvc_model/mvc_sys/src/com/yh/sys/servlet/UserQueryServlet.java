package com.yh.sys.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.sys.domain.Role_info;
import com.yh.sys.service.UserQueryService;


@WebServlet("/query")
public class UserQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserQueryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserQueryService service = new UserQueryService();
		String name = request.getParameter("name");
		Role_info info = new Role_info();
		info.setRole_name(name);
		// System.out.println(name);
		List<Role_info> list = service.getList(info);
		// for (User u : list) {
		// System.out.println(u);
		// }
		request.setAttribute("list", list);
		request.setAttribute("role_info", info);
		request.getRequestDispatcher("/query.jsp").forward(request, response);
	}
}
