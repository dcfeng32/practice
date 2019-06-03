package com.yh.sys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.sys.domain.Role_info;
import com.yh.sys.service.UserAddService;

@WebServlet("/add")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String desc = request.getParameter("userdesc");

		Role_info info = new Role_info();
		info.setRole_name(name);
		info.setRole_desc(desc);
		// System.out.println(user);
		UserAddService service = new UserAddService();
		service.add(info);
		// if (mk) {
		// request.setAttribute("info", "");
		// } else {
		// request.setAttribute("info", "");
		// }
		// request.getRequestDispatcher("info.jsp").forward(request, response);
		request.getRequestDispatcher("/query.jsp").forward(request, response);
	}
}
