package com.application.travel_web_app.controller;

import com.application.travel_web_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleController {

    @Autowired
    private UserService userService;

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
