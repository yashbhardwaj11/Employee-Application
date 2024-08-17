package com.devInfusion.libraraymanagement.service;

import com.devInfusion.libraraymanagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> employeeList = new ArrayList<>();

    public List<Employee> findAllEmployees(){
        return employeeList;
    }

}
