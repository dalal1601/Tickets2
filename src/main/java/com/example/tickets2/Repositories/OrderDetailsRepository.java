package com.example.tickets2.Repositories;

import com.example.tickets2.Entities.Event;
import com.example.tickets2.Entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long> { //JpaRepository fournit une API riche pour effectuer des opérations CRUD
}
