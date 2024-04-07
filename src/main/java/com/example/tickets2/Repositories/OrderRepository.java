package com.example.tickets2.Repositories;


import com.example.tickets2.Entities.OrderT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderT, Long> {
}
