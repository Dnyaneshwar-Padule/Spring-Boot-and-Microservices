package com.tca.service;

import com.tca.entity.Employee;
import com.tca.payload.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeDto.Response save(EmployeeDto.PostRequest employeeDto);

    List<EmployeeDto.Response> getAll();

    boolean delete(Integer id);

    EmployeeDto.Response update(EmployeeDto.PutRequest employeeDto);

    Optional<EmployeeDto.Response> get(Integer id);
}
