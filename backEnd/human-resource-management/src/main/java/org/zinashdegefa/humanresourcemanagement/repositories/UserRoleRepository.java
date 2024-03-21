package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zinashdegefa.humanresourcemanagement.models.UserRole;

public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
    UserRole findByName(String name);
}
