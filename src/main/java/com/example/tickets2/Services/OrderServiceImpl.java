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
        // Find the OrderT for the customer
        OrderT orderT = orderRepository.findByCustomerAndOrderState(customer, OrderState.New);
        if (orderT == null) {
            // If no order exists for the customer, return null or throw an exception
            return null; // or throw new OrderNotFoundException("No order found for the customer");
        }

        // Find the OrderDetail corresponding to the provided Ticket
        OrderDetail orderDetailToUpdate = null;
        for (OrderDetail orderDetail : orderT.getOrderDetailList()) {
            if (orderDetail.getTicket().equals(ticket)) {
                orderDetailToUpdate = orderDetail;
                break;
            }
        }

        if (orderDetailToUpdate != null) {
            // Update the quantity of the found OrderDetail
            orderDetailToUpdate.setQuantity((double) quantity);

            // If quantity is zero, remove the OrderDetail
            if (quantity == 0) {
                orderT.getOrderDetailList().remove(orderDetailToUpdate);
            }
        } else {
            // If no OrderDetail found for the Ticket, create a new one
            orderDetailToUpdate = new OrderDetail();
            orderDetailToUpdate.setTicket(ticket);
            orderDetailToUpdate.setQuantity((double) quantity);
            orderDetailToUpdate.setOrderT(orderT);
            orderT.getOrderDetailList().add(orderDetailToUpdate);
        }

        // Save or update OrderT
        return orderRepository.save(orderT);

    }

    @Override
    public OrderT deleteItemFromCart(Ticket ticket, Customer customer) {
        // Find the OrderT for the customer
        OrderT orderT = orderRepository.findByCustomerAndOrderState(customer, OrderState.New);
        if (orderT == null) {
            // If no order exists for the customer, return null or throw an exception
            return null; // or throw new OrderNotFoundException("No order found for the customer");
        }

        // Find the OrderDetail corresponding to the provided Ticket
        OrderDetail orderDetailToRemove = null;
        for (OrderDetail orderDetail : orderT.getOrderDetailList()) {
            if (orderDetail.getTicket().equals(ticket)) {
                orderDetailToRemove = orderDetail;
                break;
            }
        }

        if (orderDetailToRemove != null) {
            // Remove the OrderDetail from the orderDetailList
            orderT.getOrderDetailList().remove(orderDetailToRemove);
        } else {
            // If no OrderDetail found for the Ticket, return null or throw an exception
            return null; // or throw new OrderDetailNotFoundException("No order detail found for the ticket");
        }

        // Save or update OrderT
        return orderRepository.save(orderT);
    }

    @Override
    public OrderT getCurrentOrder(Customer customer) {
        // Find the current order for the customer with 'New' order state
        return orderRepository.findByCustomerAndOrderState(customer, OrderState.New);
    }
    @Override
    public double getTotalPrice(OrderT order) {
        double totalPrice = 0.0;

        // Iterate over the order details and calculate the total price
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
        // Try to find an existing order for the customer
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
        // Get the associated order from the order detail
        OrderT order = orderDetail.getOrderT();

        // Check if the order is null or closed
        if (order == null || order.getOrderState() != OrderState.New) {
            // Handle the case where the order is null or closed (throw an exception, log an error, etc.)
            // For example:
            throw new IllegalStateException("Order is null or closed");
        }

        // Add the order detail to the order
        order.getOrderDetailList().add(orderDetail);

        // Save the updated order to the database
        orderRepository.save(order);
    }




}
