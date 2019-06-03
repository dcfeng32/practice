package cn.tx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tx.domain.Emp;
import cn.tx.domain.User;
import cn.tx.service.EmpService;
import cn.tx.service.EmpServiceImpl;

/**
 * Servlet implementation class empLoginServlet
 */
@WebServlet("/EmpLoginServlet")
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpServiceImpl empService = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginServlet() {
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
		// 先接收到请求参数（解决中文乱码的问题）
        //        // 获取到用户输入的用户名和密码
		Emp emp =new Emp();
        emp.setAccount(request.getParameter("username"));
        // 获取到密码
        emp.setPassword(request.getParameter("password"));
        // 调用业务层，处理登录的业务逻辑
        emp = empService.empLogin(emp);
        // 对user对象进行判断，user一种null  user对象
        if(emp.getId() == null){
            // 登录失败了，用户名或者密码编写错误了
            request.setAttribute("errorMsg","用户名或者密码错误");
            // 请求转发
            request.getRequestDispatcher("/empLogin.jsp").forward(request,response);
            return;
        }else{
            // 登录成功了，把User对象存储起来，存储HttpSession对象中
            request.getSession().setAttribute("emp",emp);
            // 跳转到系统首页
            request.getRequestDispatcher("/pages/main1.jsp").forward(request,response);
            return;
        }
	}

}
