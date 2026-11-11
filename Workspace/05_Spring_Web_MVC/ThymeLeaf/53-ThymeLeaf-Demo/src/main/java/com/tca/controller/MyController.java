package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping("/welcome")
    public String welcome(Model model, @RequestParam("un") String userName){
        model.addAttribute("userName", userName);
        return "hello";
    }

}
