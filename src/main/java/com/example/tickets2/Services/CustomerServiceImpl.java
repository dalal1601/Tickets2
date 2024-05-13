package com.example.tickets2.Services;


import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.OrderT;
import com.example.tickets2.Repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements  CustomerService{
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAll();

    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
    // Method to get orders for a customer
    public List<OrderT> getCustomerOrders(Customer customer) {
        return customer.getOrderTList();
    }
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
