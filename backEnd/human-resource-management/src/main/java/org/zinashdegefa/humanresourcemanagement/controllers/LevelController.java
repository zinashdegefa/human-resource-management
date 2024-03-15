package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.services.LevelService;

import java.util.List;

@RestController
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/addLevel")
    private String addLevel(@RequestBody Level level) {
        levelService.addLevel(level);
        return "Level Successfully added";
    }

    @GetMapping("/getAllLevels")

    public List<Level> levels() {
        List<Level> levels = levelService.getAllLevels();

        return levels;

    }

    @DeleteMapping("/level/delete/{levelId}")
    public String deleteLevel(@PathVariable int levelId) {
        levelService.deleteLevel(levelId);
        return "Id number " + levelId + " is deleted!";
    }
}
