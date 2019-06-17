package zhang.sssp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zhang.sssp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee getByName(String name);
	
}
