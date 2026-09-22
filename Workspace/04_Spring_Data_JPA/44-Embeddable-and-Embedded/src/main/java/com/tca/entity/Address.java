package com.tca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "CITY", length = 64, nullable = false)
    private String city;

    @Column(name = "STATE", length = 64, nullable = false)
    private String state;

    @Column(name = "PIN_CODE", length = 6, nullable = false)
    private String pinCode;
}
