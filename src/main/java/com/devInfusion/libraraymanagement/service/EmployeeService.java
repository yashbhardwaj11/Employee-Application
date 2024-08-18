package com.devInfusion.libraraymanagement.service;

import com.devInfusion.libraraymanagement.entity.Address;
import com.devInfusion.libraraymanagement.entity.Employee;
import com.devInfusion.libraraymanagement.entity.Project;
import com.devInfusion.libraraymanagement.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        assert employee != null;
        log.info("Fetching projects");
        Set<Project> projectSet = employee.getProjects();
        for(Project project : projectSet){
            log.info(project.toString());
        }
        return employee;
    }

    public Employee createNewEmployee(Employee employee) {
        ArrayList<Address> addressArrayList = new ArrayList<>();
        for(Address address : employee.getAddresses()){
            addressArrayList.add(new Address(address.getLine1(),address.getLine2(),address.getZipCode(),address.getCity(),address.getState(),address.getCountry(),employee));
        }
        employee.setAddresses(addressArrayList);
        return employeeRepository.save(employee);
    }

    public boolean updateEmployee(int id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee emp = optionalEmployee.get();
            boolean updated = false;

            if (updatedEmployee.getEmployeeCity() != null && !updatedEmployee.getEmployeeCity().isEmpty()) {
                emp.setEmployeeCity(updatedEmployee.getEmployeeCity());
                updated = true;
            }
            if (updatedEmployee.getEmployeeName() != null && !updatedEmployee.getEmployeeName().isEmpty()) {
                emp.setEmployeeName(updatedEmployee.getEmployeeName());
                updated = true;
            }
            if (updated) {
                employeeRepository.save(emp);
            }
            return updated;
        }
        return false;
    }

    public boolean deleteEmployeeById(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
