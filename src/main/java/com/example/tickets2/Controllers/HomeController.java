package com.example.tickets2.Controllers;

import com.example.tickets2.Entities.Category;
import org.springframework.ui.Model;
import com.example.tickets2.Entities.Event;
import com.example.tickets2.Entities.Ticket;
import com.example.tickets2.Repositories.CategoryRepository;
import com.example.tickets2.Repositories.EventRepository;
import com.example.tickets2.Services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedString;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/home")
    public String home(ModelMap modelMap) {
        // Get a list of events from the database
        List<Event> eventsController = eventService.getAllEvents();

        // Add the list of events to the model
        modelMap.addAttribute("eventsVue",eventsController); //ajoute la liste d'événements (eventsController) au ModelMap avec le nom "eventsVue". Cela signifie que cette liste d'événements sera disponible pour la vue sous le nom eventsVue.
        List<Category> categories = categoryRepository.findAll(); // Fetch all categories ,,,L'utilisation  du CategoryRepository est appropriée si le besoin est  de récupérer des données brutes à partir de la base de données, sans aucune logique métier supplémentaire.
        modelMap.addAttribute("categories", categories);

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

    ///////////////////////////////////////////////////////////////
    @GetMapping("/crudEvent")
    public String crudEventPage(ModelMap modelMap) {
        List<Event> events = eventService.getAllEvents();
        modelMap.addAttribute("eventsVue", events);
        return "CrudEvent";
    }

    private final CategoryRepository categoryRepository;


    @RequestMapping("/createEvent")
    public String createCustomer(ModelMap model){ //event not customer it s okkeeeeh
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("eventVue", new Event()); // Assuming you have a model attribute for the event
        return "CreateEvent";
    }
    @RequestMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("eventVue") Event eventController, @RequestParam("eventDate") String dateString){
        // Parse the dateString into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);

        // Set the parsed date to the event object
        eventController.setDateEvent(date.atStartOfDay());

        // Save the event and handle other operations as needed
        Event savedEvent = eventService.save(eventController);

        // Redirect or return a view accordingly
        return "CreateEvent";
    }

    @RequestMapping(value = "/editEvent", method = RequestMethod.GET)
    public String editEvent(@RequestParam("id") Long id, ModelMap modelMap) {
        Event event = eventRepository.findById(id).orElse(null);

        List<Category> categories = categoryRepository.findAll(); // Fetch all categories
        modelMap.addAttribute("event", event);
        modelMap.addAttribute("categories", categories);
        return "EditEvent";
    }

    @RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
    public String updateEvent(@ModelAttribute("event") Event event) {
        eventRepository.save(event);
        return "redirect:/"; // Redirect to home page or any other page after updating
    }

    @GetMapping("/deleteEvent")
    public String deleteEvent(@RequestParam("id") Long id) {
        eventService.deleteEventById(id);
        return "redirect:/crudEvent";
    }



}

