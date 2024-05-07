package com.example.tickets2.Controllers;

import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.OrderT;
import com.example.tickets2.Entities.Ticket;
import com.example.tickets2.Repositories.CustomerRepository;
import com.example.tickets2.Repositories.EventRepository;
import com.example.tickets2.Repositories.TicketRepository;
import com.example.tickets2.Services.CustomerService;
import com.example.tickets2.Services.OrderService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
@Controller
@AllArgsConstructor
public class CartController {
/*
    private final OrderService orderService;
    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;

    @PostMapping("/add-to-cart/{ticketId}")
    public ResponseEntity<String> addToCart(@PathVariable Long ticketId, Principal principal) {
        // Retrieve the logged-in customer's ID
        Long customerId = Long.parseLong(principal.getName());

        // Find the customer by ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Find the ticket by ID
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        // Add the ticket to the cart
        OrderT order = orderService.addItemToCart(ticket, 1, customer);

        if (order == null) {
            return ResponseEntity.badRequest().body("Failed to add ticket to cart");
        }

        return ResponseEntity.ok("Ticket added to cart successfully");
    }
    */

}
