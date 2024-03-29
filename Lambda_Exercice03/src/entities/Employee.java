package entities;

public class Employee{
	public String name;
	public String email;	
	public Double salary;

	public Employee() {
	}

	public Employee(String name, String email, double salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getsalary() {
		return salary;
	}

	public void setsalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}

}
