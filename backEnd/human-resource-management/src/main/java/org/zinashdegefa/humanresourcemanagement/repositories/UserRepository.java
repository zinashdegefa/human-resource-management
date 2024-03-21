package org.zinashdegefa.humanresourcemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.UserModel;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);
}
