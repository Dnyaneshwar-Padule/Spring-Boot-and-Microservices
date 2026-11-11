package com.tca.controller;

import com.tca.entity.Employee;
import com.tca.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private final Integer size = 5;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public String findALl(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page){
        Page<Employee> employeePage = employeeService.findAll(page, size);
        /*
            List<Employee> employees = new ArrayList<>();
            employeePage.forEach( employee -> {
                employees.add(employee);
            });
            model.addAttribute("employees", employees);
         */
        model.addAttribute("employees", employeePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", employeePage.hasNext());
        model.addAttribute("hasPrevious", employeePage.hasPrevious());
        return "show";
    }

}
