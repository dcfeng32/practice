package cn.tx.servlet;

import cn.tx.domain.Emp;
import cn.tx.service.EmpService;
import cn.tx.service.EmpServiceImpl;
import cn.tx.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 员工分页查询
 */
public class EmpListServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收页面传过来的请求参数，当前页。如果没有传，默认第一页

        // 每页显示10条，默认设置死的
        int pageSize = 10;
        // 当前页
        int pageCode = 1;
        // 接收请求参数
        String spageCode = request.getParameter("pageCode");
        // 判断 null ""
        if(spageCode != null && !spageCode.trim().isEmpty()){
            // 把spageCode转换成整形
            pageCode = Integer.parseInt(spageCode);
        }

        // 调用service
        Page<Emp> page = empService.selEmpPage(pageCode,pageSize);
        // 把page对象存入到request域对象中
        request.setAttribute("page",page);
        request.setAttribute("allMoney",empService.getallMoney());
        // 请求转发
        request.getRequestDispatcher("/pages/emplist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
