package com.tca.service;

import com.tca.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Page<Employee> findAll(int page, int size);
}
