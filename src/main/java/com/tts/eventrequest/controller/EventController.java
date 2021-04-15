package com.tts.eventrequest.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.eventrequest.model.CalendarEvent;
import com.tts.eventrequest.model.Event;
import com.tts.eventrequest.model.EventForm;
import com.tts.eventrequest.repository.EventRepository;

@Controller
public class EventController
{
    @Autowired
    private EventRepository eventRepository;
    
    @GetMapping(value = "/")
    public String index(EventForm event, Model model)
    {
        model.addAttribute("event", event);
        return "index";
    }
    
    @GetMapping(value = "/calendar")
    public String calendar(Model model)
    {
        List<Event> events = eventRepository.findAll();
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        for(Event event: events)
        {
            CalendarEvent calendarEvent = new CalendarEvent(event.getEventName(), event.getEventDate(), event.getEventLocation());
            calendarEvents.add(calendarEvent);
        }
        model.addAttribute("calendarEvents", calendarEvents);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("currentDate", format.format(new Date()));
        return "calendar";
    }
    
    @GetMapping(value = "/gallery")
    public String gallery(EventForm event, Model model)
    {
        model.addAttribute("event", event);
        return "gallery";
    }
    
    @PostMapping(value = "/")
    public String addNewEvent(EventForm event, Model model)
    {
        model.addAttribute("event", event);
        Event actualEvent = event.convertToEvent();
        eventRepository.save(new Event(null, actualEvent.getEventName(),
        actualEvent.getEventDate(), actualEvent.getEventLocation(), actualEvent.getCustomerFirstName(), 
        actualEvent.getCustomerLastName(), actualEvent.getCustomerEmail()));
        model.addAttribute("eventName", actualEvent.getEventName());
        model.addAttribute("eventDate", actualEvent.getEventDate());
        model.addAttribute("eventLocation", actualEvent.getEventLocation());
        model.addAttribute("customerFirstName", actualEvent.getCustomerFirstName());
        model.addAttribute("customerLastName", actualEvent.getCustomerLastName());
        model.addAttribute("customerEmail", actualEvent.getCustomerEmail());
        return "result";
    }
}
