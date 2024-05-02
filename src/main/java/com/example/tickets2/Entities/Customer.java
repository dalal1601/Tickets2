package com.example.tickets2.Entities;

import com.example.tickets2.Enums.CustomerState;
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
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    private CustomerState customerState = CustomerState.New;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<OrderT> orderTList  = new ArrayList<>();
}
