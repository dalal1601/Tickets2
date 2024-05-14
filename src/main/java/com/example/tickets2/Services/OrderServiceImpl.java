package com.example.tickets2.Services;

import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.OrderDetail;
import com.example.tickets2.Entities.OrderT;
import com.example.tickets2.Entities.Ticket;
import com.example.tickets2.Enums.OrderState;
import com.example.tickets2.Repositories.OrderRepository;
import com.example.tickets2.Repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
@AllArgsConstructor
@Service

public class OrderServiceImpl implements OrderService{
    private TicketRepository ticketRepository;
    private OrderRepository orderRepository;

    @Override
    public OrderT addItemToCart(Ticket ticket, int quantity, Customer customer) {
        // Create an OrderDetail object
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setTicket(ticket);
        orderDetail.setQuantity((double) quantity);

        // Create or get the OrderT for the customer
        OrderT orderT = orderRepository.findByCustomerAndOrderState(customer, OrderState.New);
        if (orderT == null) {
            orderT = new OrderT();
            orderT.setCreateAt(new Date());
            orderT.setOrderState(OrderState.New);
            orderT.setCustomer(customer);
        }

        // Set the relationship between OrderT and OrderDetail
        orderDetail.setOrderT(orderT);
        orderT.getOrderDetailList().add(orderDetail);

        // Save or update OrderT
        return orderRepository.save(orderT);
    }

    @Override
    public OrderT updateItemInCart(Ticket ticket, int quantity, Customer customer) {
        OrderT orderT = orderRepository.findByCustomerAndOrderState(customer, OrderState.New);
        if (orderT == null) {
            return null;
        }

        //  OrderDetail corresponding to the provided Ticketttttttttttttt
        OrderDetail orderDetailToUpdate = null;
        for (OrderDetail orderDetail : orderT.getOrderDetailList()) {
            if (orderDetail.getTicket().equals(ticket)) {
                orderDetailToUpdate = orderDetail;
                break;
            }
        }

        if (orderDetailToUpdate != null) {
            orderDetailToUpdate.setQuantity((double) quantity);
            if (quantity == 0) {
                orderT.getOrderDetailList().remove(orderDetailToUpdate);
            }
        } else {
            orderDetailToUpdate = new OrderDetail();
            orderDetailToUpdate.setTicket(ticket);
            orderDetailToUpdate.setQuantity((double) quantity);
            orderDetailToUpdate.setOrderT(orderT);
            orderT.getOrderDetailList().add(orderDetailToUpdate);
        }
        return orderRepository.save(orderT);

    }

    @Override
    public OrderT deleteItemFromCart(Ticket ticket, Customer customer) {
        OrderT orderT = orderRepository.findByCustomerAndOrderState(customer, OrderState.New);
        if (orderT == null) {
            return null;
        }

        OrderDetail orderDetailToRemove = null;
        for (OrderDetail orderDetail : orderT.getOrderDetailList()) {
            if (orderDetail.getTicket().equals(ticket)) {
                orderDetailToRemove = orderDetail;
                break;
            }
        }

        if (orderDetailToRemove != null) {
            orderT.getOrderDetailList().remove(orderDetailToRemove);
        } else {
            return null;
        }

        return orderRepository.save(orderT);
    }

    @Override
    public OrderT getCurrentOrder(Customer customer) {
        return orderRepository.findByCustomerAndOrderState(customer, OrderState.New);
    }
    @Override
    public double getTotalPrice(OrderT order) {
        double totalPrice = 0.0;

        for (OrderDetail orderDetail : order.getOrderDetailList()) {
            totalPrice += orderDetail.getQuantity() * orderDetail.getTicket().getPrice();
        }

        return totalPrice;
    }

    @Override
    public OrderT save(OrderT order) {
        return orderRepository.save(order);
    }

    public OrderT findOrCreateOrder(Customer customer) {
        OrderT order = orderRepository.findByCustomerAndOrderState(customer, OrderState.New);

        // If no open order found, create a new one
        if (order == null) {
            order = OrderT.builder()
                    .customer(customer)
                    .orderState(OrderState.New)
                    .createAt(new Date())
                    .build();
            order = orderRepository.save(order);
        }

        return order;
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        OrderT order = orderDetail.getOrderT();

        if (order == null || order.getOrderState() != OrderState.New) {
            throw new IllegalStateException("Order is null or closed");
        }

        order.getOrderDetailList().add(orderDetail);

        orderRepository.save(order);
    }




}
