package org.zinashdegefa.humanresourcemanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Department;
import org.zinashdegefa.humanresourcemanagement.models.Employee;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.services.LevelService;

import java.util.List;

@Controller
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/save/level")
    private String saveLevel(@ModelAttribute("level") Level level) {
        System.out.println("Level to be updated:/saved "+ level);
        levelService.saveLevel(level);
        return "redirect:/getAll/levels";
    }

    @GetMapping("/getAll/levels")

    public String levels(Model model) {
        List<Level> levels = levelService.getAllLevels();
        model.addAttribute("levels", levels);

        return "all-levels";
    }

    @GetMapping("/getLevelById/{levelId}")
    public Level getLevelById(@PathVariable int levelId){

        return levelService.getLevelById(levelId);
    }

    @RequestMapping ("/delete/level/{levelId}")
    public String deleteLevel(@PathVariable int levelId) {
        levelService.deleteLevel(levelId);
        System.out.println("Id number " + levelId + " is deleted!");
        return "redirect:/getAll/levels";
    }

    @PutMapping("/update/level")
    public Level updateLevel(@RequestBody Level level) {
        levelService.saveLevel(level);
        System.out.println(level.getId() + " is updated!");
        return level;
    }

    @RequestMapping("/add/levForm")
    public String addForm(Model model) {
        Level level = new Level();
        model.addAttribute("level", level);
        return "add-lev-form";
    }
}
