package zhang.sssp.handers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zhang.sssp.entities.Department;
import zhang.sssp.entities.Employee;
import zhang.sssp.service.DepartmentService;
import zhang.sssp.service.EmployeeService;

@Controller
public class Employeehander {

	@Autowired
	private DepartmentService departmentService=null;
	
	@Autowired
	private  EmployeeService employeeService=null;
	
	/**
	 * 返回首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "redirect:/index.jsp";
	}
	/**
	 * 删除员工
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		employeeService.deleteEmployee(id);
		return "redirect:/getemployees";
	}
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id ,Map<String, Object> map){
		Employee employee=null;
		if(id==null){
			employee=new Employee();
		}else{
			 employee=employeeService.getEmployeeById(id);
			 employee.setDepartment(null);
		}
		map.put("employee", employee);
	}
	/**
	 * 更新员工
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Employee employee){
		employeeService.saveEmployee(employee);
		return "redirect:/getemployees";
	}
	/**
	 * 编辑员工
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id") String id,Map<String, Object>  map){
		map.put("employee", employeeService.getEmployeeById(Integer.parseInt(id)));
		map.put("departments", departmentService.getdepartments());
		return "input";
	}
	/**
	 * 使用ajax验证用户名是否已经被占用
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/ajaxvaildata",method=RequestMethod.GET)
	public String ajaxVaildataUserName(@RequestParam(value="name",required=true) String name){
		Employee employee = employeeService.getEmployeeByName(name);
		if(employee==null){
			return "0";
		}else{
			return "1";
		}
	}
	/**
	 * 保存员工信息
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Employee employee){
		employeeService.saveEmployee(employee);
		return "redirect:/getemployees";
	}
	/**
	 * 到input页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		List<Department> departments = departmentService.getdepartments();
		
		map.put("departments", departments);
		map.put("employee", new Employee());
		return "input";
	}
	/**
	 * 显示所有的员工的信息
	 * @param pageNo
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/getemployees",method=RequestMethod.GET)
	public String getEmployees(@RequestParam(value="pageNo",required=false,defaultValue="1") 
	String pageNo,Map<String, Object> map){
		int pageno=1;
		try {
			pageno=Integer.parseInt(pageNo);
			if(pageno<1){
				pageno=1;
			}
		} catch (Exception e) {}
		Page<Employee> page = employeeService.getPage(pageno, 6);
		map.put("page", page);
		return "list";
	}
	
	
}
