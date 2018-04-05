package com.gomedii.swagger.repositries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gomedii.swagger.model.Employee;

import junit.framework.TestCase;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepoTest extends TestCase {
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* @PersistenceContext EntityManager em; */
	@Test
	public void testSaveEmployee() {
		Employee employee = getEmployee();;
		Employee SaveInDb = employeeRepo.save(employee);
		Employee getFromDb = employeeRepo.findOne(SaveInDb.getId());
		assertThat(getFromDb).isEqualTo(SaveInDb);
	}

	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setEname("ram");
		employee.setDescription("employee address");
		employee.setSalary(13299.00);
		employee.setImageUrl("www.gomedii.com");
		employee.setEmployeeId("123456");
		return employee;
	}

	@Test
	public void testlistAllEmployee() {

		List<Employee> employee = (List<Employee>) employeeRepo.findAll();
		assertThat(employee.toString(), equalTo(
				"[1,shyam,0,123456,employee address,www.gomedii.com,13299.0, 2,ram,0,45678,director address,www.binaryinformatics.com,47499.0]"));
	}

	@Test
	public void getEmployeeById() {
		Employee emp = new Employee(1);
		//employeeRepo.findOne(emp.getId());
	    Employee found = employeeRepo.findOne(1);

		assertThat(found.getId()).isEqualTo(emp.getId());

	}

	@Test
	public void testdeleteEmployee()

	{
		System.out.println("No of Test Case = " + this.countTestCases());
		String name = this.getName();
		System.out.println("Test case name= " + name);
		Employee employee = new Employee();
		employeeRepo.delete(1);

		employee = employeeRepo.findOne(1);

		assertNull("Object should not exist", employee);
	}

	@Test
	public void testUpdate() {

		Employee emp = employeeRepo.findOne(1);
		emp.setEname("saurabh");
		Employee updated = employeeRepo.save(emp);
		assertThat(updated.getEname(), equalTo("saurabh"));
		String name = jdbcTemplate.queryForObject("SELECT ENAME FROM EMPLOYEE WHERE ID = ?", String.class, 1);
		assertThat(name, equalTo("saurabh"));

	}

	
	 /* public void contextLoads() { }*/
	 

}
