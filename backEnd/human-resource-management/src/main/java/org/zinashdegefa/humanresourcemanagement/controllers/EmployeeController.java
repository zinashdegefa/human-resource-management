package org.zinashdegefa.humanresourcemanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }


    @PostMapping("/saveEmployee")
    private String saveEmployee(@ModelAttribute("employee") Employee employee) {

        System.out.println("Employee to be updated:/saved "+ employee);
        employeeService.saveEmployee(employee);
        return "redirect:/getAllEmployees";
    }

    @GetMapping("/getAllEmployees")

    public String employees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "all-employees";

    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public String getEmployeeById(@PathVariable int employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("emp", employee);
        return "employee";
    }

    @DeleteMapping("/employee/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Id number " + employeeId + " is deleted!";
    }

//    @PutMapping("/updateEmployee")
//    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
//        employeeService.saveEmployee(employee);
//        System.out.println(employee.getFirstName() + " is updated!");
//        return "redirect:/getAllEmployees";
//    }

    @RequestMapping("/addForm")
    public String addForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-form";
    }

    @RequestMapping("/updateEmployee/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        System.out.println("Id: " + id);
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println("Employee to be updated: "+ employee);
        model.addAttribute("employee", employee);
        return "update-form";
    }

}
