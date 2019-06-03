package com.yh.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.sys.domain.Role_info;
import com.yh.sys.service.UserQueryService;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		UserQueryService service = new UserQueryService();
		Role_info role = service.getUserId(roleId);
		System.out.print(role);
		// request.setAttribute("role", role);
		request.getSession().setAttribute("role", role);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		Role_info attribute = (Role_info) request.getSession().getAttribute("role");
		// System.out.println(roleName);
		// System.out.println(roleDesc);
		attribute.setRole_name(roleName);
		attribute.setRole_desc(roleDesc);
		// Role_info info = new Role_info();
		// info.setRole_name(roleName);
		// info.setRole_desc(roleDesc);
		UserQueryService service = new UserQueryService();
		service.update(attribute);
		request.getRequestDispatcher("/query.jsp").forward(request, response);

	}

}
