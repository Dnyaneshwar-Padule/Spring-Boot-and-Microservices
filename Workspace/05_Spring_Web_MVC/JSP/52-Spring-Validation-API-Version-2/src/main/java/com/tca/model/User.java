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

    @NotBlank(message = "{NotBlank.user.name}")
    @Size(min = 2, max = 14 ,message = "{Size.user.name}")
    private String name;

    @NotBlank(message = "{NotBlank.user.email}")
    @Email(message = "{Email.user.email}")
    private String email;

    @Pattern(regexp="\\d{10}", message = "{Pattern.user.phone}")
    @NotNull(message = "{NotNull.user.phone}")
    private String phone;

    @NotBlank(message = "{NotBlank.user.gender}")
    @Pattern(
            regexp = "^(male|female)$",
            message = "{Pattern.user.gender}"
    )
    private String gender;

    @NotNull(message = "{NotNull.user.birthDate}")
    @Past(message = "{Past.user.birthDate}")
    private LocalDate birthDate;
}