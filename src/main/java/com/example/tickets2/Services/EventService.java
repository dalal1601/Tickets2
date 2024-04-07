package com.example.tickets2.Services;


import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventService {
    List<Event> findAll();
    Event save(Event event);
    Event findById(Long id);
    Event update(Event event);
    void deleteById(Long id);
    void deleteEventById(Long id);
    void deleteAllEvents();
    Event getEventById(Long id);
    List<Event> getAllEvents();
}
