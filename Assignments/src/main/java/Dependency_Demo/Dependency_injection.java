package Dependency_Demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

public class Dependency_injection {

	private int id;
	private String emp_name, emp_email;
	private long phone;

	private List<Integer> employee_id;
	private Map<String, String> employee_email;

	public Dependency_injection(String emp_name, String emp_email, long phone) {
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public List<Integer> getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(List<Integer> employee_id) {
		this.employee_id = employee_id;
	}

	public Map<String, String> getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(Map<String, String> employee_email) {
		this.employee_email = employee_email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
