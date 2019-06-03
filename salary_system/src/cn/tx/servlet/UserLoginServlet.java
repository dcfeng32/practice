package cn.tx.servlet;

import cn.tx.domain.User;
import cn.tx.service.UserService;
import cn.tx.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录
 */
public class UserLoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

    /**
     * 处理登录业务逻辑
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先接收到请求参数（解决中文乱码的问题）
        //        // 获取到用户输入的用户名和密码
        String username = request.getParameter("username");
        // 获取到密码
        String password = request.getParameter("password");
        // 调用业务层，处理登录的业务逻辑
        User user = userService.login(username, password);
        // 对user对象进行判断，user一种null  user对象
        if(user == null){
            // 登录失败了，用户名或者密码编写错误了
            request.setAttribute("errorMsg","用户名或者密码错误");
            // 请求转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else{
            // 登录成功了，把User对象存储起来，存储HttpSession对象中
            request.getSession().setAttribute("user",user);
            // 跳转到系统首页
            request.getRequestDispatcher("/pages/home.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
















