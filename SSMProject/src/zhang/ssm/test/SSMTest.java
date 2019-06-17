package zhang.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.CustomTypeSafeMatcher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhang.ssm.dao.CustomerMapper;
import zhang.ssm.dao.DepartmentMapper;
import zhang.ssm.entities.Customer;
import zhang.ssm.entities.Department;

public class SSMTest {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private DataSource dataSource = null;
	private CustomerMapper customerMapper=null;
	{
		dataSource = ctx.getBean(DataSource.class);
		customerMapper=ctx.getBean(CustomerMapper.class);
	}
	@Test
	public void testgetcusomermappper(){
		System.out.println(customerMapper);
		List<Customer> allCustomer = customerMapper.getAllCustomer();
		System.out.println(allCustomer.size());
	}
	@Test
	public void testgetconnection() throws SQLException{
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	
	
	public SqlSessionFactory getsqlsessionfactory() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sessionFactory;
	}

	@Test
	public void testgetdepartment() throws IOException {
		SqlSessionFactory sqlSessionFactory = getsqlsessionfactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
			Department departmentByName = mapper.getDepartmentByName("开发 部");
			System.out.println(departmentByName);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/***
	 * 保存customer对象
	 * 
	 * @throws IOException
	 */
	@Test
	public void testsaveCustomer() throws IOException {
		SqlSessionFactory sqlSessionFactory = getsqlsessionfactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			CustomerMapper mapper = openSession.getMapper(CustomerMapper.class);
			Customer customer = new Customer();
			customer.setAge(12);
			customer.setName("justin");
			Department department = new Department();
			department.setDepartmentId(1);
			customer.setDepartment(department);
			mapper.saveCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.commit();
			openSession.close();
		}
	}

	@Test
	public void testdeleteCustomerById() throws IOException {
		SqlSessionFactory sessionFactory = getsqlsessionfactory();
		SqlSession openSession = sessionFactory.openSession();
		try {
			CustomerMapper mapper = openSession.getMapper(CustomerMapper.class);
			mapper.deleteCustomerById(624);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.commit();
		}
	}

	@Test
	public void testgetgetCustomerByName() throws IOException {
		SqlSessionFactory getsqlsessionfactory = getsqlsessionfactory();
		SqlSession openSession = getsqlsessionfactory.openSession();
		try {
			CustomerMapper mapper = openSession.getMapper(CustomerMapper.class);
			Customer customer = mapper.getCustomerByName("zhang");
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}

	@Test
	public void testgetCustomerWithDepartment() throws IOException {
		SqlSessionFactory sqlSessionFactory = getsqlsessionfactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			CustomerMapper mapper = openSession.getMapper(CustomerMapper.class);
			Customer customer = mapper.getCustomerWithDepartment(624);
			System.out.println(customer.getDepartment().getDepartmentName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}

	@Test
	public void testgetfactory() throws IOException {
		SqlSessionFactory sessionFactory = getsqlsessionfactory();
		SqlSession openSession = sessionFactory.openSession();
		try {
			CustomerMapper mapper = openSession.getMapper(CustomerMapper.class);
			List<Customer> allCustomer = mapper.getAllCustomer();
			System.out.println(allCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}

}
