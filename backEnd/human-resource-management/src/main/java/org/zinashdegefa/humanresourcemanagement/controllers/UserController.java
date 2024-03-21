package org.zinashdegefa.humanresourcemanagement.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zinashdegefa.humanresourcemanagement.models.UserModel;
import org.zinashdegefa.humanresourcemanagement.services.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register/save")
    public String saveRegistration(@Valid @ModelAttribute("user") UserModel user, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        System.out.println("user: " + user);
        System.out.println("Result: " + result);
        UserModel existingUser = userService.getUserByEmail(user.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);

            return "/register";
        }

        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Successfully registered! Please login with your credentials");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "register";
    }
}
