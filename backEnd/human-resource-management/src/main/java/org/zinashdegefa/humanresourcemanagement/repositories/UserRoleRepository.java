package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zinashdegefa.humanresourcemanagement.models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    // Custom method to get UserRole by name
    UserRole findByName(String name);
}
