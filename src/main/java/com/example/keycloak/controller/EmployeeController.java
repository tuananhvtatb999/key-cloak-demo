package com.example.keycloak.controller;

import com.example.keycloak.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    List<Employee> employeeList = Arrays.asList(new Employee(1, "Nam", "DEV"),
            new Employee(2, "Minh", "ASS"),
            new Employee(3, "Lan", "DEV"),
            new Employee(4, "Linh", "TEST"),
            new Employee(5, "Nhi", "DEV"));

    @PostMapping("/admin/employee")
    @RolesAllowed("admin")
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        employeeList.add(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/user/employee")
    @RolesAllowed("employee")
    public ResponseEntity<List<Employee>> getEmployee() {
        return ResponseEntity.ok(employeeList);
    }
}
