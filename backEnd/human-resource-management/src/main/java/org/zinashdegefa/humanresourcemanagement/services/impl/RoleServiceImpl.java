package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Manager;
import org.zinashdegefa.humanresourcemanagement.models.Role;
import org.zinashdegefa.humanresourcemanagement.repositories.RoleRepository;
import org.zinashdegefa.humanresourcemanagement.services.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveRole(Role role) {

        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roles;

    }

    @Override
    @Transactional
    public Role getRoleById(int roleId) {
        Optional<Role> getRoleById = roleRepository.findById((long) roleId);
        if (getRoleById.isPresent()) {
            System.out.println("The role name is " + getRoleById.get().getRoleName());
            return getRoleById.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteRole(int roleId) {
        roleRepository.deleteById((long) roleId);
        System.out.println("The role with id number "  + roleId + " is deleted!");
    }

    @Override
    @Transactional
    public void updateRole(Role role) {

        roleRepository.save(role);
    }
}