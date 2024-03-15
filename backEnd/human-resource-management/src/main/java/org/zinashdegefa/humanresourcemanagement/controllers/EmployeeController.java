package org.zinashdegefa.humanresourcemanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.services.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
    private String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee Successfully added";
    }

    @GetMapping("/getAllEmployees")

    public List<Employee> employees() {
        List<Employee> employees = employeeService.getAllEmployees();

        return employees;

    }

    @DeleteMapping("/employee/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Id number " + employeeId + " is deleted!";
    }

}
