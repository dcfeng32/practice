package com.yh.jdbc.dao.impl;

import java.util.List;

import com.yh.jdbc.dao.IStudentDao;
import com.yh.jdbc.daomain.Student;
import com.yh.jdbc.utils.CRUDTemplate;

public class StudentDaoImpl implements IStudentDao {
	
	@Override
	public void save(Student stu) {
		String sql = "insert into student (name,age) values (?,?)";
		CRUDTemplate.executeUpdate(sql, stu.getName(), stu.getAge());
	}

	@Override
	public void update(Student stu) {
	}

	@Override
	public Student get(int id) {
		String sql = "select * from student where id = ?";
		//将sql语句作为变量，调用自定义的方法
		List<Student> list = CRUDTemplate.executeQuery(sql, id);
		return list.size() == 1 ? list.get(0) : null;
	}

	@Override
	public List<Student> getALL() {
		String sql = "select * from student";
		//将sql语句作为变量，调用自定义的方法
		return  CRUDTemplate.executeQuery(sql);
		
	}

	@Override
	public void delete(int id) {
		
	}

}
