package com.application.travel_web_app.controller;

import com.application.travel_web_app.dto.UserDto;
import com.application.travel_web_app.entity.User;
import com.application.travel_web_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model) {
//        System.out.println("USERSSSS");
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/users/makeAdmin")
    public String makeAdmin(@RequestParam(name = "id") Long id) {
        userService.updateUserRole(id, "ROLE_ADMIN");
        return "redirect:/users";
    }

    @PostMapping("/users/makeMod")
    public String makeMod(@RequestParam(name = "id") Long id) {
        userService.updateUserRole(id, "ROLE_MOD");
        return "redirect:/users";
    }

    @PostMapping("/users/makeUser")
    public String makeUser(@RequestParam(name = "id") Long id) {
        userService.updateUserRole(id, "ROLE_USER");
        return "redirect:/users";
    }
}
