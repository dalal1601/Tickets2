package com.example.tickets2.Controllers;

import ch.qos.logback.core.model.Model;
import com.example.tickets2.Entities.Category;
import com.example.tickets2.Entities.Customer;
import com.example.tickets2.Entities.Event;
import com.example.tickets2.Entities.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.tickets2.Services.EventService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private EventService eventService;

    @RequestMapping("/home")
    public String home(ModelMap modelMap) {
        // Get a list of events from the database
        List<Event> eventsController = eventService.getAllEvents();

        // Add the list of events to the model
        modelMap.addAttribute("eventsVue",eventsController);

        // Return the view name
        return "Home";
    }
    @RequestMapping("/detailsEvent")
    public String detailsEvent(@RequestParam("eventId") Long eventId, ModelMap modelMap) {
        // Get the event details from the database based on the eventId
        Event event = eventService.getEventById(eventId);

        // Get the list of tickets related to the event
        List<Ticket> tickets = event.getTicketList();

        // Add the event details and tickets to the model
        modelMap.addAttribute("event", event);
        modelMap.addAttribute("tickets", tickets);

        // Return the view name for the DetailsEvent.jsp page
        return "DetailsEvent";
    }




}

