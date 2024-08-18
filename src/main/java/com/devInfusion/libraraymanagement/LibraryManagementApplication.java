package com.devInfusion.libraraymanagement;

import com.devInfusion.libraraymanagement.entity.Address;
import com.devInfusion.libraraymanagement.entity.Employee;
import com.devInfusion.libraraymanagement.entity.Project;
import com.devInfusion.libraraymanagement.entity.Spouse;
import com.devInfusion.libraraymanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(EmployeeService employeeService){
		return (args) -> {
			Address address1 = new Address("line1","line2","Zipcode1","city1","state1","country1");
			Project project1 = new Project("Name1","Client Name1");
			Spouse spouse1 = new Spouse("name1","mobileNo1",30);
			Employee employee = new Employee("Name 1","City 1");
			employee.addProject(project1);
			employee.setSpouse(spouse1);
			employee.addAddress(address1);
			employeeService.createNewEmployee(employee);

			log.info("Getting an employee");
			Employee employee1 = employeeService.getEmployeeById(1);

		};
	}

}
