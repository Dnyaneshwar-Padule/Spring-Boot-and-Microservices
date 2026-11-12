package com.tca.controller;

import com.tca.entity.Student;
import com.tca.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/save")
    public String save(Model model){
        model.addAttribute("student", new Student());
        return "save";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid @ModelAttribute Student student, BindingResult result){

        if(result.hasErrors())
            return "save";

        student = studentService.save(student);
        model.addAttribute("student", student);
        model.addAttribute("hasError", false);
        return "save";
    }

}
