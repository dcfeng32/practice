package cn.tx.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tx.dao.UserDaoImpl;
import cn.tx.domain.Emp;

/**
 * Servlet implementation class rigister
 */
@WebServlet("/RigisterServlet")
public class RigisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDaoImpl userDao = new UserDaoImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RigisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先接收到请求参数（解决中文乱码的问题）
		Emp emp = new Emp();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = sdf.format(d);  
		emp.setEname(request.getParameter("name"));
		emp.setAccount(request.getParameter("account"));
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		emp.setSex(request.getParameter("sex"));
		emp.setPassword(request.getParameter("pwd1"));
		emp.setEdate(dateNowStr);
		userDao.register(emp);
		request.getRequestDispatcher("/empLogin.jsp").forward(request, response);
	}

}
