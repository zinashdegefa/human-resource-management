package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zinashdegefa.humanresourcemanagement.models.Manager;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    // Custom method to get Manager by DepartmentId
    Optional<Manager> findByDepartmentId(int id);
}
