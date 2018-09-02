package com.api.hr.dao;

import com.api.types.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeService {

    private static Map<String, Employee> employeesMap = new HashMap<>();

    static {
        employeesMap.put("1", buildEmployee("1", "Johanna", "J"));
        employeesMap.put("2", buildEmployee("2", "Isabel", "J"));
    }

    public Collection<Employee> findAll() {
        return employeesMap.values();
    }

    public Employee save(final Employee e) {
        employeesMap.put(e.getEmployeeId(), e);
        return e;
    }

    public Employee findOne(final String id) {
        return employeesMap.get(id);
    }

    private static Employee buildEmployee(String id, String firstName, String lastName) {
        final Employee employee = new Employee();
        employee.setEmployeeId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        return employee;
    }

}
