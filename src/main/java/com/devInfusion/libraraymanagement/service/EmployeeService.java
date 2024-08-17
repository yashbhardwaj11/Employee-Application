package com.devInfusion.libraraymanagement.service;

import com.devInfusion.libraraymanagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> employeeList = new ArrayList<>();
    int employeeId = 1;

    public List<Employee> findAllEmployees(){
        return employeeList;
    }

    public Employee getEmployeeById(int id){
        return employeeList.stream().filter(employee -> (employee.getEmployeeId() == id)).findFirst().get();
    }

    public boolean createNewEmployee(Employee employee){
        employee.setEmployeeId(employeeId++);
        employeeList.add(employee);
        return true;
    }

    public boolean updateEmployee(int id, Employee updatedEmployee) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == id && updatedEmployee != null) {
                if (updatedEmployee.getEmployeeCity() != null && !updatedEmployee.getEmployeeCity().isEmpty()) {
                    emp.setEmployeeCity(updatedEmployee.getEmployeeCity());
                }
                if (updatedEmployee.getEmployeeName() != null && !updatedEmployee.getEmployeeName().isEmpty()) {
                    emp.setEmployeeName(updatedEmployee.getEmployeeName());
                }
                return true;
            }
        }
        return false;
    }


}
