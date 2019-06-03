package cn.tx.servlet;

import cn.tx.service.EmpService;
import cn.tx.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除员工
 */
public class EmpDeleteServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    /**
     * 删除员工
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先获取到id值
        String sid = request.getParameter("id");
        // 转换
        int id = Integer.parseInt(sid);
        // 调用业务层，删除员工
        empService.delete(id);
        // 转发列表
        request.getRequestDispatcher("/empListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
