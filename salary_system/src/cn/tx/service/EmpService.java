package cn.tx.service;

import cn.tx.domain.Emp;
import cn.tx.utils.Page;

public interface EmpService {
    Page<Emp> selEmpPage(int pageCode, int pageSize);
    void save(Emp emp);

    Emp selEmpById(int id);

    void update(Emp emp);

    void delete(int id);
    
	int getallMoney();
	
	Emp empLogin(Emp emp);
}
