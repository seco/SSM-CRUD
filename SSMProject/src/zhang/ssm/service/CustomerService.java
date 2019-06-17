package zhang.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhang.ssm.dao.CustomerMapper;
import zhang.ssm.entities.Customer;
@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper=null;
	
	public List<Customer> getAllCustomer(){
		return customerMapper.getAllCustomer();
	}

	
	public void deleteCustomer(int parseInt) {
		customerMapper.deleteCustomerById(parseInt);
	}

}
