package com.devInfusion.libraraymanagement.controller;

import com.devInfusion.libraraymanagement.entity.Employee;
import com.devInfusion.libraraymanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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



}
