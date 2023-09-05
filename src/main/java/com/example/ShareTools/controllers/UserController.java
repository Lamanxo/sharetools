package com.example.ShareTools.controllers;

import com.example.ShareTools.model.User;
import com.example.ShareTools.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public String createUser(User user, Model model) {
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage", "User with email: "
                    + user.getEmail() + " exist" );
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
}
