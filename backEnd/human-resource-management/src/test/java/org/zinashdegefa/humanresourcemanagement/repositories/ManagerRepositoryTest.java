package org.zinashdegefa.humanresourcemanagement.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Manager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    void savemanager() {
        Manager manager = Manager
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment").build())
                .build();


        managerRepository.save(manager);

        System.out.println("Saved manager: " + manager);
        Assertions.assertTrue(manager.getId() > 0);
    }

    @Test
    void getAllManager() {
        Manager manager = Manager
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment1").build())

                .build();


        managerRepository.save(manager);
        List<Manager> managersList = managerRepository.findAll();
        Assertions.assertNotNull(managersList);
    }


    @Test
    void updateManager() {

        Manager manager = Manager
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment2").build())
                .build();
        managerRepository.save(manager);

        Manager managerFromDb = managerRepository.findById((long) manager.getId()).orElse(null);
        assertNotNull(managerFromDb);
        managerFromDb.setFirstName("TestFirstNameUpdated");

        System.out.println("manager updated " + managerFromDb);
        managerRepository.save(managerFromDb);

        Manager manUpdated = managerRepository.findById((long)managerFromDb.getId()).orElse(null);

        assertNotNull(manUpdated);
        assertEquals(manUpdated.getFirstName(), "TestFirstNameUpdated");

    }

    @Test
    void deletemanager() {
        Manager manager = Manager
                .builder()
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .department(Department.builder().departmentName("TestDepartment3").build())
                .build();
        managerRepository.save(manager);

        Manager managerFromDb = managerRepository.findById((long) manager.getId()).orElse(null);
        assertNotNull(managerFromDb);

        managerRepository.delete(managerFromDb);

        Manager managerAfterDeleted = managerRepository.findById((long) managerFromDb.getId()).orElse(null);

        System.out.println("manager deleted " + managerAfterDeleted);
        assertNull(managerAfterDeleted);

    }

}