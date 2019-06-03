package cn.tx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tx.dao.WelfareDaoImpl;
import cn.tx.domain.Salary;

/**
 * Servlet implementation class SalupdateServlet
 */
@WebServlet("/SalupdateServlet")
public class SalupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WelfareDaoImpl welfareDaoImpl= new WelfareDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Salary salary = new Salary();
		salary.setId(Integer.parseInt(request.getParameter("id")));
		salary.setBase_salary(Integer.parseInt(request.getParameter("salary")));
		salary.setBase_welfare(Integer.parseInt(request.getParameter("welfare")));
		salary.setBase_award(Integer.parseInt(request.getParameter("award")));
		welfareDaoImpl.updateSalary(salary);
		 request.getRequestDispatcher("/WelfareServlet").forward(request,response);
		
	}

}
