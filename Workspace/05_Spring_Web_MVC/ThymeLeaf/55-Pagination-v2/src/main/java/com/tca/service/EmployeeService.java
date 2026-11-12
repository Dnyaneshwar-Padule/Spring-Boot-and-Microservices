package com.tca.service;

import com.tca.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    Page<Employee> getAll(int page, int size);
}
