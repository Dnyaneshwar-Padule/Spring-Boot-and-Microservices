package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name = "CITY", length = 64, nullable = false)
    private String city;

    @Column(name = "STATE", nullable = false, length = 64)
    private String state;

    @Column(name = "PIN_CODE", nullable = false, length = 6)
    private String pinCode;
}
