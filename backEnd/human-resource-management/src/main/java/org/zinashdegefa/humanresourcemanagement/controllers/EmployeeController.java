package org.zinashdegefa.humanresourcemanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveEmployee")
    private String saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "Employee Successfully added";
    }

    @GetMapping("/getAllEmployees")

    public List<Employee> employees() {
        List<Employee> employees = employeeService.getAllEmployees();

        return employees;

    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){

        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employee/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Id number " + employeeId + " is deleted!";
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        System.out.println(employee.getFirstName() + " is updated!");
        return employee;
    }

}
