package com.example.tickets2.Services;

import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.OrderT;
import com.example.tickets2.Entities.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderT addItemToCart(Ticket ticket, int quantity, Customer customer);

    OrderT updateItemInCart(Ticket ticket, int quantity, Customer customer);

    OrderT deleteItemFromCart(Ticket ticket, Customer customer);
}
