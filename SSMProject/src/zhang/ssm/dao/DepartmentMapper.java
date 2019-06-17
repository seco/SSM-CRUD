package zhang.ssm.dao;

import zhang.ssm.entities.Department;

public interface DepartmentMapper {
	
	/**
	 * 根据id获取department对象
	 * @param id
	 * @return
	 */
	public Department getDeparmentById(Integer id);
	
	/**
	 * 根据
	 * @param departmentName
	 * @return
	 */
	public Department getDepartmentByName(String departmentName);

}
