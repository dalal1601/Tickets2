package com.example.tickets2.Entities;

import com.example.tickets2.Enums.TicketState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticket;
    private Double price;
    private Date createAt;

    private TicketState ticketState = TicketState.Available;

    @ManyToOne
    private  Event event;
    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList  = new ArrayList<>();
}
