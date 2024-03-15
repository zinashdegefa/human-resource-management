package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zinashdegefa.humanresourcemanagement.models.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}
