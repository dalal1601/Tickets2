package com.example.tickets2.Services;

import com.example.tickets2.Entities.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.tickets2.Repositories.TicketRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Ticket update(Ticket ticket) {
        Ticket existingTicket = findById(ticket.getId());
        if (existingTicket != null) {
            existingTicket.setTicket(ticket.getTicket());
            existingTicket.setPrice(ticket.getPrice());
            existingTicket.setCreateAt(ticket.getCreateAt());
            existingTicket.setTicketState(ticket.getTicketState());
            existingTicket.setEvent(ticket.getEvent());
            existingTicket.setOrderDetailList(ticket.getOrderDetailList());
            // Save and return the updated ticket
            return ticketRepository.save(existingTicket);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void deleteAllTickets() {
        ticketRepository.deleteAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
