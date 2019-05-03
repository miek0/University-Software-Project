package universitysoftware;

public class Employee extends Person{
	private int id;
	private int salary;
	private String hireDate;
	
	public Employee() {
		
	}
	
	int getid() {
		return id;
	}
	
	void setid(int id) {
		this.id = id;
	}
	
	int getSalary() {
		return salary;
	}
	
	void setSalary(int salary) {
		this.salary = salary;
	}
	
	String getHireDate() {
		return hireDate;
	}
	
	void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
}
