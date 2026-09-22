package com.tca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @EmbeddedId
    private OrderItemId orderItemId;

    @Column(name = "QUANTITY", columnDefinition = "INT NOT NULL CHECK(QUANTITY > 0)")
    private Integer quantity;

    @Column(name = "PRICE", columnDefinition = "FLOAT NOT NULL CHECK(PRICE > 0)")
    private Double price;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH,
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "product_id")
    @MapsId("productId") /* Maps this relationship with orderItemId.productId  */
    private Product product;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH,
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "order_id")
    @MapsId("orderId") /* Maps this relationship with orderItemId.orderId  */
    private Order order;

}
