package com.example.tickets2.security.entities;

import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Enums.CustomerState;
import com.example.tickets2.Repositories.CustomerRepository;
import com.example.tickets2.Services.CustomerService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId; // if something went wrong try long instead of string
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch= FetchType.EAGER)
    private List<Role> roles =new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;








}
