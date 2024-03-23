package org.zinashdegefa.humanresourcemanagement.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zinashdegefa.humanresourcemanagement.models.Level;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LevelRepositoryTest {

    @Autowired
    private LevelRepository levelRepository;

    @Test
    void saveLevel() {
        Level level = Level
                .builder()
                .levelName("TestLevel")
                .build();


        levelRepository.save(level);

        System.out.println("Saved level: " + level);
        Assertions.assertTrue(level.getId() > 0);
    }

    @Test
    void getAllLevel() {
        Level level = Level
                .builder()
                .levelName("Testlevel1")
                .build();
        levelRepository.save(level);
        List<Level> levelList = levelRepository.findAll();
        Assertions.assertNotNull(levelList);
    }

    @Test
    void findByLevelName() {
        Level level = Level
                .builder()
                .levelName("TestLevel2")
                .build();
        levelRepository.save(level);

        Level dep = levelRepository.findByLevelName("TestLevel2");
        Assertions.assertEquals(dep.getLevelName(), "TestLevel2");

    }

    @Test
    void updateLevel() {
        Level level = Level
                .builder()
                .levelName("TestLevel3")
                .build();
        levelRepository.save(level);
        Level levelFromDb = levelRepository.findByLevelName("TestLevel3");
        levelFromDb.setLevelName("TestLevel3Updated");

        System.out.println("level updated " + levelFromDb);
        levelRepository.save(levelFromDb);

        Level depUpdated = levelRepository.findById((long)levelFromDb.getId()).orElse(null);

        assertNotNull(depUpdated);
        assertEquals(depUpdated.getLevelName(), "TestLevel3Updated");

    }

    @Test
    void deleteLevel() {
        Level level = Level
                .builder()
                .levelName("TestLevel5")
                .build();
        levelRepository.save(level);

        Level levelFromDb = levelRepository.findByLevelName("TestLevel5");

        levelRepository.delete(levelFromDb);

        Level levelAfterDeleted = levelRepository.findByLevelName("TestLevel5");

        System.out.println("level deleted " + levelAfterDeleted);
        assertNull(levelAfterDeleted);

    }

}