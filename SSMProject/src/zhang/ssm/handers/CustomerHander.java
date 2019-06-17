package zhang.ssm.handers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import zhang.ssm.entities.Customer;
import zhang.ssm.service.CustomerService;

@Controller
public class CustomerHander {

	@Autowired
	private CustomerService customersevice;
	
	/**
	 * 删除员工
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deletecustomer/{id}",method=RequestMethod.GET)
	public String deleteCustomer(@PathVariable("id") String id){
		try {
			customersevice.deleteCustomer(Integer.parseInt(id));
		} catch (Exception e) {			// TODO: handle exception
			return "error";
		}
		return "forward:/getcustomers";
	}
	/**
	 * 显示所有的员工的信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/getcustomers")
	public String getAllCustomers(Map<String, Object> map){
		List<Customer> customers = customersevice.getAllCustomer();
		map.put("customers", customers);
		return "customers";
	}
	
	
}
