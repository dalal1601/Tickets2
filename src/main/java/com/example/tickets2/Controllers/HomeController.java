package com.example.tickets2.Controllers;

import ch.qos.logback.core.model.Model;
import com.example.tickets2.Entities.Category;
import com.example.tickets2.Entities.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.tickets2.Services.EventService;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private EventService eventService;

    @GetMapping("/home")
    public String home(ModelMap modelMap) {
        // Get a list of events from the database
        List<Event> events = eventService.getAllEvents();

        // Add the list of events to the model
        modelMap.addAttribute("events", events);

        // Return the view name
        return "Home";
    }

}

