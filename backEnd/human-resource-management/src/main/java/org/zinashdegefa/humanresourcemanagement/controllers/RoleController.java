package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.models.Role;
import org.zinashdegefa.humanresourcemanagement.services.RoleService;

import java.util.List;

@Controller
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {

        this.roleService = roleService;
    }

    @PostMapping("/save/role")
    private String saveRole(@ModelAttribute("role") Role role) {
        System.out.println("Role to be updated:/saved "+ role);
        roleService.saveRole(role);
        return "redirect:/getAll/roles";
    }

    @GetMapping("/getAll/roles")

    public String roles (Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);

        return "all-roles";
    }

    @GetMapping("/getRoleById/{roleId}")
    public Role getRoleById(@PathVariable int roleId){

        return roleService.getRoleById(roleId);
    }

    @RequestMapping("/delete/role/{roleId}")
    public String deleteRole(@PathVariable int roleId) {

       try{
           roleService.deleteRole(roleId);
           System.out.println("Id number " + roleId + " is deleted!");
           return "redirect:/getAll/roles";
       } catch (Exception e) {
           System.out.println("Exception: " + e);
           return "redirect:/getAll/roles?failed";
       }
    }

    @PutMapping("/update/role")
    public Role updateRole(@RequestBody Role role) {
        roleService.saveRole(role);
        System.out.println(role.getRoleName() + " is updated!");
        return role;
    }

    @RequestMapping("/add/roleForm")
    public String addForm(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "add-rol-form";
    }
}
