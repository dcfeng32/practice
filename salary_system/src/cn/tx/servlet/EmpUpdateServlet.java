package cn.tx.servlet;

import cn.tx.domain.Emp;
import cn.tx.domain.User;
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
 * 修改员工
 */
public class EmpUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        Map<String, String[]> map = request.getParameterMap();
        // 创建实体对象
        Emp emp = new Emp();
        try {
            // 封装数据
            BeanUtils.populate(emp,map);
            // 调用service，更新数据
            empService.update(emp);
            // 跳转到列表页面
            request.getRequestDispatcher("/empListServlet").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
