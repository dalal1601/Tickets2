package com.example.tickets2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateEvent;
    private String eventName;
    private String place;
    private String description;

    @ManyToOne
    private  Category category;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<Ticket> ticketList = new ArrayList<>();
}
