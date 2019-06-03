package cn.tx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tx.dao.WelfareDaoImpl;
import cn.tx.domain.Salary;

/**
 * Servlet implementation class WelfareServlet
 */
@WebServlet("/WelfareServlet")
public class WelfareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WelfareDaoImpl welfareDaoImpl= new WelfareDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelfareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Salary> list = welfareDaoImpl.getAllSalary();
		request.setAttribute("welfareList",list);
		request.getRequestDispatcher("/pages/welfare.jsp").forward(request,response);
	}

}
