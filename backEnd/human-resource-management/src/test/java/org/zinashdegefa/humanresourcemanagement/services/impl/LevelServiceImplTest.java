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
import java.util.Optional;

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


        Mockito.when(levelRepository.findById(1L)).thenReturn(Optional.ofNullable(levelById()));
        Level lev = levelService.getLevelById(1);
        System.out.println("level : " + lev);
        Assertions.assertNotNull(lev);
        assertEquals("TestLevelName", lev.getLevelName());
    }

    private Level levelById() {

        return Level.builder()
                .levelName("TestLevelName")
                .build();
   }

}