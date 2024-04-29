package com.example.tickets2.Services;

import com.example.tickets2.Entities.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    List<Ticket> findAll();
    Ticket save(Ticket ticket);
    Ticket findById(Long id);
    Ticket update(Ticket ticket);
    void deleteById(Long id);
    void deleteTicketById(Long id);
    void deleteAllTickets();
    Ticket getTicketById(Long id);
    List<Ticket> getAllTickets();
}
