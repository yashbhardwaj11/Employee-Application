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
    public Employee createNewEmployee(@RequestBody Employee employee){
        return employeeService.createNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public String updateEmployeeWithId(@PathVariable int id,@RequestBody Employee employee){
        boolean isUpdated = employeeService.updateEmployee(id,employee);
        return isUpdated ? "Employee updated" : "Something went wrong";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
        boolean isDeleted = employeeService.deleteEmployeeById(id);
        return isDeleted ? "Employee Deleted" : "Something went wrong";
    }



}
