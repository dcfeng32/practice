package com.yh.sys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.sys.service.UserQueryService;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserDeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.print("�õ���id�ǣ�"+id);
		UserQueryService service = new UserQueryService();
		service.delete1(id);
		request.getRequestDispatcher("/query.jsp").forward(request, response);
	}
}
