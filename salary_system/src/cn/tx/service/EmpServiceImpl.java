package cn.tx.service;

import cn.tx.dao.EmpDao;
import cn.tx.dao.EmpDaoImpl;
import cn.tx.domain.Emp;
import cn.tx.utils.Page;

import java.util.List;


public class EmpServiceImpl implements EmpService {

    private EmpDao empDao = new EmpDaoImpl();

    /**
     * 分页查询
     * @param pageCode
     * @param pageSize
     * @return
     */
    @Override
    public Page<Emp> selEmpPage(int pageCode, int pageSize) {
        // 创建Page对象
        Page<Emp> page = new Page<>();
        // 当前页
        page.setPageCode(pageCode);
        // 每页显示10条
        page.setPageSize(pageSize);

        // 查询总记录数
        int count = empDao.selCount();
        // 设置总记录数
        page.setTotalCount(count);

        // 查询数据
        List<Emp> list = empDao.selPage(pageCode,pageSize);
        // 设置每页的数据
        page.setBeanList(list);
        return page;
    }

    /**
     * 保存员工
     * @param emp
     */
    @Override
    public void save(Emp emp) {
        // 调用dao，保存
        empDao.save(emp);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Emp selEmpById(int id) {
        return empDao.selEmpById(id);
    }

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(int id) {
        empDao.delete(id);
    }

	@Override
	public int getallMoney() {
		return empDao.getAllmoney();
	}

	@Override
	public Emp empLogin(Emp emp) {
		return empDao.login(emp);
	}

}
