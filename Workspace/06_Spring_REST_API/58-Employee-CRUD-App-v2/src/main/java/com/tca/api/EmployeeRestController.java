package com.tca.api;

import com.tca.payload.EmployeeDto;
import com.tca.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto.Response> findById(@PathVariable Integer id) {
        return employeeService.getById(id)
                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto.Response> register(@Valid @RequestBody EmployeeDto.PostRequest employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.add(employeeDto));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto.Response>> getAll() {
        List<EmployeeDto.Response> employees = employeeService.getAll();
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PutMapping("/modify")
    public ResponseEntity<EmployeeDto.Response> modify(@Valid @RequestBody EmployeeDto.PutRequest employeeDto) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.modify(employeeDto));
    }

    @PatchMapping("/modify/{id}")
    public ResponseEntity<EmployeeDto.Response> partialModify(@PathVariable Integer id, @Valid @RequestBody EmployeeDto.PatchRequest employeeDto) {
        return employeeService.modifyPartially(employeeDto, id)
                .map(employee -> ResponseEntity.status(HttpStatus.OK).body(employee))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

}