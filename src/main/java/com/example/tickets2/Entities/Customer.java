package com.example.tickets2.Entities;

import com.example.tickets2.Enums.CustomerState;
import com.example.tickets2.security.entities.User;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String username;
    private String email;
    private String address;





    private CustomerState customerState = CustomerState.New;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<OrderT> orderTList  = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "customer")
    private User user;
}
