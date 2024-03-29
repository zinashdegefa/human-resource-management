package org.zinashdegefa.humanresourcemanagement.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.services.*;

import java.util.List;

// Employee Controller with CRUD path
@Slf4j
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


    @PostMapping("/save/employee")
    private String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, RedirectAttributes redirectAttributes, Model model) {

        log.info("Employee to be updated:/saved " + employee);

        if (result.hasErrors()) {
            List<Role> roles = roleService.getAllRoles();
            List<Level> levels = levelService.getAllLevels();
            List<Department> departments = departmentService.getAllDepartments();
            List<Manager> managers = managerService.getAllManagers();
            model.addAttribute("employee", employee);
            model.addAttribute("roles", roles);
            model.addAttribute("levels", levels);
            model.addAttribute("departments", departments);
            model.addAttribute("managers", managers);
            model.addAttribute("employee", employee);

            return "add_employee_form";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/getAll/employees";
    }

    @GetMapping("/getAll/employees")

    public String employees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();

        for (Employee emp : employees) {
            log.info("Employee first name: " + emp.getFirstName());
        }
        model.addAttribute("employees", employees);
        return "all_employees";

    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("emp", employee);
        return employee;
    }

    @RequestMapping("/delete/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        log.warn("Employee deleted for id: " + employeeId);
        return "redirect:/getAll/employees";
    }


    @RequestMapping("/add/empForm")
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
        return "add_employee_form";
    }

    @RequestMapping("/update/employee/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        List<Role> roles = roleService.getAllRoles();
        List<Level> levels = levelService.getAllLevels();
        List<Department> departments = departmentService.getAllDepartments();
        List<Manager> managers = managerService.getAllManagers();
        log.info("Employee to be updated: " + employee);
        model.addAttribute("employee", employee);
        model.addAttribute("roles", roles);
        model.addAttribute("levels", levels);
        model.addAttribute("departments", departments);
        model.addAttribute("managers", managers);
        return "update_employee_form";
    }

}
