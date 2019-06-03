package com.yh.sys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.sys.domain.Admin;
import com.yh.sys.service.LoginService;
import com.yh.sys.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 * 
 * @param <AdminService>
 */
@WebServlet("/login")
public class LoginServlet<AdminService> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginService loginservice = new LoginServiceImpl();
		Admin admin = loginservice.login(username, password);
		if (admin == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		} else {
			request.getSession().setAttribute("admin", admin);
		
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		}
	}

}
