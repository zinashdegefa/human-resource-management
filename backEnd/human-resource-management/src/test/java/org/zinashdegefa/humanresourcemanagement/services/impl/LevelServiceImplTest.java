package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.*;
import org.zinashdegefa.humanresourcemanagement.repositories.EmployeeRepository;
import org.zinashdegefa.humanresourcemanagement.repositories.LevelRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LevelServiceImplTest {

    @Autowired
    private LevelServiceImpl levelService;

    @MockBean
    private LevelRepository levelRepository;

    @Test
    void getLevelById() {


//        Mockito.when(levelRepository.findByLevelId().th
//        Level levId = levelService.getLevelById(levelId);
//        System.out.println("level id: " + levId);
//        Assertions.assertNotNull(levId);
//        assertEquals(1, levId.getId());
//    }

//    private Level levelId() {
//
//        Level levelId = Level.builder()
//                .id(1)
//                .build();
//        return levelId;
   }

}