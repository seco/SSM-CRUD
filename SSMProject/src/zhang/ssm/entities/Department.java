package zhang.ssm.entities;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer departmentId;
	private String departmentName;
	
	private Set<Customer> customers=new HashSet<>();
	
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", customers="
				+ customers + "]";
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	

}
