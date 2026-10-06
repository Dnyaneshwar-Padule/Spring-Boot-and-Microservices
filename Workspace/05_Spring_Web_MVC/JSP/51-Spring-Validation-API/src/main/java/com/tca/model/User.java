package com.tca.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank(message = "Username can not be null.")
    @Size(min = 2, max = 14 ,message = "Name should have at least 2 characters and at most 14 characters")
    private String name;

    @NotBlank(message = "Email should not be null")
    @Email(message = "Invalid email")
    private String email;

    @Pattern(regexp="\\d{10}", message = "Invalid phone number")
    @NotNull(message = "phone number can not be null")
    private String phone;

    @NotBlank(message = "Gender can not be null")
    @Pattern(
            regexp = "^(male|female)$",
            message = "Gender can be either male or female"
    )
    private String gender;

    @Past(message = "Birth Date should be in past")
    private LocalDate birthDate;
}
