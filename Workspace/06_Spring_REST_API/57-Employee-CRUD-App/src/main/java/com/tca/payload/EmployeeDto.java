package com.tca.payload;

import com.tca.entity.Employee;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDto {

    public record PostRequest(
            @NotNull
            @Size(min = 2, max = 128)
            String name,

            @NotNull
            @DecimalMin(value = "0.0")
            Double salary,

            @NotNull
            @Size(min = 2, max = 128)
            String city
    ){}

    public record PutRequest(
            @NotNull
            Integer id,

            @NotNull
            @Size(min = 2, max = 128)
            String name,

            @NotNull
            @DecimalMin(value = "0.0")
            Double salary,

            @NotNull
            @Size(min = 2, max = 128)
            String city
    ){}

    public record Response(
            Integer id,
            String name,
            Double salary,
            String city
    ){
        public static Response from(Employee employee){
            return new Response(
                    employee.getId(),
                    employee.getName(),
                    employee.getSalary(),
                    employee.getCity()
            );
        }
    }
}
