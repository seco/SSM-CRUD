package zhang.sssp.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import zhang.sssp.dao.DepartmentRepository;
import zhang.sssp.dao.EmployeeRepository;
import zhang.sssp.dao.PersonDao;
import zhang.sssp.dao.PersonRepository;
import zhang.sssp.entities.Department;
import zhang.sssp.entities.Employee;
import zhang.sssp.entities.Person;
import zhang.sssp.service.EmployeeService;

public class SSPTest {
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	private DataSource dataSource=null;
	private PersonDao personDao=null;
	private PersonRepository personRepository=null;
	private EmployeeRepository employeeRepository=null;
	private DepartmentRepository departmentRepository=null;
	private EmployeeService employeeService=null;
	private EntityManagerFactory entityManagerFactory=null;
	{
		dataSource=ctx.getBean(DataSource.class);
		entityManagerFactory=ctx.getBean(EntityManagerFactory.class);
		personDao=ctx.getBean(PersonDao.class);
		personRepository=ctx.getBean(PersonRepository.class);
		employeeRepository=ctx.getBean(EmployeeRepository.class);
		departmentRepository=ctx.getBean(DepartmentRepository.class);
		employeeService=ctx.getBean(EmployeeService.class);
		entityManagerFactory=ctx.getBean(EntityManagerFactory.class);
	}
	//jpa的二级缓存
	@Test
	public void testJpaSecondCashe(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, 1);
		employee=entityManager.find(Employee.class, 1);
		
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	@Test
	public void testgetbyname(){
		Employee employee = employeeRepository.getByName("wang");
		System.out.println(employee);
	}
	/**
	 * 获取员工的page对象
	 */
	@Test
	public void testgetallemployees(){
		List<Employee> emps = employeeRepository.findAll();
		System.out.println(emps);
	}
	@Test
	public void testgetpage(){
		Page<Employee> page = employeeService.getPage(0, 3);
		System.out.println(page.getContent());
	}
	@Test
	public void testgetemployee(){
		List<Employee> persons = employeeRepository.findAll();
		System.out.println(persons);
	}
	@Test
	public void testcreatedepartmentandemployee(){
		Employee employee=new Employee();
		employee.setName("zhangyukang");
		employee.setAge(12);
		employee.setEmail("zhangyukang@qq.com");
		employee.setPhonenumber("123456");
		Department department=new Department();
		department.setDepartmentName("IT");
		employee.setDepartment(department);
		departmentRepository.save(department);
		employeeRepository.save(employee);
	}
	@Test
	public void testgetconneciton() throws SQLException{
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	@Test
	public void testpage(){
		int pageno=1-1;
		int pagesize=4;
		Pageable pageable=new PageRequest(pageno, pagesize);
		Page<Person> page = personRepository.findAll(pageable);
		System.out.println(page.getContent());
		System.out.println("pageno:"+(page.getNumber()+1));
		System.out.println("当前页记录数:"+page.getNumberOfElements());
		System.out.println("总页数:"+page.getTotalPages());	
	}
	@Test
	public void testsaveemployee(){
		for(int i=0;i<10;i++){
			Employee employee=new Employee("zhangyukang", 12+i, i+"zhangyukang@163.com", "134256555");
			Department department = departmentRepository.findOne(6);
			employee.setDepartment(department);
			//save
			employeeRepository.save(employee);
			
		}
		
	}
	@Test
	public void testentities(){
		System.out.println(entityManagerFactory);
	}
	@Test
	public void testspringdatasave(){
		for(int i='a';i<'z';i++){
			Person person=new Person();
			person.setName(i+"name");
			person.setEmail(i+"zhangyukang.com");
			person.setAge(12);
			personRepository.save(person);			
		}
	}
	@Test
	public void testspringdata(){
		List<Person> persons = personRepository.findAll();
		System.out.println(persons);
	}
	@Test
	public void testgetallperson(){
		List<Person> persons = personDao.getAllperson();
		System.out.println(persons);
	}
	@Test
	public void testsaveperson(){
		Person person=new Person();
		person.setAge(12);
		person.setEmail("zyk@qq.com");
		person.setName("zhangyukang");
		personDao.savePerson(person);
	
	}
	@Test
	public void testgetperson(){
		Person person = personDao.getPerosn(2);
		System.out.println(person);
	}

}
