package com.example.tickets2.Controllers;

import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Enums.CustomerState;
import com.example.tickets2.Services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    @RequestMapping("/createCustomer")
    public String createCustomer(){
        return "CreateCustomer";
    }
    @RequestMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customerVue") Customer customerController){
        customerController.setCustomerState(CustomerState.Active);
        Customer saveCustomer = customerService.saveCustomer(customerController);
        return "CreateCustomer";
    }

}
