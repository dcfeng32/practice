package cn.tx.filter;

import cn.tx.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CheckLoginFilter implements Filter {

    public void destroy() {
    }

    /**
     * 拦截所有的请求
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 向下转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 项目中静态资源不能拦截
        String uri = request.getRequestURI();
        // 判断
        if(uri.contains("/css/") || uri.contains("/images/") || uri.contains("/js/")){
            chain.doFilter(request,response);
            return;
        }

        // 当前请求的资源是登录的方法或者登录的页面
        String servletPath = request.getServletPath();
        // 判断
        if(servletPath.contains("userLoginServlet") || servletPath.contains("login.jsp")
        		||servletPath.contains("EmpLoginServlet")||servletPath.contains("empLogin.jsp")
        		||servletPath.contains("rigister.jsp")||servletPath.contains("RigisterServlet")){
            // 放行了
            chain.doFilter(request,response);
            return;
        }

        // 判断用户是否已经登录，从HttpSession域对象中获取user对象
        User user = (User) request.getSession().getAttribute("user");
        // 进行判断
        if(user == null){
            // 给出提示
            request.setAttribute("errorMsg","请您登陆");
            // 表明没有登录，跳转到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            // 添加
            return;
        }
        // 放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
