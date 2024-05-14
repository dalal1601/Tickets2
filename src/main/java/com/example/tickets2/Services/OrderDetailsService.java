package com.example.tickets2.Services;

import com.example.tickets2.Entities.OrderDetail;
import com.example.tickets2.Repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    private  OrderDetailsRepository orderDetailRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id);
    }

    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderDetailById(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
