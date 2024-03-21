package org.zinashdegefa.humanresourcemanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.services.DepartmentService;

import java.util.List;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save/department")
    private String saveDepartment(@Valid @ModelAttribute("department") Department department, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        System.out.println("Result for department: " + result);
        System.out.println("Department to be saved "+ department);

        Department existingDepartment = departmentService.getDepartmentByName(department.getDepartmentName());

        if (existingDepartment != null && existingDepartment.getDepartmentName() != null && !existingDepartment.getDepartmentName().isEmpty()) {
           result.rejectValue("departmentName", null, "There is already an account registered with the same name");
        }

        if(result.hasErrors()){
            model.addAttribute("department", department);
            return "/add-dep-form";
        }
        departmentService.saveDepartment(department);
        return "redirect:/getAll/departments";
    }


    @GetMapping("/getAll/departments")

    public String departments (Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "all-departments";
    }


    @GetMapping("/getDepartmentById/{departmentId}")
    public Department getDepartmentById(@PathVariable int departmentId){

        return departmentService.getDepartmentById(departmentId);
    }

    @RequestMapping("/delete/department/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {
        departmentService.deleteDepartment(departmentId);
        System.out.println("Department deleted for id: " + departmentId);
        return "redirect:/getAll/departments";
    }

    @PutMapping("/update/department")
    public Department updateDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        System.out.println(department.getDepartmentName() + " is updated!");
        return department;
    }

    @GetMapping("/add/depForm")
    public String addForm(Model model) {
//        List<Department> departments = departmentService.getAllDepartments();
       Department department = new Department();
        model.addAttribute("department", department);
        return "add-dep-form";
    }
}
