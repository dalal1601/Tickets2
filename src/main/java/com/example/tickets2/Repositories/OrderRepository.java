package com.example.tickets2.Repositories;


import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.OrderT;
import com.example.tickets2.Enums.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderT, Long> {
    OrderT findByCustomerAndOrderState(Customer customer, OrderState orderState);
}
