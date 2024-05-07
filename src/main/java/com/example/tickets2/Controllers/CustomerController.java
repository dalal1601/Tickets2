package com.example.tickets2.Controllers;

import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Enums.CustomerState;
import com.example.tickets2.Services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.modelmbean.ModelMBean;
import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    @RequestMapping("/createCustomer")
    public String createCustomer(){
        return "CreateCustomer";
    }
    @RequestMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customerVue") Customer customerController){ //@ModelAttribute lie les valeurs des champs du formulaire HTML
        customerController.setCustomerState(CustomerState.Active);// un objet "customerVue"
        Customer saveCustomer = customerService.saveCustomer(customerController);
        return "CreateCustomer";
    }
    @RequestMapping("/customersList")
    public String customersList(ModelMap modelMap){  //  utilisée pour transporter des données entre un contrôleur et une vu
        List<Customer> customersController = customerService.getAllCustomers();
        modelMap.addAttribute("customersVue",customersController);

        return "CustomersList";
    }
    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id")Long id, ModelMap modelMap){
        customerService.deleteCustomerById(id);
        return customersList(modelMap);

    }
    @RequestMapping("/editCustomer")
    public String editCustomer(@RequestParam("id")Long id,ModelMap modelMap){
        Customer customerController = customerService.getCustomerById(id);
        modelMap.addAttribute("customerView",customerController);
        return "EditCustomer";
    }
    @RequestMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute ("customerVue") Customer customerController){
        customerService.updateCustomer(customerController);
        return createCustomer();
    }



}
