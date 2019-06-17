package zhang.sssp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import zhang.sssp.dao.EmployeeRepository;
import zhang.sssp.entities.Employee;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository=null;
	
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteEmployee(Integer id){
		employeeRepository.delete(id);
	}
	
	/**
	 * ����id��ѯemployee
	 * @param id
	 * @return
	 */
	public Employee getEmployeeById(Integer id){
		Employee employee = employeeRepository.findOne(id);
		return employee;
	}
	
	/**
	 * ����name��ѯemployee
	 * @param name
	 * @return
	 */
	public Employee getEmployeeByName(String name){
		return employeeRepository.getByName(name);
	}
	/**
	 * ����Ա��
	 * @param employee
	 */
	public void saveEmployee(Employee employee){
		employeeRepository.saveAndFlush(employee);
	}
	
	/**
	 * ��ҳ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<Employee> getPage(int pageNo,int pageSize){
		
		Pageable pageable=new PageRequest(pageNo-1, pageSize);
		Page<Employee> page = employeeRepository.findAll(pageable);
		return page;
	}
	
}
