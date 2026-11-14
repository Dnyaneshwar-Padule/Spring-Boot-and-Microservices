package com.tca.payload;

import com.tca.entity.Employee;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDto {

    public record Response(
            Integer id,
            String name,
            Double salary,
            String city
    ) {
        public static EmployeeDto.Response from(Employee employee) {
            return new EmployeeDto.Response(
                    employee.getId(),
                    employee.getName(),
                    employee.getSalary(),
                    employee.getCity()
            );
        }
    }

    public record PostRequest(
            @NotNull
            @Size(min = 2, max = Employee.MAX_NAME_LENGTH)
            String name,

            @NotNull
            @DecimalMin(value = "0.0")
            @DecimalMax(value = "9999999.99")
            Double salary,

            @NotNull
            @Size(min = 2, max = Employee.MAX_CITY_LENGTH)
            String city
    ) {}

    public record PutRequest(
            @NotNull
            Integer id,
            @NotNull
            @Size(min = 2, max = Employee.MAX_NAME_LENGTH)
            String name,

            @NotNull
            @DecimalMin(value = "0.0")
            @DecimalMax(value = "9999999.99")
            Double salary,

            @NotNull
            @Size(min = 2, max = Employee.MAX_CITY_LENGTH)
            String city
    ) {}

    public record PatchRequest(
            @Size(min = 2, max = Employee.MAX_NAME_LENGTH)
            String name,

            @DecimalMin(value = "0.0")
            @DecimalMax(value = "9999999.99")
            Double salary,

            @Size(min = 2, max = Employee.MAX_CITY_LENGTH)
            String city
    ) {}
}