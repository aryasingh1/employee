package com.gomedii.swagger;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.gomedii.swagger.model.Employee;
import com.gomedii.swagger.repositries.EmployeeRepository;
import com.gomedii.swagger.Employee1Application;

@SpringBootApplication
public class Employee1Application implements ApplicationListener<ContextRefreshedEvent>{
	private Logger log = Logger.getLogger(Employee1Application.class);
	@Autowired
	private EmployeeRepository employee1Repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Employee1Application.class, args);
	}
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadEmployee1();
	}
	
	private void loadEmployee1() {
		Employee employee = new Employee();
		employee.setDescription("employee address");
		employee.setSalary(new BigDecimal("13299.00"));
		employee.setImageUrl("www.gomedii.com");
		employee.setEmployeeId("123456");
		employee1Repository.save(employee);

		log.info("Employee - id: " + employee.getId());

		Employee director = new Employee();
		director.setDescription("director address");
		director.setImageUrl("www.binaryinformatics.com");
		director.setEmployeeId("45678");
		director.setSalary(new BigDecimal("47499"));
		employee1Repository.save(director);

		log.info("Saved Phone - id:" + director.getId());
	}
}
