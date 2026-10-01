package com.tca.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping("/greet")
    public String greet(){
        return "form";
    }

    @PostMapping("/greet")
    public String greet(@RequestParam("username") String userName, Model model){
        System.out.println(userName);
        model.addAttribute("username", userName);
        return "greet";
    }


}
