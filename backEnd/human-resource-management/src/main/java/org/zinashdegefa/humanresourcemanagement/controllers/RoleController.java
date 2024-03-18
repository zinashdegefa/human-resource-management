package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/saveRole")
    private String saveRole(@ModelAttribute("role") Role role) {
        System.out.println("Role to be updated:/saved "+ role);
        roleService.saveRole(role);
        return "redirect:/getAllRoles";
    }

    @GetMapping("/getAllRoles")

    public String roles (Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);

        return "all-roles";
    }

    @GetMapping("/getRoleById/{roleId}")
    public Role getRoleById(@PathVariable int roleId){

        return roleService.getRoleById(roleId);
    }

    @RequestMapping("/role/delete/{roleId}")
    public String deleteRole(@PathVariable int roleId) {
        System.out.println("Id number " + roleId + " is deleted!");
        roleService.deleteRole(roleId);
        return "redirect:/getAllRoles";
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role role) {
        roleService.saveRole(role);
        System.out.println(role.getRoleName() + " is updated!");
        return role;
    }

    @RequestMapping("/addRolForm")
    public String addForm(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "add-rol-form";
    }
}
