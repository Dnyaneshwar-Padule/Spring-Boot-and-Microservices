package com.tca.repository;

import com.tca.entity.Employee;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // method provide by JpaRepository (PagingAndSortingRepository)
    // Page<Employee> findAll(Pageable pageable);
}
