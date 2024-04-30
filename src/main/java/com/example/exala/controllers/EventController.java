package com.example.exala.controllers;

import com.example.exala.models.Event;
import com.example.exala.models.Image;
import com.example.exala.services.EventService;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String events(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("events", eventService.eventList(name));
        return "events";
    }

    @GetMapping("/event/{id}")
    public String eventInfo(@PathVariable Long id, Model model){
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("images", event.getImages());
        return "event-info";
    }

    @PostMapping("/event/create")
    public String createEvent(@RequestParam("file") MultipartFile file, Event event) throws IOException {
        eventService.addEvent(event, file);
        return "redirect:/";
    }

    @PostMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
