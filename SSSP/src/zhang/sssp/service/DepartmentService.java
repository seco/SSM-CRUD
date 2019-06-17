package zhang.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhang.sssp.dao.DepartmentRepository;
import zhang.sssp.entities.Department;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository=null;
	
	
	public List<Department> getdepartments(){
		List<Department> departments = departmentRepository.findAll();
		return departments;
	}
}
