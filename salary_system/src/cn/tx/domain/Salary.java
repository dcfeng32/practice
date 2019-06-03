package cn.tx.domain;

public class Salary {
	
	private int id;//编号
	private String name;	//名字
	private int base_salary;	//基本薪资
	private int base_welfare;	//基本福利
	private int base_award;		//基本奖金
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBase_salary() {
		return base_salary;
	}
	public void setBase_salary(int base_salary) {
		this.base_salary = base_salary;
	}
	public int getBase_welfare() {
		return base_welfare;
	}
	public void setBase_welfare(int base_welfare) {
		this.base_welfare = base_welfare;
	}
	public int getBase_award() {
		return base_award;
	}
	public void setBase_award(int base_award) {
		this.base_award = base_award;
	}
	
	
	

}
