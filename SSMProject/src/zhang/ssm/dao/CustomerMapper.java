package zhang.ssm.dao;

import java.util.List;

import zhang.ssm.entities.Customer;

public interface CustomerMapper {

	/**
	 * ����customer����
	 * @param customer
	 */
	public void saveCustomer(Customer customer);
	/**
	 * ����idɾ��customer����
	 * @param id
	 */
	public void deleteCustomerById(Integer id);
	/***
	 * ��ȡcustomer��customer������department
	 * @param id
	 * @return
	 */
	public Customer getCustomerWithDepartment(Integer id);
	/**
	 * ����name��ȡcustomer����
	 * @param customername
	 * @return
	 */
	public Customer getCustomerByName(String customername);
	
	/**
	 * ����id��ȡcustomer����
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(Integer id);
	
	/**
	 * ��ȡ���е�customer�Ķ�����ɵļ���
	 * @return
	 */
	public List<Customer> getAllCustomer();
	
	
	
}
