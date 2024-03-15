package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.services.ManagerService;

import java.util.List;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/saveManager")
    private String saveManager(@RequestBody Manager manager) {
        managerService.saveManager(manager);
        return "Manager Successfully added";
    }

    @GetMapping("/getAllManagers")

    public List<Manager> managers() {
        List<Manager> managers = managerService.getAllManagers();

        return managers;

    }

    @DeleteMapping("/manager/delete/{managerId}")
    public String deleteDepartment(@PathVariable int managerId) {
        managerService.deleteManager(managerId);
        return "Id number " + managerId + " is deleted!";
    }

    @PutMapping("/updateManager")
    public Manager updateManager(@RequestBody Manager manager) {
        managerService.saveManager(manager);
        System.out.println(manager.getManagerId() + " is updated!");
        return manager;
    }




}
