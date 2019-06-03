package cn.tx.dao;

import java.util.List;

import cn.tx.domain.Salary;

public interface WelfareDao {

	List<Salary> getAllSalary();
	
	void updateSalary(Salary salary);
	
	Salary getOneSalary(int id);
}
