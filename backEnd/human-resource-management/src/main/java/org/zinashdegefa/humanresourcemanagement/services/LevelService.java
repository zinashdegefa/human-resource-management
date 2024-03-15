package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Level;

import java.util.List;

public interface LevelService {

    void addLevel(Level level);
    List<Level> getAllLevels();
    void deleteLevel(int levelId);
}
