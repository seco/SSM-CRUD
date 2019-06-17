package zhang.ssm.dao;

import zhang.ssm.entities.Department;

public interface DepartmentMapper {
	
	/**
	 * ����id��ȡdepartment����
	 * @param id
	 * @return
	 */
	public Department getDeparmentById(Integer id);
	
	/**
	 * ����
	 * @param departmentName
	 * @return
	 */
	public Department getDepartmentByName(String departmentName);

}
