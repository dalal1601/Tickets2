package com.example.tickets2.Controllers;

import com.example.tickets2.Entities.*;
import com.example.tickets2.Enums.OrderState;
import com.example.tickets2.Services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
public class OrderController {

    private  CustomerService customerService;
    private  OrderService orderService;
    private OrderDetailsService orderDetailsService;
    private EventService eventService;
    private  TicketService ticketService;

    @GetMapping("/cart")
    public String showCart(Model model, Principal principal) {
        // Retrieve the current customer using the principal (assuming Spring Security is being used)
        String username = principal.getName();
        Customer currentCustomer = customerService.findByUsername(username);
        // Get the current order for the customer
        OrderT order = orderService.getCurrentOrder(currentCustomer);
        // Check if order is null
        if (order == null) {
            // Handle null order (maybe redirect to an error page or show a message)
            return "AccessDenied";
        }

        // Get the order details associated with the order
        List<OrderDetail> orderDetails = order.getOrderDetailList();

        // Pass the order and its details to the view
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);

        return "Cart";
    }

   /* @PostMapping("/addToCart")
    public String addToCart(@RequestParam("eventId") Long eventId, @RequestParam("ticketId") Long ticketId, Principal principal) {
        String username = principal.getName();
        Customer currentCustomer = customerService.findByUsername(username);

        // Find or create the current order for the customer
        OrderT order = orderService.findOrCreateOrder(currentCustomer);

        // Find the event and ticket
        Event event = eventService.findById(eventId);
        Ticket ticket = ticketService.findById(ticketId);

        // Create the OrderDetail using Lombok's Builder pattern
        OrderDetail orderDetail = OrderDetail.builder()
                .ticket(ticket)
                .orderT(order)
                .quantity(1.0) // Specify 1.0 as a Double
                .totalPrice(ticket.getPrice()) // Assuming total price is also ticket price
                .build();

        // Save the order detail
        orderService.addOrderDetail(orderDetail);

        return "redirect:/cart"; // Redirect to the cart page after adding the ticket to the order
    }

*/









/*
    @PostMapping("/orders/add")
    @ResponseBody
    public String addToCart(@RequestParam Long ticketId, Principal principal) {
        try {
            // Retrieve the current customer using the principal (assuming Spring Security is being used)
            String username = principal.getName();
            Customer currentCustomer = customerService.findByUsername(username);

            // Add the ticket to the cart
            Ticket ticket = ticketService.getTicketById(ticketId);
            if (ticket == null) {
                return "Ticket not found";
            }
            orderService.addItemToCart(ticket, 1, currentCustomer);
            return "Ticket added to cart";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }






 */





/*
    // Endpoint to add a ticket to the order
    @GetMapping("/detailsEvent")
    public String addToOrder(@RequestParam Long ticketId, @RequestParam int quantity,
                             @AuthenticationPrincipal Customer customer) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            return "/AccessDenied"; // Handle case where ticket is not found
        }

        orderService.addItemToCart(ticket, quantity, customer);

        // Redirect to cart page
        return "Cart";
    }

    // Endpoint to view the cart
    @GetMapping("/cart")
    public String viewCart(Model model, @AuthenticationPrincipal Customer customer) {
        OrderT order = orderService.getCurrentOrder(customer);
        if (order == null || order.getOrderDetailList().isEmpty()) {
            return "/AccessDenied"; // Handle case where cart is empty
        }

        // Get selected tickets and total price
        List<OrderDetail> orderDetails = order.getOrderDetailList();
        List<Ticket> selectedTickets = orderDetails.stream().map(OrderDetail::getTicket).collect(Collectors.toList());
        double totalPrice = orderService.getTotalPrice(order);

        model.addAttribute("selectedTickets", selectedTickets);
        model.addAttribute("totalPrice", totalPrice);

        return "Cart";
    }




    @GetMapping("/detailEvent/{eventId}/buyTicket")
    public ModelAndView buyTicket(@PathVariable("eventId") Long eventId) {
        try {
            orderService.buyTicket(eventId);
        } catch (NotEnoughTicketsAvailableException e) {
            // Handle the case where there are not enough tickets available
            // You can redirect the user back to the event detail page with an error message
            ModelAndView modelAndView = new ModelAndView("redirect:/detailEvent/" + eventId);
            modelAndView.addObject("error", e.getMessage());
            return modelAndView;
        }
        // Redirect the user to the event detail page after successfully buying a ticket
        return new ModelAndView("redirect:/detailEvent/" + eventId);
    }

 */
}


