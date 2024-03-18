package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;

import java.util.List;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/saveDepartment")
    private String saveDepartment(@ModelAttribute("department") Department department) {

        System.out.println("Department to be updated:/saved "+ department);
        departmentService.saveDepartment(department);
        return "redirect:/getAllDepartments";
    }

    @GetMapping("/getAllDepartments")

    public String departments (Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "all-departments";
    }


    @GetMapping("/getDepartmentById/{departmentId}")
    public Department getDepartmentById(@PathVariable int departmentId){

        return departmentService.getDepartmentById(departmentId);
    }

    @RequestMapping("/department/delete/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {
        departmentService.deleteDepartment(departmentId);
        System.out.println("Employee deleted for id: " + departmentId);
        return "redirect:/getAllDepartments";
    }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        System.out.println(department.getDepartmentName() + " is updated!");
        return department;
    }

    @RequestMapping("/addDepForm")
    public String addForm(Model model) {
//        List<Department> departments = departmentService.getAllDepartments();
       Department department = new Department();
        model.addAttribute("department", department);
        return "add-dep-form";
    }
}
