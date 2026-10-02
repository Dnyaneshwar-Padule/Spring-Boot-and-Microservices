package com.tca.controller;

import com.tca.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/form")
    public String showForm(Model model){
        User user  = new User();
        user.setName("Amit");
        user.setEmail("amit9@gmail.com");
        user.setGender("male");
        user.setPhone("9012345678");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/register")
    public String processForm(@ModelAttribute("user") User user, Model model){
        return "register";
    }

}
