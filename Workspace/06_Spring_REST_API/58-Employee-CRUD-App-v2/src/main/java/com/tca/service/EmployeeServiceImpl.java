package com.tca.service;

import com.tca.entity.Employee;
import com.tca.payload.EmployeeDto;
import com.tca.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto.Response add(EmployeeDto.PostRequest employeeDto) {
        return EmployeeDto.Response.from(employeeRepository.save(map(employeeDto)));
    }

    @Override
    public List<EmployeeDto.Response> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDto.Response::from)
                .toList();
    }

    @Override
    public Optional<EmployeeDto.Response> getById(Integer id) {
        return employeeRepository.findById(id).map(EmployeeDto.Response::from);
    }

    @Override
    public Optional<EmployeeDto.Response> modifyPartially(EmployeeDto.PatchRequest employeeDto, Integer id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    if (employeeDto.city() != null) {
                        employee.setCity(employeeDto.city());
                    }
                    if (employeeDto.name() != null ) {
                        employee.setName(employeeDto.name());
                    }
                    if (employeeDto.salary() != null ) {
                        employee.setSalary(employeeDto.salary());
                    }
                    return EmployeeDto.Response.from(employeeRepository.save(employee));
                });
    }

    @Override
    public EmployeeDto.Response modify(EmployeeDto.PutRequest employeeDto) {
        return EmployeeDto.Response.from(employeeRepository.save(map(employeeDto)));
    }

    @Override
    public boolean deleteById(Integer id) {
        if (getById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Employee map(EmployeeDto.PostRequest employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.name());
        employee.setSalary(employeeDto.salary());
        employee.setCity(employeeDto.city());
        return employee;
    }

    private Employee map(EmployeeDto.PutRequest employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.id());
        employee.setName(employeeDto.name());
        employee.setSalary(employeeDto.salary());
        employee.setCity(employeeDto.city());
        return employee;
    }

}

//    @Override
//    public Optional<EmployeeDto.Response> modifyPartially(Map<String, Object> fieldMap, Integer id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isEmpty()) {
//            return Optional.empty();
//        }
//
//        try {
//            Map<String, Field> fields = Arrays.stream(Employee.class.getDeclaredFields())
//                    .filter(field -> !Modifier.isStatic(field.getModifiers()))
//                    .collect(Collectors.toMap(Field::getName, field -> field));
//
//            for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
//                if (fields.containsKey(entry.getKey()) && canModify(entry.getKey()) && entry.getValue() != null) {
//                    Field field = fields.get(entry.getKey());
//                    field.setAccessible(true);
//
//                    // fields are of different type.
//                    if (! field.getType().equals(fieldMap.get(entry.getKey()).getClass())) {
//                        return Optional.empty();
//                    }
//
//                    field.set(employee.get(), fieldMap.get(entry.getKey()));
//                }
//            }
//
//            employeeRepository.save(employee.get());
//            return Optional.of(EmployeeDto.Response.from(employee.get()));
//
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }

//    private boolean canModify(String fieldName) {
//        return switch (fieldName) {
//            case "name", "city" -> true;
//            case "salary" -> true; // by role checking ....
//            default -> false;
//        };
//    }
