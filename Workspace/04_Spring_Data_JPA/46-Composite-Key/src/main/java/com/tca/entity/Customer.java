package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 128, nullable = false)
    private String name;

    @Column(name = "EMAIL", length = 128, nullable = false, unique = true)
    private String email;

    private LocalDate birthDate; /* optional field */

    @Embedded
    private Address address; /* A person can contain multiple addresses, but for now, it's fine. */

    /* cascade type shouldn't be all...., as it can lead to miscalculations */
    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
        mappedBy = "customer"
    )
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        if(order == null)
            return;
        orders.add(order);
        order.setCustomer(this);
    }

}
