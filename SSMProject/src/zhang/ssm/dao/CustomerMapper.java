package zhang.ssm.dao;

import java.util.List;

import zhang.ssm.entities.Customer;

public interface CustomerMapper {

	/**
	 * 保存customer对象
	 * @param customer
	 */
	public void saveCustomer(Customer customer);
	/**
	 * 根据id删除customer对象
	 * @param id
	 */
	public void deleteCustomerById(Integer id);
	/***
	 * 获取customer和customer关联的department
	 * @param id
	 * @return
	 */
	public Customer getCustomerWithDepartment(Integer id);
	/**
	 * 根据name获取customer对象
	 * @param customername
	 * @return
	 */
	public Customer getCustomerByName(String customername);
	
	/**
	 * 根据id获取customer对象
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(Integer id);
	
	/**
	 * 获取所有的customer的对象组成的集合
	 * @return
	 */
	public List<Customer> getAllCustomer();
	
	
	
}
