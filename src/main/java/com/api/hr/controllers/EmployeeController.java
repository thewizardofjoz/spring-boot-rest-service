package com.api.hr.controllers;

import com.api.hr.dao.EmployeeService;
import com.api.hr.domain.Employee;
import com.api.hr.domain.EmployeeResource;
import com.api.hr.exception.ResourceNotFoundException;
import java.net.URI;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Collection<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public EmployeeResource get(@PathVariable String id) {
        return employeeService.findOne(id)
            .map(EmployeeResource::new)
            .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping("employees")
    public ResponseEntity<EmployeeResource> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedEmployee.getEmployeeId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeResource(savedEmployee));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
