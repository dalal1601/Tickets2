package com.example.tickets2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.tickets2.Services.OrderService;
import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.OrderT;
import com.example.tickets2.Entities.OrderDetail;

@Controller
@RequestMapping("/cart")
public class TicketController {

    /*private final OrderService orderService;

    public TicketController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String viewCart(Model model, Customer customer) {
        // Get the current order for the customer
        OrderT orderT = orderService.getCurrentOrder(customer);

        // Add order details to the model
        model.addAttribute("cartItems", orderT.getOrderDetailList());
        model.addAttribute("totalPrice", orderT.getTotalPrice());

        // Return the view name for cart.html
        return "Cart";
    }
    */

}
