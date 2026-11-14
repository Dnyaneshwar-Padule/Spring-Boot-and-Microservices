package com.tca.service;

import com.tca.payload.EmployeeDto;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeDto.Response add(EmployeeDto.PostRequest employeeDto);

    List<EmployeeDto.Response> getAll();

    Optional<EmployeeDto.Response> getById(Integer id);

    Optional<EmployeeDto.Response> modifyPartially(EmployeeDto.PatchRequest employeeDto, Integer id);

    EmployeeDto.Response modify(EmployeeDto.PutRequest employeeDto);

    boolean deleteById(Integer id);
}
