package com.gomedii.swagger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.gomedii.swagger.model.Department;
import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.repositries.DepartmentRepository;
import com.gomedii.swagger.repositries.EmployeeRepository;
import com.gomedii.swagger.Employee1Application;
	
	
@SpringBootApplication
public class Employee1Application implements ApplicationListener<ContextRefreshedEvent>
{
	private Logger log = Logger.getLogger(Employee1Application.class);
		
	@Autowired
	private EmployeeRepository employee1Repository;
		
/*	@Autowired
	private DepartmentRepository departmentRepository;*/
		
	public static void main(String[] args) {
		SpringApplication.run(Employee1Application.class, args);
	
	}
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadEmployee1();
		//loadDepartment();
	}
		
		private void loadEmployee1()
		{
			Employee employee = new Employee();
			employee.setDescription("employee address");
			employee.setSalary(new BigDecimal("59199.00"));
			employee.setEmailid("www.gomedii.com");
			employee.setEname("Kishan");
			employee.setCreatedOn(new Date());
			//employee.setUpdatedOn(new Date());
			//employee1Repository.save(employee);
			log.info("Employee - id: " + employee.getId());

			Employee director = new Employee();
			director.setDescription("director address");
			director.setEmailid("www.binaryinformatics.com");
			director.setEname("Arya");
			director.setSalary(new BigDecimal("5847499"));
			director.setCreatedOn(new Date());
			//director.setUpdatedOn(new Date());
			//employee1Repository.save(director);
			log.info("Saved employee - id:" + director.getId());
			
			
			Department department1 = new Department();
			department1.setDname("I.T.");
			department1.setDmob("789644");
			department1.setCreatedOn(new Date());
			//department1.setUpdatedOn(new Date());
			//departmentRepository.save(department1);
			log.info("Department - id: " + department1.getId());
		
			Department department2 = new Department();
			department2.setDname("Medical");
			department2.setDmob("987456621");
			department2.setCreatedOn(new Date());
			//department2.setUpdatedOn(new Date());
			//departmentRepository.save(department2);
			log.info("Department - id: " + department2.getId());
			
			List<Employee> empList = new ArrayList<Employee>();
			empList.add(employee);
			empList.add(director);

			List<Department> deptList = new ArrayList<Department>();
			deptList.add(department1);
			deptList.add(department2);
			
			department1.setEmployee(empList);
			department2.setEmployee(empList);
			
			employee.setDepartment(deptList);
			director.setDepartment(deptList);
			
			employee1Repository.save(employee);
			
		//	employee1Repository.save(director);
			
		/*	departmentRepository.save(department1);
			departmentRepository.save(department2);*/
		}
	}