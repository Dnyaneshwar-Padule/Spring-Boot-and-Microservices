package com.tca.service;

import com.tca.entity.Employee;
import com.tca.payload.EmployeeDto;
import com.tca.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto.Response save(EmployeeDto.PostRequest employeeDto) {
        return EmployeeDto.Response.from(employeeRepository.save(mapToEmployee(employeeDto)));
    }

    @Override
    public List<EmployeeDto.Response> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> {return new EmployeeDto.Response(
                        employee.getId(),
                        employee.getName(),
                        employee.getSalary(),
                        employee.getCity());
                })
                .toList();
    }

    @Override
    public boolean delete(Integer id) {
        if(! employeeRepository.existsById(id))
            return false;
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDto.Response update(EmployeeDto.PutRequest employeeDto) {
        return EmployeeDto.Response.from(employeeRepository.save(mapToEmployee(employeeDto)));
    }

    @Override
    public Optional<EmployeeDto.Response> get(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent())
            return Optional.of( EmployeeDto.Response.from(employee.get()));
        return Optional.empty();
    }

    private static Employee mapToEmployee(EmployeeDto.PostRequest employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.name());
        employee.setSalary(employeeDto.salary());
        employee.setCity(employeeDto.city());
        return employee;
    }
    private static Employee mapToEmployee(EmployeeDto.PutRequest employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.id());
        employee.setName(employeeDto.name());
        employee.setSalary(employeeDto.salary());
        employee.setCity(employeeDto.city());
        return employee;
    }
}
