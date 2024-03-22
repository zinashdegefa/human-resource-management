package org.zinashdegefa.humanresourcemanagement.services;

import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Level;

import java.util.List;

public interface LevelService {

    void saveLevel(Level level);
    List<Level> getAllLevels();
    void deleteLevel(int levelId);
    public void updateLevel(Level level);
    Level getLevelById(int levelId);

    Level getLevelByName(String levelName);
}
