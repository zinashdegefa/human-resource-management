package org.zinashdegefa.humanresourcemanagement.controllers;

import com.mysql.cj.util.StringUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zinashdegefa.humanresourcemanagement.models.Level;
import org.zinashdegefa.humanresourcemanagement.services.LevelService;

import java.util.List;

// Level Controller with CRUD path
@Slf4j
@Controller
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/save/level")
    private String saveLevel(@Valid @ModelAttribute("level") Level level, BindingResult result, Model model) {
        System.out.println("Level to be updated:/saved "+ level);
        Level existingLevel = levelService.getLevelByName(level.getLevelName());

        if (existingLevel != null && !StringUtils.isNullOrEmpty(existingLevel.getLevelName())) {
           result.rejectValue("levelName", null, "There is already a level registered with the same name");
       }

        if(result.hasErrors()){
           model.addAttribute("level", level);
            return "add_level_form";
       }
        levelService.saveLevel(level);
        return "redirect:/getAll/levels";
    }

    @GetMapping("/getAll/levels")

    public String levels(Model model) {
        List<Level> levels = levelService.getAllLevels();
        for(Level level: levels){
            log.info("Level name: " + level.getLevelName());
        }
        model.addAttribute("levels", levels);

        return "all_levels";
    }

    @GetMapping("/getLevelById/{levelId}")
    public Level getLevelById(@PathVariable int levelId){

        return levelService.getLevelById(levelId);
    }

    @RequestMapping ("/delete/level/{levelId}")
    public String deleteLevel(@PathVariable int levelId) {
        try{
            levelService.deleteLevel(levelId);
            System.out.println("Id number " + levelId + " is deleted!");
            return "redirect:/getAll/levels";
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return "redirect:/getAll/levels?failed";
        }
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
        return "add_level_form";
    }
}
