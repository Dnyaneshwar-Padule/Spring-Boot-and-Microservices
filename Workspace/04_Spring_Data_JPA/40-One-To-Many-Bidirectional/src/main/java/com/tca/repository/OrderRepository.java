package com.tca.repository;

import com.tca.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE ORDERS o SET o.customer = null WHERE o.id = :id")
    // Can't use Order o as entity name in above JPQL,
    // we have changed it to ORDERS
    // i.e in Order entity, we have done @Entity(name="ORDERS"), so JPQL also refers that name
    public void softDelete(Long id);
}
