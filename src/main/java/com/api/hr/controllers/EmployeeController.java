package com.api.hr.controllers;

import com.api.hr.dao.EmployeeService;
import com.api.types.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public Collection<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.findOne(id);
    }
}
