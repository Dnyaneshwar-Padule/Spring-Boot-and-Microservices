package com.tca.service;

import com.tca.entity.Employee;
import com.tca.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<Employee> findAll(int page, int size) {
        //Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll( PageRequest.of(page, size) );
    }
}
