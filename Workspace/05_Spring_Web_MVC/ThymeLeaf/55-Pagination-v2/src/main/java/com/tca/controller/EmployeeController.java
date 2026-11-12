package com.tca.controller;

import com.tca.entity.Employee;
import com.tca.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private final Integer size = 6;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page){
        Page<Employee> employeePage = employeeService.getAll(page - 1, size);
        model.addAttribute("employees", employeePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", employeePage.hasNext());
        model.addAttribute("hasPrevious", employeePage.hasPrevious());
        model.addAttribute("totalPages", employeePage.getTotalPages());

        return "show";
    }
}
