package com.alert.collab.service;

import com.alert.collab.model.Event;
import com.alert.collab.repository.EventRepository;
import com.alert.collab.util.EventUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventUtils utils;

    public EventService(EventRepository eventRepository, EventUtils utils) {
        this.eventRepository = eventRepository;
        this.utils = utils;
    }

    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }

    public Event findById(Long id) {
        return this.utils.findEventOrThrowNotFound(id, eventRepository);
    }

    @Transactional
    public Event save(Event event) {
        return this.eventRepository.save(event);
    }

    @Transactional
    public void delete(Event event) {
        this.eventRepository.delete(event);
    }
}
