package dependencyDemo;

import java.util.List;
import java.util.Map;

public class Dependency_Injection_demo {

	private int id;
	private String emp_name, emp_email;
	private long emp_phone;

	private List<String> employees;
	private Map<String, String> employee_email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dependency_Injection_demo(String emp_name, String emp_email, long emp_phone) {
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.emp_phone = emp_phone;
	}

	public List<String> getEmployees() {
		return employees;
	}

	public void setEmployees(List<String> employees) {
		this.employees = employees;
	}

	public Map<String, String> getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(Map<String, String> employee_email) {
		this.employee_email = employee_email;
	}

}
