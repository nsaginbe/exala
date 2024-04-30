package com.example.exala.services;

import com.example.exala.models.Event;
import com.example.exala.models.Image;
import com.example.exala.repositories.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> eventList(String name){
        if (name != null)
            return eventRepository.findByName(name);
        return eventRepository.findAll();
    }

    public void addEvent(Event event, MultipartFile file) throws IOException {
        Image image;
        if (file.getSize() != 0){
            image = toImageEntity(file);
            event.addImageToProduct(image);
        }
        eventRepository.save(event);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }

    public Event getEventById(Long id){
        return eventRepository.findById(id).orElse(null);
    }
}
