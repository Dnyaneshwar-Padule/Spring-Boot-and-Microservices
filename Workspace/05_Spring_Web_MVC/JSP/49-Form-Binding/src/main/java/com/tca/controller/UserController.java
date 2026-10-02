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
    public String showForm(){
        return "User";
    }

    /*
        Here, model has a User object, with key name as "user"
         and the parameters values will automatically bind with fields in the User object
     */
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model){
        System.out.println(user);
        return "register";
    }


}
