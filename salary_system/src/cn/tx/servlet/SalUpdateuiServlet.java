package cn.tx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tx.dao.WelfareDaoImpl;
import cn.tx.domain.Emp;
import cn.tx.domain.Salary;

/**
 * Servlet implementation class SalUpdateuiServlet
 */
@WebServlet("/SalUpdateuiServlet")
public class SalUpdateuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WelfareDaoImpl welfareDaoImpl = new WelfareDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalUpdateuiServlet() {
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
		// 获取id值
        String sid = request.getParameter("id");
        // 转换成整形
        int id = Integer.parseInt(sid);
        // 调用service，通过id查询数据
        Salary sal = welfareDaoImpl.getOneSalary(id);
        // 把emp数据存域对象
        request.setAttribute("sal",sal);
        request.getRequestDispatcher("/pages/salupdate.jsp").forward(request,response);
	}

}
