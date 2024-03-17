package org.zinashdegefa.humanresourcemanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.services.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final RoleService roleService;
    private final LevelService levelService;
    private final ManagerService managerService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, RoleService roleService, LevelService levelService, ManagerService managerService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.roleService = roleService;
        this.levelService = levelService;
        this.managerService = managerService;
        this.departmentService = departmentService;
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

    @RequestMapping("/employee/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee deleted for id: " + employeeId);
        return "redirect:/getAllEmployees";
    }

//    @PutMapping("/updateEmployee")
//    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
//        employeeService.saveEmployee(employee);
//        System.out.println(employee.getFirstName() + " is updated!");
//        return "redirect:/getAllEmployees";
//    }

    @RequestMapping("/addForm")
    public String addForm(Model model) {
        List<Role> roles = roleService.getAllRoles();
        List<Level> levels = levelService.getAllLevels();
        List<Department> departments = departmentService.getAllDepartments();
        List<Manager> managers = managerService.getAllManagers();
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("roles", roles);
        model.addAttribute("levels", levels);
        model.addAttribute("departments", departments);
        model.addAttribute("managers", managers);
        return "add-form";
    }

    @RequestMapping("/updateEmployee/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        System.out.println("Id: " + id);
        Employee employee = employeeService.getEmployeeById(id);
        List<Role> roles = roleService.getAllRoles();
        List<Level> levels = levelService.getAllLevels();
        List<Department> departments = departmentService.getAllDepartments();
        List<Manager> managers = managerService.getAllManagers();
        System.out.println("Employee to be updated: "+ employee);
        model.addAttribute("employee", employee);
        model.addAttribute("roles", roles);
        model.addAttribute("levels", levels);
        model.addAttribute("departments", departments);
        model.addAttribute("managers", managers);
        return "update-form";
    }

}
