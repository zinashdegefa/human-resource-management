package org.zinashdegefa.humanresourcemanagement.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.repositories.LevelRepository;
import org.zinashdegefa.humanresourcemanagement.services.LevelService;

import java.util.List;
import java.util.Optional;

// Level Service Implementation class

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public void saveLevel(Level level) {

        level.setLevelName(level.getLevelName().trim()); //Trim the name before saving

        levelRepository.save(level);
    }

    @Override
    public List<Level> getAllLevels() {
        List<Level> levels = levelRepository.findAll();

        return levels;

    }

    @Override
    @Transactional
    public Level getLevelById(int levelId) {
        Optional<Level> getLevelById = levelRepository.findById((long) levelId);
        if (getLevelById.isPresent()) {
            System.out.println("The Id of the level is " + getLevelById.get().getId());

            return getLevelById.get();
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteLevel(int levelId) {
        levelRepository.deleteById((long) levelId);
        System.out.println("The level with id number " + levelId + " is deleted!");
    }

    @Override
    @Transactional
    public void updateLevel(Level level) {

        levelRepository.save(level);
    }

    public Level getLevelByName(String levelName) {

        return levelRepository.findByLevelName(levelName.trim());

    }
}
