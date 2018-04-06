package com.gomedii.swagger.repositries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gomedii.swagger.model.Employee;

import junit.framework.TestCase;
@Transactional
/*@Rollback*/
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@SpringBootTest
@DataJpaTest
public class Employee1ApplicationTests extends TestCase {
   @Autowired
	private TestEntityManager em;

	@Autowired
	private EmployeeRepository employee1Repository;
	 @Autowired private JdbcTemplate jdbcTemplate;
	/*@PersistenceContext EntityManager em;*/
	@Test
	public void testSaveEmployee() {
		 Employee employee=getEmployee();
		 Employee SaveInDb=employee1Repository.save(employee);

		 Employee getFromDb=em.find(Employee.class, 1);
		assertThat(getFromDb).isEqualTo(SaveInDb);
	}
	private Employee getEmployee() {
		Employee employee = new Employee();
	
		//employee.setEname("ram");
		employee.setDescription("employee address");
		employee.setSalary(new BigDecimal("45667.00"));
		employee.setEmailid("www.gomedii.com");
		employee.setEname("123456");
		return employee;
	}
	
	
	
	/*@Test
	public void testlistAllEmployee()
	{
		List<Employee> employee=(List<Employee>) employee1Repository.findAll();
		 assertThat(employee.toString(),equalTo("[1,saurabh,0,1234,employeede,www.gomedii.com,13999.0, 2,saurabh,0,123456,employee address,www.gomedii.com,13299.0]"));
	}*/
	
 /* @Test
	public void getEmployeeById()
	{
		Employee emp=new Employee(1);
		//em.persist(emp);
		em.flush();
		
		Employee found=employee1Repository.findOne(emp.getId());
		
		assertThat(found.getId()).isEqualTo(emp.getId());
		
	}*/
/*	@Test
	public void testdeleteEmployee()
	
	{    
		System.out.println("No of Test Case = "+ this.countTestCases());
	    String name = this.getName();
	   System.out.println("Test case name= "+name);
		Employee employee = new Employee(1);
		em.remove(employee);
	  employee= em.find(Employee.class, 1);
	  
	assertNull("Object should not exist",  employee);
}*/
	
	
	
/* @Test
	    public void testUpdate() {
	        
	        Employee emp = em.find(Employee.class, 	1);
	        emp.setEname("ram");
	        
	        Employee updated = employee1Repository.save(emp);
	        
	        assertThat(updated.getEname(), equalTo("ram"));
	        
	       String name = jdbcTemplate.queryForObject("SELECT ENAME FROM EMPLOYEE WHERE ID = ?", 
	                                                    String.class,
	                                                    1);
	       
	   
        assertThat(name, equalTo("saurabh"));
	        
	        
	    }*/
	

	/*public void contextLoads() {
	}*/

}

