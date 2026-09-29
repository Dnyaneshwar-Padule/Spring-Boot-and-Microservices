package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/msg")
    public String greet(){
        return "hello"; // logical view name (actually the name of jsp file)
    }

}
