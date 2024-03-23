package org.zinashdegefa.humanresourcemanagement.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Role;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RoleRepositoryTest {


    @Autowired
    private RoleRepository RoleRepository;

    @Test
    void saveRole() {
        Role role = Role
                .builder()
                .roleName("TestRole")
                .build();


        RoleRepository.save(role);

        System.out.println("Saved Role: " + role);
        Assertions.assertTrue(role.getId() > 0);
    }

    @Test
    void getAllRole() {
        Role role = Role
                .builder()
                .roleName("TestRole1")
                .build();
        RoleRepository.save(role);
        List<Role> RoleList = RoleRepository.findAll();
        Assertions.assertNotNull(RoleList);
    }

    @Test
    void findByRoleName() {
        Role role = Role
                .builder()
                .roleName("TestRole2")
                .build();
        RoleRepository.save(role);

        Role dep = RoleRepository.findByRoleName("TestRole2");
        Assertions.assertEquals(dep.getRoleName(), "TestRole2");

    }

    @Test
    void updateRole() {
        Role role = Role
                .builder()
                .roleName("TestRole3")
                .build();
        RoleRepository.save(role);
        Role RoleFromDb = RoleRepository.findByRoleName("TestRole3");
        RoleFromDb.setRoleName("TestRole3Updated");

        System.out.println("Role updated " + RoleFromDb);
        RoleRepository.save(RoleFromDb);

        Role depUpdated = RoleRepository.findById((long)RoleFromDb.getId()).orElse(null);

        assertNotNull(depUpdated);
        assertEquals(depUpdated.getRoleName(), "TestRole3Updated");

    }

    @Test
    void deleteRole() {
        Role role = Role
                .builder()
                .roleName("TestRole5")
                .build();
        RoleRepository.save(role);

        Role RoleFromDb = RoleRepository.findByRoleName("TestRole5");

        RoleRepository.delete(RoleFromDb);

        Role RoleAfterDeleted = RoleRepository.findByRoleName("TestRole5");

        System.out.println("Role deleted " + RoleAfterDeleted);
        assertNull(RoleAfterDeleted);

    }

}