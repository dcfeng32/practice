package cn.tx.servlet;

import cn.tx.domain.Emp;
import cn.tx.service.EmpService;
import cn.tx.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转到修改的页面
 */
public class EmpUpdateuiServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    /**
     * 跳转到修改的页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取id值
        String sid = request.getParameter("id");
        // 转换成整形
        int id = Integer.parseInt(sid);
        // 调用service，通过id查询数据
        Emp emp = empService.selEmpById(id);
        // 把emp数据存域对象
        request.setAttribute("emp",emp);
        request.getRequestDispatcher("/pages/empupdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
