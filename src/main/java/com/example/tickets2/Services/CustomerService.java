package com.example.tickets2.Services;


import com.example.tickets2.Entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long id);
    void deleteAllCustomers();
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
}
