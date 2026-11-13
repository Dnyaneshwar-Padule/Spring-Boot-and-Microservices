package com.tca.controller;

import com.tca.payload.EmployeeDto;
import com.tca.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {

    private final EmployeeService  employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<EmployeeDto.Response> create(@Valid @RequestBody EmployeeDto.PostRequest employeeDto){
       EmployeeDto.Response created = employeeService.save(employeeDto);
       return new ResponseEntity<>(created, HttpStatus.CREATED);

       /*
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(created);
        */
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<EmployeeDto.Response>> showAll(){
        List<EmployeeDto.Response> employees = employeeService.getAll();
        if(employees.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(employeeService.delete(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto.Response> get(@PathVariable Integer id){
        Optional<EmployeeDto.Response> employeeDto = employeeService.get(id);
        return employeeDto.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto.Response> update(@Valid @RequestBody EmployeeDto.PutRequest employeeDto){
        EmployeeDto.Response created = employeeService.update(employeeDto);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

}
