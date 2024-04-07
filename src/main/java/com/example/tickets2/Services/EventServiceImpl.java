package com.example.tickets2.Services;

import com.example.tickets2.Entities.Category;
import com.example.tickets2.Entities.Event;
import com.example.tickets2.Repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Override
    public Event save(Event customer) {
        return eventRepository.save(customer);
    }

    @Override
    public Event update(Event customer) {
        return eventRepository.save(customer);
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
    @Override
    public void deleteAllEvents() {
        eventRepository.deleteAll();

    }
    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }


    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).get();
    }
    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}
