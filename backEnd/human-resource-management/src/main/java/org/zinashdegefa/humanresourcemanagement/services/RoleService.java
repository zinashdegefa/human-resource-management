package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Role;

import java.util.List;

// Role Service Interface
public interface RoleService {

    Role saveRole(Role role);

    List<Role> getAllRoles();

    void deleteRole(int roleId);

    void updateRole(Role role);

    Role getRoleById(int roleId);

    Role getRoleByName(String roleName);
}
