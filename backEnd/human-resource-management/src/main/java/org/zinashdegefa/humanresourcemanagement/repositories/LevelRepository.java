package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    // Custom method to find Level by name
    Level findByLevelName(String levelName);
}
