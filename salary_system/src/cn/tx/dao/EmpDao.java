package cn.tx.dao;

import cn.tx.domain.Emp;

import java.util.List;

public interface EmpDao {
    int selCount();
    List<Emp> selPage(int pageCode, int pageSize);
    void save(Emp emp);

    Emp selEmpById(int id);

    void update(Emp emp);

    void delete(int id);
    
	int getAllmoney();
	
	Emp login(Emp emp);
}
