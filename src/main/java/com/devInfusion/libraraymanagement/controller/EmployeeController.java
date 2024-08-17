package com.devInfusion.libraraymanagement.controller;

import com.devInfusion.libraraymanagement.entity.Employee;
import com.devInfusion.libraraymanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public String createNewEmployee(@RequestBody Employee employee){
        boolean isAdded = employeeService.createNewEmployee(employee);
        return isAdded ? "Employee added successfully" : "Something went wrong";
    }

    @PutMapping("/{id}")
    public String updateEmployeeWithId(@PathVariable int id,@RequestBody Employee employee){
        boolean isUpdated = employeeService.updateEmployee(id,employee);
        return isUpdated ? "Employee updated" : "Something went wrong";
    }



}
