package cn.tx.servlet;

import cn.tx.domain.Emp;
import cn.tx.service.EmpService;
import cn.tx.service.EmpServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 添加员工
 */
public class EmpAddServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    /**
     * 添加员工
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        Map<String, String[]> map = request.getParameterMap();
        // 创建员工实体对象
        Emp emp = new Emp();
        try {
            // 把数据封装到User对象
            BeanUtils.populate(emp,map);
            // 调用service，保存员工
            empService.save(emp);
            // 调回到列表的页面
            request.getRequestDispatcher("/empListServlet").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
