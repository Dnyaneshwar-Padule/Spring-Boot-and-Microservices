package com.tca.controller;

import com.tca.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/register")
    public  String register(@Validated @ModelAttribute("user") User user, BindingResult result, Model model){
        if(result.hasErrors())
            return "form";
        return "register";
    }



}
